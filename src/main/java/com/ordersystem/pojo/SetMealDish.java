package com.ordersystem.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 套餐菜品关系
 */
@Data
public class SetMealDish{

    private Integer id;

    //套餐id
    private Integer setmealId;

    //菜品id
    private Integer dishId;

    //菜品名称 （冗余字段）
    private String name;

    //菜品原价
    private BigDecimal price;

    //份数
    private Integer copies;

    //排序
    private Integer sort;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer createUser;

    private Integer updateUser;

    //是否删除
    private Integer isDeleted;
}
