package com.ordersystem.controller;

import com.alibaba.fastjson.JSON;
import com.ordersystem.mapper.EmployeeMapper;
import com.ordersystem.pojo.Employee;
import com.ordersystem.pojo.Page;
import com.ordersystem.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired//告诉Spring，从IOC容器中，拿到EmployeeMapper类的对象，赋值给改成员变量
    private EmployeeMapper employeeMapper;

    //需要什么在参数列表中声明
    @PostMapping("/employee/login")
    public Result login(@RequestBody Employee employee, HttpSession session){

        System.out.println("==============login=============");

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
            session.setAttribute("id",loginEmployee.getId());
            return Result.success(loginEmployee);
        }
    }

    @PostMapping("/employee/logout")
    public Result logout(HttpSession session){

        System.out.println("==============logout=============");
        //退出登录
        //删除session中的id值
        session.removeAttribute("id");
        return Result.success();
    }

    @GetMapping("/employee/page")
    public Result selectByPage(Integer page,Integer pageSize,String name){

        //1.new 一个Page
        Page<Employee> p=new Page<>();

        //2.查询Employee表的total
        employeeMapper.selectTotal();

        //3. 查询当前页数据
        Integer start=(page-1)*pageSize;
        employeeMapper.selectCurrentData(start,pageSize,name);

        return Result.success();
    }
}
