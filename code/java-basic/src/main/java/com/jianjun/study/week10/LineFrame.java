package com.jianjun.study.week10;

import javax.activation.MailcapCommandMap;
import javax.swing.*;
import java.awt.*;

/**
 * @ClassName LineFrame
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class LineFrame extends JFrame {
    public LineFrame(){
        init();
        getContentPane().setBackground(new Color(0,0,0));
        setTitle("Line frame");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init(){
        LineThread lineThread = new LineThread();
        lineThread.setFrame(this);
        new Thread(lineThread).start();
    }

    public static void main(String[] args) {
        new LineFrame();
    }

}
