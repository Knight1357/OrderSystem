package com.ordersystem.pojo;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
菜品口味
 */
@Data
public class DishFlavor implements Serializable {
    private Integer id;
    //菜品id
    private Integer dishId;
    //口味名称
    private String name;
    //口味数据list
    private String value;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer createUser;
    private Integer updateUser;
    //是否删除
    private Integer isDeleted;
}
