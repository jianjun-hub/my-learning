package com.jianjun.study.week9;

import java.io.*;
import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName TxtFileTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/30
 **/
public class TxtFileTest {
    public static void main(String[] args) throws IOException {
        //从键盘输入一串文本保存到文件中
//        //方法1：使用FileWriter结合字符写入
//        Scanner scanner  = new Scanner(System.in);
//        System.out.println("请输入");
//        String s = scanner.next();
//        char[] chars = s.toCharArray();
//        File file  = new File("D:"+File.separator+"result.txt");
//        Writer out = new FileWriter(file,true);
//        out.write(chars);
//        out.close();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String s = scanner.next();
        String fileName  = UUID.randomUUID().toString();
        //方法1
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\"+fileName+".txt");
        byte[] bytes = s.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        //方法2
        String fileName1  = UUID.randomUUID().toString();
        File file = new File("D:\\"+fileName1+".txt");
        file.createNewFile();
        FileWriter  fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(s);
        bufferedWriter.close();
        //方法三
        String fileName2  = UUID.randomUUID().toString();
        FileOutputStream fileOutputStream1 = new FileOutputStream("D:\\"+fileName2+".txt");
        byte[] bytes1 = s.getBytes();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream1);
        bufferedOutputStream.write(bytes1);
        bufferedOutputStream.close();





    }
}
