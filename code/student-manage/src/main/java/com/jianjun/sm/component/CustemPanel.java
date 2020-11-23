package com.jianjun.sm.component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName 自定义面板
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/23
 **/
public class CustemPanel extends JPanel {
    private final String path;

    public CustemPanel(String path){
        this.path = path;
    }
    /**
     * 绘制背景图片，允许这个panel在图片上添加其他组件
     *
     * @param g 绘制图像
     */

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Image bg = null;
    try {
        bg = ImageIO.read(new File(path));
    } catch (IOException e) {
        e.printStackTrace();
    }
    g.drawImage(bg,8,8,getWidth(),getHeight(),null);
    }
}
