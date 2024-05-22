package com.ordersystem.mapper;


import com.ordersystem.pojo.dto.SetMealDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetMealMapper {


    //添加套餐
    void add(SetMealDto setMealDto);
}
