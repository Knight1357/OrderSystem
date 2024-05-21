package com.ordersystem.interceptor;

import com.alibaba.fastjson.JSON;
import com.ordersystem.pojo.Result;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    //pre + 回车
    //放回bool：如果返回true--放行，false--拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();//获取服务器session对象
        Integer id=(Integer) session.getAttribute("id");//获取session指定键 id 的值

        if(id==null){//没有获取到id
            //没有登录 给前端返回 {"code":0,"msg":"NOTLOGIN",null}
            //1. 构建Result对象
            Result r = Result.error("NOTLOGIN");
            //2. 把Result 对象转换为json字符串
            String jsonStr = JSON.toJSONString(r);
            //3. 把json字符串响应给浏览器
            response.getWriter().write(jsonStr);


            return false;
        }else{
            //已登录
            return true;
        }
    }
}
