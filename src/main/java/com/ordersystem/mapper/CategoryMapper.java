package com.ordersystem.mapper;


import com.ordersystem.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //添加分类
    void add(Category category);

    Long selectTotal();

    List<Category> selectCurrentData(Integer start, Integer pageSize);
}
