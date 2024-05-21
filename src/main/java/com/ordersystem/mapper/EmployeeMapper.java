package com.ordersystem.mapper;


import com.ordersystem.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    //根据用户名和密码查询
    Employee selectByUsernameAndPassword(String username, String password);



}
