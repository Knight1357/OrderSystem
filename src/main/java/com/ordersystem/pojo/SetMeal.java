package com.ordersystem.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 套餐
 */
@Data
public class SetMeal {


    private Integer id;


    //分类id
    private Integer categoryId;


    //套餐名称
    private String name;


    //套餐价格
    private BigDecimal price;


    //状态 0:停用 1:启用
    private Integer status;


    //编码
    private String code;


    //描述信息
    private String description;


    //图片
    private String image;


    private LocalDateTime createTime;


    private LocalDateTime updateTime;


    private Integer createUser;


    private Integer updateUser;

}
