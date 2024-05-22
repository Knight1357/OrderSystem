package com.ordersystem.controller;

import com.ordersystem.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

@RestController
public class FileController {

    //上传文件
    @PostMapping("/common/upload")
    //MultipartFile 是Springboot专门用于接受文件数据类型
    //file 对象中会封装文件的数据，包括文件夹的名字等...
    public Result upload(MultipartFile file) throws Exception{
        //1.生成一个唯一的文件名字
        String originalFilename = file.getOriginalFilename();//获取后缀名
        int lastIndex = originalFilename.lastIndexOf(".");//获取 '.' 的下标

        String suffix = originalFilename.substring(lastIndex);//截取 ".png"
        String uniqueStr = UUID.randomUUID().toString();//jsdlaienwqlasidj
        String filename=uniqueStr+suffix;

        //2.把文件存到本地文件夹的某个文件中
        String filePath="/Users/liushen/IDEAProjects/OrderSystem/src/main/resources/pics/";

        file.transferTo(new File(filePath+filename));

        return Result.success(filename);
    }
    //文件下载
    @GetMapping("/common/download")
    public void download(String name, HttpServletResponse response) throws Exception{
        //把本地pics文件中名字为name的图片内容响应给浏览器  文件处理知识  IO流
        String filePath="/Users/liushen/IDEAProjects/OrderSystem/src/main/resources/pics/";

        String filename=filePath+name;

        //1. 准备一个读取流，读取本地文件到程序中
        FileInputStream fis =new FileInputStream(filename);

        //2. 准备一个输出流，用于吧程序中的尼尔，输出给浏览器
        ServletOutputStream os=response.getOutputStream();

        //3. 一边读取一遍输出即可
        byte[] bys=new byte[1024];
        int len=-1;
        while ((len=fis.read(bys))!=-1){
            os.write(bys,0,len);
        }
    }
}
