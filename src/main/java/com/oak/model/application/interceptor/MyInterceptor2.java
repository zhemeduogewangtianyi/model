//package com.oak.model.application.interceptor;
//
//import org.springframework.lang.Nullable;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class MyInterceptor2 implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("MyInterceptor2 -> 请求来到执行");
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        //所谓请求后，视图返回前
//        System.out.println("MyInterceptor2 -> 执行Controller时调用");
//    }
//
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        //所谓返回ModelAndView 之后清理工作
//        System.out.println("MyInterceptor2 -> 视图渲染后执行");
//    }
//
//}
