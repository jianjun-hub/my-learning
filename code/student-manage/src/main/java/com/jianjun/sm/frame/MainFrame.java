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
    private JPanel ClassPanel;
    private JPanel studentPanel;
    private JPanel rewarPanel;

    public MainFrame() {
        this.setTitle("MainFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        showDepartments();

    }

    /**
     * 显示所有院系信息
     */

    private void showDepartments () {
        //移除原有数据
        departmentPanel.removeAll();
        //从service获取到所有院系列表
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        //获取总数
        int len = departmentList.size();
        //根据院系总数算出行数（每行放四个）
        int row = len % 4 == 0 ? len : len + 1;
        //创建一个网格布局，每行四列，指定水平和垂直间距
        GridLayout gridLayout = new GridLayout(row, 4, 15, 15);
        departmentPanel.setLayout(gridLayout);
        for (Department department : departmentList) {
            //给每个院系创建一个面板
            JPanel depPanel = new JPanel();
            //设置合适大小
            depPanel.setPreferredSize(new Dimension(200, 200));
            //根据院系名称设置面板标题
            depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            //新建一个JLabel标题，用来放置院系logo,并指定大小
            JLabel logoLabel = new JLabel("<html><img src='" + department.getLogo() + "' width=200 height=200 /></html> ");
            //图标标签加入院系面板
            depPanel.add(logoLabel);
            //院系面板加入主体内容面板
            departmentPanel.add(depPanel);
            //刷新主体内容面板
            departmentPanel.revalidate();

        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
