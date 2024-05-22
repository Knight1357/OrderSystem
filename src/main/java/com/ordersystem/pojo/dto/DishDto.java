package com.ordersystem.pojo.dto;

import com.ordersystem.pojo.Dish;
import com.ordersystem.pojo.DishFlavor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors;
}
