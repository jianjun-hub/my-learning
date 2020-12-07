package com.jianjun.study.week10;

import java.awt.*;
import java.util.Random;

/**
 * @ClassName LineThread
 * @Description 绘制线段
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class LineThread implements Runnable {
    private int x = 300;
    private int y = 100;
    private Frame frame;

    private Color[] colors = {Color.darkGray, Color.cyan,  Color.orange, Color.pink, Color.white};

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //得到窗体的绘图对象
            Graphics g = this.frame.getGraphics();
            Random random = new Random();
            //得到colors数组的随机下标
            int index = random.nextInt(colors.length);
            g.setColor(colors[index]);
            g.drawLine(x, y, 400, 600);
            x += 50;
            y += 30;
            if(x>=1000){
                break;
            }
        }
    }


}
