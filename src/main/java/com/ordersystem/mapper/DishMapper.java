package com.ordersystem.mapper;


import com.ordersystem.pojo.Dish;
import com.ordersystem.pojo.dto.DishDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {

    //添加菜品
    void add(DishDto dishDto);

    //查询页总数
    Long selectTotal();

    //查询页内容
    List<Dish> selectCurrentData(Integer start, Integer pageSize, String name);


}
