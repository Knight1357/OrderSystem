package com.ordersystem.mapper;


import com.ordersystem.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    //根据用户名和密码查询
    Employee selectByUsernameAndPassword(String username, String password);
    //查询员工总数
    Long selectTotal();
    //查询最近的员工信息
    List<Employee> selectCurrentData(Integer start, Integer pageSize, String name);
    //添加员工
    void add(Employee employee);
    //通过id查询员工
    Employee selectById(Integer id);
}
