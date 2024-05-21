package com.ordersystem.mapper;


import com.ordersystem.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    //根据用户名和密码查询
    Employee selectByUsernameAndPassword(String username, String password);


    Long selectTotal();

    List<Employee> selectCurrentData(Integer start, Integer pageSize, String name);

    void add(Employee employee);
}
