package com.ordersystem.mapper;


import com.ordersystem.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //添加分类
    void add(Category category);
    //查询总条数
    Long selectTotal();
    //查询当前页数据
    List<Category> selectCurrentData(Integer start, Integer pageSize);

    //修改分类
    void update(Category category);
}
