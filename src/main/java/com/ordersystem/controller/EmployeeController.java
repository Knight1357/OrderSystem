package com.ordersystem.controller;

import com.ordersystem.mapper.EmployeeMapper;
import com.ordersystem.pojo.Employee;
import com.ordersystem.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired//告诉Spring，从IOC容器中，拿到EmployeeMapper类的对象，赋值给改成员变量
    private EmployeeMapper employeeMapper;
    @PostMapping("/employee/login")
    public Result login(@RequestBody Employee employee){
        //登录逻辑
        //0.先对用户密码进行加密，得到密文密码
        String password=DigestUtils.md5DigestAsHex(employee.getPassword().getBytes());
        String username = employee.getUsername();
        //1.更加用户名和密码到数据库查询  调用方法，查询数据库
        Employee loginEmployee= employeeMapper.selectByUsernameAndPassword(username,password);

        //2.判断有没有查询，从而给出对应的响应,
        if(loginEmployee==null){
            //登录失败
            return Result.error("用户名和密码错误");
        }else{
            //登录成功
            return Result.success(loginEmployee);
        }
    }
	
}
