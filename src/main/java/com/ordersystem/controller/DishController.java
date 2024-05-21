package com.ordersystem.controller;


import com.ordersystem.mapper.DishMapper;
import com.ordersystem.pojo.Dish;
import com.ordersystem.pojo.Page;
import com.ordersystem.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    private DishMapper dishMapper;
    //添加菜品
    @PostMapping("/dish")
    public Result addDish(@RequestBody Dish dish){



        return Result.success();
    }

    //查询菜品页
    @GetMapping("/dish/page")
    public Result selectByPage(Integer page,Integer pageSize,String name){
        //1. 新建页
        Page p=new Page<>();

        //2. 查询总数
        Long total=dishMapper.selectTotal();
        p.setTotal(total);

        //3. 查询页内容
        Integer start=(page-1)*pageSize;
        List<Dish> ds=dishMapper.selectCurrentData(start,pageSize,name);
        p.setRecords(ds);

        return Result.success(p);
    }


    //批量停售和启售
    public Result updateStatusBatchById(){

        return null;
    }


    //批量删除菜品
    public Result deleteDishBatchById(){

        return null;
    }

    //根据id查询菜品信息

    public Result selectDishById(){

        return null;
    }


    //更新菜品
    public Result updateDish(){

        return null;
    }

    //根据分类id查询菜品


}
