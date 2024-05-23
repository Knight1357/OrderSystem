package com.ordersystem.mapper;
import com.ordersystem.pojo.SetMealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetMealDishesMapper {
    //添加套餐的菜品
    void add(SetMealDish setMealDish);
    //根据id查询套餐菜品
    List<SetMealDish> selectById(Integer id);
    //更新套餐内的菜品
    void update(SetMealDish setMealDish);
   // 通过id删除套餐菜品
    void deleteById(Integer id);
}
