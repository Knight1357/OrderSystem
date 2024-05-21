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
import java.time.LocalDateTime;
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
    // 退出登录
    @PostMapping("/employee/logout")
    public Result logout(HttpSession session){

        System.out.println("==============logout=============");
        //退出登录
        //删除session中的id值
        session.removeAttribute("id");
        return Result.success();
    }

    //显示员工信息页
    @GetMapping("/employee/page")
    public Result selectByPage(Integer page,Integer pageSize,String name){

        //1.new 一个Page
        Page<Employee> p=new Page<>();

        //2.查询Employee表的total
        Long total=employeeMapper.selectTotal();
        p.setTotal(total);
        //3. 查询当前页数据
        Integer start=(page-1)*pageSize;
        List<Employee> es=employeeMapper.selectCurrentData(start,pageSize,name);
        p.setRecords(es);

        return Result.success(p);
    }

    //添加员工
    @PostMapping("/employee")
    public Result addEmployee(@RequestBody Employee employee,HttpSession session){
        //1.完善信息

        //创建时间更新时间
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        //状态
        employee.setStatus(1);

        //创建用户更新用户
        Integer id=(Integer) session.getAttribute("id");
        employee.setCreateUser(id);
        employee.setUpdateUser(id);

        //密码加密
        String password=DigestUtils.md5DigestAsHex("123456".getBytes());
        employee.setPassword(password);

        //2.添加Employee
        employeeMapper.add(employee);

        return Result.success();
    }

    // 根据ID查询员工
    @GetMapping("/employee/{id}")
    public Result selectByEmployeeId(@PathVariable Integer id){

        Employee employee=employeeMapper.selectById(id);
        if(employee==null){
            return Result.error("查询失败");
        }else{
            return Result.success(employee);
        }
    }


}
