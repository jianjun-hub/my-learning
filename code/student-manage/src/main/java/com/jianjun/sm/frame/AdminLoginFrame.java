package com.jianjun.sm.frame;

import com.jianjun.sm.entity.ResultEntity;
import com.jianjun.sm.factory.ServiceFactory;

import javax.swing.*;

/**
 * @ClassName AdminLoginFrame
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/16
 **/
public class AdminLoginFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton LoginButton;
    private JButton ReSetButton;

    public AdminLoginFrame() {
        this.setTitle("AdminLoginFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        LoginButton.addActionListener(e -> {
            //获得输入的帐号和密码，注意密码框组件的使用方法
            String account = accountField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
            JOptionPane.showMessageDialog(mainPanel, resultEntity.getMessage());
            if (resultEntity.getCode() == 0) {
                //关闭登录页面，进入主界面
                this.dispose();
            } else {
                accountField.setText("");
                passwordField.setText("");
            }
        });

        ReSetButton.addActionListener(e -> {
            accountField.setText("");
            passwordField.setText("");

        });




    }

    public static void main(String[] args){
        new AdminLoginFrame();
    }
}
