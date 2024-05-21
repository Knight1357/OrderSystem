package com.ordersystem.config;

import com.ordersystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//标识当前类是配置类
public class MyConfig implements WebMvcConfigurer {

    //addInter+回车

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        //不要拦截登录相关的资源  静态资源不拦截
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/employee/login","/backend/**","/front/**");
    }
}
