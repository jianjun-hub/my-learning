package com.jianjun.study.week10;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName TimeThread
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class TimeThread implements Runnable{
    private JLabel timeLable;
    public void setTimeLable(JLabel timeLable){
        this.timeLable  = timeLable;
    }

    @Override
    public void run() {
        while (true){
            timeLable.setText(LocalDateTime.now().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
