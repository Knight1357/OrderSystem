package com.ordersystem.pojo;

import lombok.Data;

import java.util.List;

@Data
public class DishAdd {
    private Dish dish;
    private List<DishFlavor> flavors;
}
