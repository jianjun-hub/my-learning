package com.jianjun.study.week10;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TextThread
 * @Description TODO
 * @Author DARKW
 * @Date 2020/12/7
 **/
public class TextThread implements Runnable {
    private JLabel textLable;
    private String pathName = "D:\\text.txt";
    public void setTextLable(JLabel textLable){
        this.textLable = textLable;
    }
    @SneakyThrows
    @Override
    public void run() {
        int index = 0;
        FileReader fileReader = new FileReader(pathName);
        BufferedReader br = new BufferedReader(fileReader);
        List<String> list = new ArrayList<>();
        while (br.readLine()!=null){
            list.add(br.readLine());
        }
        int len = list.size();
        br.close();
        fileReader.close();
        System.out.println(len);
        while (true){
            if(index == len){
                index = 0;
            }
            textLable.setText(list.get(index));
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            index++;
        }
    }
}
