package com.ordersystem.controller;

import com.ordersystem.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

        return Result.success(originalFilename);
    }
}
