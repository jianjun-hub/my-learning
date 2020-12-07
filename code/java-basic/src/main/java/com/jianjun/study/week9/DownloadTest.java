package com.jianjun.study.week9;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName Download
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/30
 **/
public class DownloadTest {
    public static void main(String[] args) {
        try {
            download("https://img3.mukewang.com/5fbdc05b0001498717920764.jpg","my.jpg","D:\\");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void download(String urlString, String fileName, String savePath) throws IOException {
        //构造url
        URL url = new URL(urlString);
        //打开连接
        URLConnection connection = url.openConnection();
        //设置请求超时
        connection.setConnectTimeout(5000);
        //构建输入流
        InputStream inputStream = connection.getInputStream();
        //定义数据缓冲
        byte[] bytes = new byte[1024];
        //读取数据长度
        int len;
        //创建文件对象
        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //构建输出文件流
        OutputStream outputStream = new FileOutputStream(file.getPath() + File.separator + fileName);
        //开始读取，每次读取缓冲区大小的字节流
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }
}
