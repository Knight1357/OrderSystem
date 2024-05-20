package com.ordersystem.pojo;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Employee implements Serializable {

    private Integer id;

    private String username;

    private String name;

    private String password;

    private String phone;

    private String sex;

    private String idNumber; //驼峰命名法 ---> 映射的字段名为 id_number

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer createUser;

    private Integer updateUser;
}