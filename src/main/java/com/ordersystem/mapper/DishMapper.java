package com.ordersystem.mapper;


import com.ordersystem.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {



    //查询页总数
    Long selectTotal();

    //查询页内容
    List<Dish> selectCurrentData(Integer start, Integer pageSize, String name);


    //添加菜品
    void addDish(Dish dish);
}
