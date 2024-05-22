package com.ordersystem.mapper;


import com.ordersystem.pojo.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    //添加最喜欢的口味
    void add(DishFlavor flavor);


}
