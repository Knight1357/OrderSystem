package com.ordersystem.mapper;
import com.ordersystem.pojo.SetMealDish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetMealDishesMapper {
    //添加套餐的菜品
    void add(SetMealDish setMealDish);
}
