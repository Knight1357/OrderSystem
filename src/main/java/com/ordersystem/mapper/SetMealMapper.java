package com.ordersystem.mapper;


import com.ordersystem.pojo.Dish;
import com.ordersystem.pojo.SetMeal;
import com.ordersystem.pojo.dto.SetMealDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetMealMapper {


    //添加套餐
    void add(SetMealDto setMealDto);
    //计算总数
    Long selectTotal();
    //查询当前页数据
    List<Dish> selectCurrentData(Integer start, Integer pageSize, String name);
    //批量更新状态
    void updateStatus(SetMeal setMeal);
    //批量删除
    void deleteById(Integer id);
    //查询套餐
    SetMealDto selectById(Integer id);
    //更新套餐信息
    void update(SetMealDto setMealDto);
}
