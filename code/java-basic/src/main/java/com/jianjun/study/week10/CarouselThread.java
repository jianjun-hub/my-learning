package com.jianjun.study.week10;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName CarouselThread
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class CarouselThread implements Runnable {
    private String[] imgs = {"https://tse3-mm.cn.bing.net/th/id/OIP.g80_OQO9owhktAY9p-av4QHaKc?w=206&h=290&c=7&o=5&dpr=1.25&pid=1.7",
            "https://tse4-mm.cn.bing.net/th/id/OIP.DH-sl0dYREvLnyAcBuOlnQHaLH?w=204&h=306&c=7&o=5&dpr=1.25&pid=1.7",
            "https://tse3-mm.cn.bing.net/th/id/OIP.bLx51CquIR2c5rp7BN1GjwHaLI?w=203&h=306&c=7&o=5&dpr=1.25&pid=1.7"
    };
    private JLabel bgLable;

    public void setBgLable(JLabel bgLable) {
        this.bgLable = bgLable;
    }


    @Override
    public void run() {
        int index = 0;
        int len = imgs.length;

        while (true) {
            try {
                URL url = new URL(imgs[index]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                //得到连接目标的输入流
                InputStream is = connection.getInputStream();
                //字节缓冲输出流
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                //缓冲区
                byte[] buffer = new byte[1024];
                int length = 0;
                //通过缓冲区读取文件
                while ((length = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }
                byte[] bytes = baos.toByteArray();
                //将字节数组通过字节输入流读入
                is.read(bytes);
                //通过bytes构建图标icon
                Icon icon = new ImageIcon(bytes);
                //将icon设置为背景标签的图标
                this.bgLable.setIcon(icon);
                Thread.sleep(2000);
                baos.close();
                is.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            index++;
            //处理数组最后一个元素
            if (index == len) {
                index = 0;
            }
        }


    }
}
