package com.jianjun.study.week9;

import java.io.File;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/30
 **/
public class FileTest {
    public static void main(String[] args) {
        //创建文件
//        File file = new File("D:" + File.separator + "1.txt");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getName());
        //创建目录
//        LocalDate date = LocalDate.now();
//        String dirName = date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth();
//        File dir  = new File("D:"+ File.separator+dirName);
//        if(!dir.exists()){
//            boolean flag = dir.mkdirs();
//            System.out.println(flag);
//        }
        //删除目录
//        if(dir.exists()){
//            System.out.println(dir.delete());
//        }
        //创建带层级的目录
        File topDir  = new File("D:"+File.separator+"Java");
        if(!topDir.exists()){
            boolean flag =  topDir.mkdirs();
            System.out.println(flag);
        }

        String[] level1Dir = {"面向对象","异常","集合","io","多线程"};
        for (int i = 0; i < level1Dir.length; i++) {
            File dir = new File("D:\\java"+File.separator+level1Dir[i]);
            if(!dir.exists()){
                boolean flag = dir.mkdirs();
                System.out.println(flag);
            }
        }

        String[] level2Dir = {"字符流","字节流"};
        for (int i = 0; i < level2Dir.length; i++) {
            File dir = new File("D:\\java\\io"+File.separator+level2Dir[i]);
            if(!dir.exists()){
                boolean flag = dir.mkdirs();
                System.out.println(flag);
            }
        }


    }
}