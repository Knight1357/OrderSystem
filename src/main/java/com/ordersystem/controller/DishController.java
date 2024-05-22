package com.ordersystem.controller;


import com.ordersystem.mapper.DishFlavorMapper;
import com.ordersystem.mapper.DishMapper;
import com.ordersystem.pojo.Dish;
import com.ordersystem.pojo.DishFlavor;
import com.ordersystem.pojo.dto.DishDto;
import com.ordersystem.pojo.Page;
import com.ordersystem.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class DishController {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    //添加菜品
    //XxxDto 类，专门用于接收前端传递的数据
    @PostMapping("/dish")
    public Result addDish(@RequestBody DishDto dishDto, HttpSession session){

        Integer id = (Integer) session.getAttribute("id");

        //1. 把菜品相关的数据添加到dish表中
        //创建时间更新时间
        dishDto.setCreateTime(LocalDateTime.now());
        dishDto.setUpdateTime(LocalDateTime.now());
        //修改人创建人
        dishDto.setUpdateUser(id);
        dishDto.setCreateUser(id);
        dishMapper.add(dishDto);
        //将来我们写sql的时候，可以通过一些配置
        //将Mybatis吧数据库自动生成的id复制给 disDto的id

        //2. 把口味相关的数据添加到dish_flavor表中
        for (DishFlavor flavor : dishDto.getFlavors()) {
            //添加菜品id
            flavor.setDishId(dishDto.getId());
            //创建时间更新时间
            flavor.setCreateTime(LocalDateTime.now());
            flavor.setUpdateTime(LocalDateTime.now());
            //修改人创建人
            flavor.setUpdateUser(id);
            flavor.setCreateUser(id);

            dishFlavorMapper.add(flavor);
        }



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
