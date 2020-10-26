package com.jianjun.study.week4;

import java.io.*;

/**
 * @ClassName FireReadDemo
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/26
 **/
public class FireCopyDemo {
    public static void main(String[] args) throws IOException {
        //创建一个文件file对象，要显式抛出异常（IOException是编译时异常）
        File file = new File("D:\\图片\\树0000.jpg");
        //创建一个字节输入流，此处有上转型对象
        InputStream is = new FileInputStream(file);
        //准备和文件大小一致的数组
        byte[] bytes = new byte[(int) file.length()];
        //通过字节输入流将文件读入数组
        is.read(bytes);
        //准备输出文件对象
        File outputFile = new File("D:\\图片\\树00001.jpg");
        //准备输出流
        OutputStream os = new FileOutputStream(outputFile);
        os.write(bytes);
        is.close();
        os.close();
    }
}
