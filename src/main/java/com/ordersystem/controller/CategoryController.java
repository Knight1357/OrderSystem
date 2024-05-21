package com.ordersystem.controller;


import com.ordersystem.mapper.CategoryMapper;
import com.ordersystem.pojo.Category;
import com.ordersystem.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;


@RestController
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;
    @PostMapping("/category")
    public Result addCategory(@RequestBody Category category, HttpSession session){
        //调用CategoryMapper方法完成数据库的添加
        //添加之前，填充前端未提供的数据
        //填充创建时间和更新时间
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        //创建更新人
        Integer id = (Integer) session.getAttribute("id");
        category.setCreateUser(id);
        category.setUpdateUser(id);

        categoryMapper.add(category);
        return Result.success();
    }
    
}
