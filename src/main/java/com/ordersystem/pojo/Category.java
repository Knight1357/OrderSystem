package com.ordersystem.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer id;

    //类型 1 菜品分类 2 套餐分类
    private Integer type;

    //分类名称
    private String name;

    //顺序
    private Integer sort;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;

    //创建人
    private Integer createUser;

    //修改人
    private Integer updateUser;
}
