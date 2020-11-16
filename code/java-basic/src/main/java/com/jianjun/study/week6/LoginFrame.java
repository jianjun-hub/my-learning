package com.jianjun.study.week6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName LoginFrame
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/9
 **/
public class LoginFrame {
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel logoPanel;
    private JPanel loginPanel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginButton;
    private JPanel buttomPanel;
    private JLabel logoLabel;
    private JLabel tipLabel;
    private JLabel loginLabel;

    public LoginFrame() {
        loginButton.addActionListener(e -> {
            LoginService ll = new loginService();
            String
        });
    }

    public static void main(String[] args) {
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width);
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize().height);
        JFrame frame = new JFrame("LoginFrame");
        frame.setContentPane(new LoginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

}
