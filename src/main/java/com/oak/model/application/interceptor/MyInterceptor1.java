package com.oak.model.application.interceptor;

import com.oak.model.entity.user.UserInfo;
import com.oak.model.util.UserContextHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("MyInterceptor1 -> 请求来到执行");


        try{
            Session session = SecurityUtils.getSubject().getSession();
            String menu = (String)session.getAttribute("menu");

            Subject subject = SecurityUtils.getSubject();
            UserInfo userInfo = (UserInfo)subject.getPrincipal();
            if(userInfo != null){
                UserContextHelper.setUserInfo(userInfo);
            }
            if(subject != null){
                String uri = request.getRequestURI();

                if(uri.indexOf("list") != -1){
                    session.setAttribute("menu",uri);
                }

                if(uri.equals("/manager/login")){
                    subject.logout();
                }
            }
        }catch (Exception ex){

        }



        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //所谓请求后，视图返回前
//        System.out.println("MyInterceptor1 -> 执行Controller时调用");
//        try{
//            //获取本机用户名 和 IP
//            InetAddress ia = InetAddress.getLocalHost();
//            String name = ia.getHostName();
//            String ip = ia.getHostAddress();
//            System.out.println(name);
//            System.out.println(ip);
//
//            //获取彬哥用户名 和 IP 192.168.26.198
//
//            //InetAddress address2 =InetAddress.getByName("其他主机名");
//            String address = "192.168.26.198";
//            InetAddress address3 =InetAddress.getByName(address);
//            String name3 = address3.getHostName();
//            String ip3 = address3.getHostAddress();
//            System.out.println(name3);
//            System.out.println(ip3);
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //所谓返回ModelAndView 之后清理工作
//        System.out.println("MyInterceptor1 -> 视图渲染后执行");
        UserContextHelper.remove();
    }

}
