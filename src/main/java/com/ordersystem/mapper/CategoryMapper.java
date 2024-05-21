package com.ordersystem.mapper;


import com.ordersystem.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {

    //添加分类
    void add(Category category);
}
