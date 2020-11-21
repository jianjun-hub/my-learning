package com.jianjun.sm.frame;

import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.entity.Department;
import com.jianjun.sm.factory.ServiceFactory;
import com.jianjun.sm.utils.AliossUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.util.List;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/17
 **/
public class MainFrame extends JFrame {
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
    private JComboBox depComboBox;
    private JTextField searchField;
    private JPanel treePanel;
    private JPanel classContentPanel;
    private JPanel classToolPanel;

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

        选择图片Button.addActionListener(e ->{
            JFileChooser fileChooser = new JFileChooser();
            //默认打开路径
            fileChooser.setCurrentDirectory(new File("D:\\cloudy\\update\\"));
            //对话框显示的范围在centerPanel内
            int result = fileChooser.showOpenDialog(centerPanel);
            if(result == JFileChooser.APPROVE_OPTION){
                //选中文件
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                //创建icon对象
                ImageIcon icon = new ImageIcon(name);
                logoLabel.setPreferredSize(new Dimension(150,150));
                //图片强制缩放成和JLable一样大小
                icon = new ImageIcon(icon.getImage().getScaledInstance(logoLabel.getWidth(),logoLabel.getHeight(),Image.SCALE_DEFAULT));
                logoLabel.setIcon(icon);
            }
        });

        新增Button.addActionListener(e->{
            //上传文件到oss并返回url
            upLoadFileUrl = AliossUtil.ossUpLoad(file);
            //创建Department对象，并设置相应属性
            Department department = new Department();
            department.setDepartmentName(depNameField.getText().trim());
            department.setLogo(upLoadFileUrl);
            //调用service实现新增功能
            int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
            if(n==1){
                JOptionPane.showMessageDialog(centerPanel,"新增院系成功");
                //新增成功后，将侧边栏隐藏
                leftPanel.setPreferredSize(new Dimension(50,this.getHeight()-100));
                addDepartmentPanel.setVisible(false);
                //刷新界面数据
                showDepartments();
                //清空文本域
                depNameField.setText("");
                logoLabel.setIcon(null);

            }else {
                JOptionPane.showMessageDialog(centerPanel,"新增院系失效");
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

    public void delDepartments(int id){
        ServiceFactory.getDepartmentServiceInstance().delDep(id);
        showDepartments();
    }

    private void showClazz(){
        List<Department> departments = ServiceFactory.getDepartmentServiceInstance().selectAll();
        showCombobox(departments);
        showTree(departments);
        showClazz(departments);
    }

    private  void showCombobox(List<Department> departments){
        for(Department department:departments){
            depComboBox.addItem(department);
        }
    }

    private void showTree(List<Department> departments){
        treePanel.removeAll();
        //左侧树组件到根节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("南京工业职业技术大学");
        for (Department department:departments){
            //院系名称作为一级叶子节点
            DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
            //加入根节点，构成一棵树
            root.add(group);
            List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectClazzById(department.getId());
            for (Clazz clazz:clazzList){
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(clazz.getClassName());
                group.add(node);
            }
        }
        //以root为根生成树
        final JTree tree = new JTree(root);
        tree.setRowHeight(30);
        tree.setFont(new Font("微软雅黑",Font.PLAIN,14));
        treePanel.add(tree, BorderLayout.CENTER);
        treePanel.revalidate();
    }

    private void showClazz(List<Department> departments){
        classContentPanel.removeAll();
        classContentPanel.setLayout(new GridLayout(0,5,15,15));
        Font titleFont = new Font("微软雅黑",Font.PLAIN,16);
        for (Department department:departments){
            JPanel depPanel  = new JPanel();
            depPanel.setPreferredSize(new Dimension(120,150));
            depPanel.setBackground(new Color(63,98,131));
            depPanel.setLayout(new BorderLayout());
            JLabel depNameLabel = new JLabel(department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setForeground(new Color(255,255,255));
            depPanel.add(depNameLabel,BorderLayout.NORTH);
            List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectClazzById(department.getId());
            DefaultListModel<Clazz> listModel =new DefaultListModel<>();
            for(Clazz clazz:clazzList){
                listModel.addElement(clazz);
            }
            JList<Clazz> jList = new JList<>(listModel);
            jList.setBackground(new Color(101,134,184));
            JScrollPane scrollPane = new JScrollPane(jList);
            depPanel.add(scrollPane,BorderLayout.CENTER);
            classContentPanel.add(depPanel);
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }


}
