package com.ordersystem.mapper;


import com.ordersystem.pojo.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    //添加最喜欢的口味
    void add(DishFlavor flavor);

    //根据id查询口味
    List<DishFlavor> selectById(Integer id);
    //更新菜品口味
    void update(DishFlavor flavor);
    //删除多余口味
    void deleteById(Integer id);
}
