package com.jianjun.sm.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;
import java.util.UUID;

/**
 * @ClassName AliossUti
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/20
 **/
public class AliossUtil {
    /**
     *
     * 将本地文件上传到阿里云指定域名母鹿下，并用UUID重命名
     *  @param file 待传文件
     * @return String 上传成功返回的url
     */
    public static String ossUpLoad(File file){
        String bucketDomain = "https://mirrer.oss-cn-huhehaote.aliyuncs.com/";
        String endPoint= "https://oss-cn-huhehaote.aliyuncs.com";

        String accessKeyId ="LTAI4GDKuuqBP39vvQb5M9vk";
        String accessKeySecret = "mD2dWKYv05e6Th2qSPtNGSDhNybPqT";

        //Bucket名称
        String bucketName = "mirrer";
        String fileDir = "studentManager/";
        //获得本地上传的文件名
        String fileName = file.getName();
        //上传后的文件名生成，根据用户的文件保留拓展名，主文件名用UUID生成
        String fileKey = UUID.randomUUID().toString()+fileName.substring(fileName.indexOf("."));;
        //创建OssClient实例
        OSS ossClient = new OSSClientBuilder().build(endPoint,accessKeyId,accessKeySecret);
        //上传文件到bucketName的fileDir目录下,用fileKey作为新文件存储
        ossClient.putObject(bucketName,fileDir+fileKey,file);
        //关闭oss上传实例
        return bucketDomain+fileDir+fileKey;

    }

}
