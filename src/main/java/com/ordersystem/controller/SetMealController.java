package com.ordersystem.controller;


import com.ordersystem.mapper.SetMealDishesMapper;
import com.ordersystem.mapper.SetMealMapper;
import com.ordersystem.pojo.*;
import com.ordersystem.pojo.dto.DishDto;
import com.ordersystem.pojo.dto.SetMealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class SetMealController {

    @Autowired
    SetMealMapper setMealMapper;
    @Autowired
    SetMealDishesMapper setMealDishesMapper;

    //添加套餐
    @PostMapping("/setmeal")
    public Result addSetMeal(@RequestBody SetMealDto setMealDto, HttpSession session){

        Integer id = (Integer) session.getAttribute("id");

        //1. 把菜品相关的数据添加到dish表中
        //创建时间更新时间
        setMealDto.setCreateTime(LocalDateTime.now());
        setMealDto.setUpdateTime(LocalDateTime.now());
        //修改人创建人
        setMealDto.setUpdateUser(id);
        setMealDto.setCreateUser(id);
        setMealMapper.add(setMealDto);
        //将来我们写sql的时候，可以通过一些配置
        //将Mybatis吧数据库自动生成的id复制给 disDto的id

        //2. 把口味相关的数据添加到dish_flavor表中
        for (SetMealDish setMealDish : setMealDto.getSetmealDishes()) {
            //添加菜品id
            setMealDish.setDishId(setMealDto.getId());
            //创建时间更新时间
            setMealDish.setCreateTime(LocalDateTime.now());
            setMealDish.setUpdateTime(LocalDateTime.now());
            //修改人创建人
            setMealDish.setUpdateUser(id);
            setMealDish.setCreateUser(id);

            setMealDishesMapper.add(setMealDish);
        }
        return Result.success();

    }

    //查询菜品页
    @GetMapping("/setmeal/page")
    public Result selectByPage(Integer page,Integer pageSize,String name){
        //1. 新建页
        Page p=new Page<>();

        //2. 查询总数
        Long total=setMealMapper.selectTotal();
        p.setTotal(total);

        //3. 查询页内容
        Integer start=(page-1)*pageSize;
        List<Dish> ds=setMealMapper.selectCurrentData(start,pageSize,name);
        p.setRecords(ds);

        return Result.success(p);
    }

    //批量停售和启售
    @PostMapping("/setmeal/status/{status}")
    public Result updateStatusBatchById(@PathVariable Integer status,Integer[] ids,HttpSession session){
        SetMeal setMeal=new SetMeal();
        Integer id=(Integer) session.getAttribute("id");
        //批量更新
        for (Integer dishId : ids) {
            //补充数据
            setMeal.setStatus(status);
            setMeal.setId(dishId);
            setMeal.setUpdateTime(LocalDateTime.now());
            setMeal.setUpdateUser(id);
            //更新数据
            setMealMapper.updateStatus(setMeal);
        }

        return Result.success();
    }


    //批量删除菜品
    @DeleteMapping("/setmeal")
    public Result deleteDishBatchById(Integer[] ids){

        for (Integer id : ids) {
            //通过id删除
            setMealMapper.deleteById(id);
        }

        return Result.success();
    }

    //根据id查询菜品信息
    @GetMapping("/setmeal/{id}")
    public Result selectDishById(@PathVariable Integer id){
        //查询菜品
        SetMealDto setMealDto= setMealMapper.selectById(id);
        //查询口味
        List<SetMealDish> ds=  setMealDishesMapper.selectById(id);
        setMealDto.setSetmealDishes(ds);
        return Result.success(setMealDto);
    }


    //更新菜品
    @PutMapping("/dish")
    public Result updateDish(@RequestBody SetMealDto setMealDto, HttpSession session){

        Integer id = (Integer) session.getAttribute("id");

        //1. 把菜品相关的数据添加到dish表中
        //创建时间更新时间
        setMealDto.setUpdateTime(LocalDateTime.now());
        //修改人创建人
        setMealDto.setUpdateUser(id);
        setMealMapper.update(setMealDto);
        //将来我们写sql的时候，可以通过一些配置
        //将Mybatis吧数据库自动生成的id复制给 disDto的id

        //2. 把口味相关的数据添加到dish_flavor表中
        for (SetMealDish setMealDish : setMealDto.getSetmealDishes()) {
            //添加菜品id
            setMealDish.setDishId(setMealDish.getId());
            //创建时间更新时间
            setMealDish.setUpdateTime(LocalDateTime.now());
            //修改人创建人
            setMealDish.setUpdateUser(id);

            setMealDishesMapper.update(setMealDish);
        }

        return Result.success();
    }

   
}
