package com.jianjun.study.week10;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName CarouselFrame
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class CarouselFrame extends JFrame {
    private  JLabel bgLable;
    private  JLabel timeLable;
    private JLabel textLable;
    public CarouselFrame(){
        init();
        setTitle("Line frame");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init(){
        bgLable = new JLabel();
        CarouselThread carouselThread = new CarouselThread();
        carouselThread.setBgLable(bgLable);
        new Thread(carouselThread).start();;

        this.getContentPane().add(bgLable,BorderLayout.CENTER);
        timeLable = new JLabel(LocalDateTime.now().toString());
        timeLable.setFont(new Font("微软雅黑",Font.BOLD,16));
        this.getContentPane().add(timeLable,BorderLayout.SOUTH);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLable(timeLable);
        new Thread(timeThread).start();

        textLable = new JLabel();
        textLable.setFont(new Font("微软雅黑",Font.BOLD,16));
        this.getContentPane().add(textLable,BorderLayout.NORTH);
        TextThread textThread = new TextThread();
        textThread.setTextLable(textLable);
        new Thread(textThread).start();


    }

    public static void main(String[] args) {
        new CarouselFrame();
    }
}
