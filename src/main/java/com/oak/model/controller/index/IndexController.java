package com.oak.model.controller.index;

import com.oak.model.util.UserContextHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@SpringBootApplication
public class IndexController {

    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("/index");

        Session session = SecurityUtils.getSubject().getSession();
        String uri = (String) session.getAttribute("menu");

        mav.addObject("menu",uri);
        mav.addObject("realname",UserContextHelper.getRealName());
        return mav;
    }

//    public static void main(String[] args){
//        SpringApplication.run(IndexController.class,args);
//    }

}
