package com.oak.model.application.interceptor.config;

import com.oak.model.application.interceptor.MyInterceptor1;
//import com.oak.model.application.interceptor.MyInterceptor2;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 多个拦截器组成一个拦截器链

        // addPathPatterns 用于添加拦截规则

        // excludePathPatterns 用户排除拦截

        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");

//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");

        WebMvcConfigurer.super.addInterceptors(registry);

    }

}
