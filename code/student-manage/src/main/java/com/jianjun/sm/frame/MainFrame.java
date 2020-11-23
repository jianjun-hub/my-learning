package com.jianjun.sm.frame;

import com.jianjun.sm.component.CustemPanel;
import com.jianjun.sm.dao.StudentDao;
import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.entity.Department;
import com.jianjun.sm.factory.ServiceFactory;
import com.jianjun.sm.utils.AliossUtil;
import com.jianjun.sm.vo.StudentVo;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/17
 **/
public class MainFrame extends JFrame {
    /**
     * 选择院系id
     */
    private int departmentId = 0;

    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton 院系管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPanel;
    private JPanel bottomPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel addDepartmentPanel;
    private JTextField depNameField;
    private JButton 选择图片Button;
    private JLabel logoLabel;
    private JPanel toolBarPanel;
    private JButton 新增院系Button;
    private JButton 切换显示Button;
    private JPanel contentPanel;
    private JButton 新增Button;
    private JComboBox<Department> depComboBox;
    private JTextField classNameField;
    private JPanel treePanel;
    private JPanel classContentPanel;
    private JPanel classToolPanel;
    private JButton 新增班级Button;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JButton 搜索Button;
    private JButton 新增Button1;
    private JButton 批量导入Button;
    private JPanel tablePanel;

    private final CardLayout c;

    private String upLoadFileUrl;
    private File file;


    public MainFrame() {
        init();
        c = new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1", departmentPanel);
        centerPanel.add("2", classPanel);
        centerPanel.add("3", studentPanel);
        centerPanel.add("4", rewardPanel);

        院系管理Button.addActionListener(e -> {
            c.show(centerPanel, "1");
        });
        班级管理Button.addActionListener(e -> {
            c.show(centerPanel, "2");
            showClazz();
        });
        学生管理Button.addActionListener(e -> {
            c.show(centerPanel, "3");
            showStudents();
        });
        奖惩管理Button.addActionListener(e -> {
            c.show(centerPanel, "4");
        });

        新增院系Button.addActionListener(e -> {
            boolean visible = addDepartmentPanel.isVisible();
            if (!visible) {
                leftPanel.setPreferredSize(new Dimension(180, this.getHeight() - 100));
                addDepartmentPanel.setVisible(true);
            } else {
                leftPanel.setPreferredSize(new Dimension(50, this.getHeight() - 100));
                addDepartmentPanel.setVisible(false);
            }
        });

        //院系名称文本框焦点监听
        depNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
        });

        选择图片Button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            //默认打开路径
            fileChooser.setCurrentDirectory(new File("D:\\cloudy\\update\\"));
            //对话框显示的范围在centerPanel内
            int result = fileChooser.showOpenDialog(centerPanel);
            if (result == JFileChooser.APPROVE_OPTION) {
                //选中文件
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                //创建icon对象
                ImageIcon icon = new ImageIcon(name);
                logoLabel.setPreferredSize(new Dimension(150, 150));
                //图片强制缩放成和JLable一样大小
                icon = new ImageIcon(icon.getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_DEFAULT));
                logoLabel.setIcon(icon);
            }
        });

        depComboBox.addActionListener(e -> {
            //得到选中项的索引
            int index = depComboBox.getSelectedIndex();
            //按照索引取出项，然后取出其id
            departmentId = depComboBox.getItemAt(index).getId();
        });

        新增Button.addActionListener(e -> {
            //上传文件到oss并返回url
            upLoadFileUrl = AliossUtil.ossUpLoad(file);
            //创建Department对象，并设置相应属性
            Department department = new Department();
            department.setDepartmentName(depNameField.getText().trim());
            department.setLogo(upLoadFileUrl);
            //调用service实现新增功能
            int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
            if (n == 1) {
                JOptionPane.showMessageDialog(centerPanel, "新增院系成功");
                //新增成功后，将侧边栏隐藏
                leftPanel.setPreferredSize(new Dimension(50, this.getHeight() - 100));
                addDepartmentPanel.setVisible(false);
                //刷新界面数据
                showDepartments();
                //清空文本域
                depNameField.setText("");
                logoLabel.setIcon(null);

            } else {
                JOptionPane.showMessageDialog(centerPanel, "新增院系失效");
            }
        });

        新增班级Button.addActionListener(e -> {
            Clazz clazz = new Clazz();
            clazz.setDepartmentId(departmentId);
            clazz.setClassName(classNameField.getText().trim());
            int n = ServiceFactory.getClazzServiceInstance().addClazz(clazz);
            if (n == 1) {
                JOptionPane.showMessageDialog(centerPanel, "新增班级成功！");
                showClazz();
            } else {
                JOptionPane.showMessageDialog(centerPanel, "新增班级失败！");
            }
        });


        showDepartments();

    }


    public void init() {
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }


    /**
     * 显示所有院系信息
     */

    private void showDepartments() {
        //移除原有数据
        contentPanel.removeAll();
        //从service获取到所有院系列表
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        //获取总数
        int len = departmentList.size();
        //根据院系总数算出行数（每行放四个）
        int row = len % 4 == 0 ? len / 4 : len / 4 + 1;
        //创建一个网格布局，每行四列，指定水平和垂直间距
        GridLayout gridLayout = new GridLayout(row, 4, 15, 15);
        contentPanel.setLayout(gridLayout);
        for (Department department : departmentList) {
            //给每个院系创建一个面板
            JPanel depPanel = new JPanel();
            depPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
            //设置合适大小
            depPanel.setPreferredSize(new Dimension(200, 200));
            //根据院系名称设置面板标题
            JLabel depName = new JLabel(department.getDepartmentName());
            //新建一个JLabel标题，用来放置院系logo,并指定大小
            JLabel logoLabel = new JLabel("<html><img src='" + department.getLogo() + "' width=200 height=200 /></html> ");
            //新建一个Button用来放置删除按钮
            JButton delButton = new JButton("删除");
            delButton.addActionListener(e -> {
                int id = department.getId();
                delDepartments(id);
            });
            //院系名称加入院系面板
            depPanel.add(depName);
            //图标标签加入院系面板
            depPanel.add(logoLabel);
            //删除按钮加入院系面板
            depPanel.add(delButton);
            //院系面板加入主体内容面板
            contentPanel.add(depPanel);
            //刷新主体内容面板
            departmentPanel.validate();
        }
    }

    public void delDepartments(int id) {
        int n = 0;
        n = ServiceFactory.getDepartmentServiceInstance().delDep(id);
        if (n == 1) {
            JOptionPane.showMessageDialog(centerPanel, "删除院系成功！");
            showDepartments();
        } else {
            JOptionPane.showMessageDialog(centerPanel, "删除院系失败！");
        }

    }

    private void showClazz() {
        List<Department> departments = ServiceFactory.getDepartmentServiceInstance().selectAll();
        showCombobox(departments);
        showTree(departments);
        showClazz(departments);
    }

    private void showCombobox(List<Department> departments) {
        for (Department department : departments) {
            depComboBox.addItem(department);
        }
    }

    private void showTree(List<Department> departments) {
        treePanel.removeAll();
        //左侧树组件到根节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("南京工业职业技术大学");
        for (Department department : departments) {
            //院系名称作为一级叶子节点
            DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
            //加入根节点，构成一棵树
            root.add(group);
            List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectClazzById(department.getId());
            for (Clazz clazz : clazzList) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(clazz.getClassName());
                group.add(node);
            }
        }
        //以root为根生成树
        final JTree tree = new JTree(root);
        tree.setRowHeight(30);
        tree.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        treePanel.add(tree, BorderLayout.CENTER);
        treePanel.revalidate();
    }

    private void showClazz(List<Department> departments) {
        classContentPanel.removeAll();
        classContentPanel.setLayout(new GridLayout(0, 5, 15, 15));
        Font titleFont = new Font("微软雅黑", Font.PLAIN, 16);
        for (Department department : departments) {
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(120, 150));
            depPanel.setBackground(new Color(63, 98, 131));
            depPanel.setLayout(new BorderLayout());
            JLabel depNameLabel = new JLabel(department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setForeground(new Color(255, 255, 255));
            depPanel.add(depNameLabel, BorderLayout.NORTH);
            List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectClazzById(department.getId());
            DefaultListModel<Clazz> listModel = new DefaultListModel<>();
            for (Clazz clazz : clazzList) {
                listModel.addElement(clazz);
            }
            JList<Clazz> jList = new JList<>(listModel);
            jList.setBackground(new Color(101, 134, 184));
            JScrollPane scrollPane = new JScrollPane(jList);
            depPanel.add(scrollPane, BorderLayout.CENTER);
            classContentPanel.add(depPanel);
            //对每个list弹出菜单
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem modifyItem = new JMenuItem("修改");
            JMenuItem deleteItem = new JMenuItem("删除");
            jPopupMenu.add(modifyItem);
            jPopupMenu.add(deleteItem);
            jList.add(jPopupMenu);
            //对jList添加鼠标监听
            jList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int index = jList.getSelectedIndex();
                    //点击鼠标右键
                    if (e.getButton() == 3) {
                        //在鼠标位置弹出菜单
                        jPopupMenu.show(jList, e.getX(), e.getY());
                        //取出选中项班级的对像数据
                        Clazz clazz = jList.getModel().getElementAt(index);
                        //对“删除”菜单项添加事件监听
                        deleteItem.addActionListener(el -> {
                            int choice = JOptionPane.showConfirmDialog(depPanel, "确定删除吗？");
                            //点击了确定
                            if (choice == 0) {
                                //根据当前班级的id删除
                                int n = ServiceFactory.getClazzServiceInstance().delClazz(clazz.getId());
                                if (n == 1) {
                                    //从list模型中骑移除当前项，先看到删除效果
                                    listModel.remove(index);
                                    //走后端重新调用下数据
                                    showTree(ServiceFactory.getDepartmentServiceInstance().selectAll());
                                }
                            }
                        });
                    }
                }
            });
        }

    }

    private void showStudents() {
        CustemPanel stuInfoPanel = new CustemPanel("D:\\java-lerning\\img\\OIP.F0cjt8kNfiBG9eGpdZgAxAHaKb.jpg");
        stuInfoPanel.setPreferredSize(new Dimension(300, 600));
        JLabel title = new JLabel("学生信息");
        title.setFont(new Font("楷体", Font.BOLD, 20));
        title.setForeground(new Color(97, 174, 239));
        stuInfoPanel.add(title);
        stuInfoPanel.repaint();
        studentPanel.add(stuInfoPanel, BorderLayout.EAST);
        //获得学生列表数据
        List<StudentVo> students = ServiceFactory.getStudentServiceInstance().selectAll();
        //创建表格对象
        JTable table = new JTable();
        //创建表格数据模型，并设置给表格
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //设置表头内容
        model.setColumnIdentifiers(new String[]{"学号", "院系", "班级", "姓名", "性别", "地址", "手机号", "出生日期", "头像"});
        //遍历list，生成object数组，数组中每个元素是一行记录
        for (StudentVo student : students) {
            Object[] object = new Object[]{
                    student.getId(), student.getDepartmentName(), student.getClassName(),
                    student.getStudentName(), student.getGender(),
                    student.getAddress(), student.getPhone(), student.getBirthday(),
                    student.getAvatar()
            };
            //添加到数据模型
            model.addRow(object);
        }
        //设置最后一列不显示在表格中
        TableColumn tc = table.getColumnModel().getColumn(8);
        tc.setMaxWidth(0);
        tc.setMinWidth(0);
        //获得表格的表头
        JTableHeader header = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        header.setDefaultRenderer(hr);
        //设置表头字体
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setFont(new Font("楷体", Font.PLAIN, 18));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(223, 241, 234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板，并设置水平和垂直方向均可按需滚动
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);
        //表格内容监听，根据点击得到不同的数据
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            JOptionPane.showMessageDialog(null, table.getValueAt(row,2).toString() + table.getValueAt(row, 3).toString());
        });
    }

    public static void main(String[] args) {
        new MainFrame();
    }


}
