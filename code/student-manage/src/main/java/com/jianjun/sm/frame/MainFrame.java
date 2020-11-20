package com.jianjun.sm.frame;

import com.jianjun.sm.entity.Department;
import com.jianjun.sm.factory.ServiceFactory;

import javax.swing.*;
import java.awt.*;
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

    private final CardLayout c;


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
    public static void main(String[] args) {
        new MainFrame();
    }


}
