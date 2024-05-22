package com.ordersystem.pojo.dto;

import com.ordersystem.pojo.SetMeal;
import com.ordersystem.pojo.SetMealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetMealDto extends SetMeal {
   private List<SetMealDish> setmealDishes;
}
