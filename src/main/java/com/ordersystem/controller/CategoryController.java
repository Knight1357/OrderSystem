package com.ordersystem.controller;


import com.ordersystem.mapper.CategoryMapper;
import com.ordersystem.pojo.Category;
import com.ordersystem.pojo.Page;
import com.ordersystem.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;
    // 添加分类
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
    //查询页
    @GetMapping("/category/page")
    public Result selectByPage(Integer page,Integer pageSize){
        //分页查询

        //1.创建一个Page对象
        Page<Category> p =new Page<>();
        //2.查询总条数
        Long total=categoryMapper.selectTotal();
        //3.查询当前页数据
        // 起始索引 = (当前页码-1)*每页条数
        // select count(*) from category;
        Integer start=(page-1)*pageSize;
        List<Category> cs= categoryMapper.selectCurrentData(start,pageSize);

        p.setTotal(total);
        p.setRecords(cs);

        return Result.success(p);
    }
    //更新种类
    @PutMapping("/category")
    public Result updateCategory(@RequestBody Category category,HttpSession session){
        //调用CategoryMapper方法完成数据库的修改
        //修改之前，填充前端未提供的数据
        //填充创建时间和更新时间
        category.setUpdateTime(LocalDateTime.now());

        //创建更新人
        Integer id = (Integer) session.getAttribute("id");
        category.setUpdateUser(id);

        categoryMapper.update(category);
        return Result.success();
    }

    //根据id删除分类
    @DeleteMapping("/category")
    public Result deleteCategory(Integer id){


        categoryMapper.deleteById(id);

        return Result.success();
    }

    //根据类型获取种类列表
    @GetMapping("/category/list")
    public Result selectCategoryByType(Integer type){

        List<Category> cs=categoryMapper.selectByType(type);

        return Result.success(cs);
    }
    
}
