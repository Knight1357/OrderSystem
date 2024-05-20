package com.ordersystem.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Page <T>{
    private List<T> records;
    private Long total;

}
