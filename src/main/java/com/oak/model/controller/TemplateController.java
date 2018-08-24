package com.oak.model.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TemplateController {

    // 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hello:Hello Angel}")
    private String hello;


    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String,Object> map){
        System.out.println("HelloController.helloJsp().hello="+hello);
        map.put("hello", hello);
        return "helloJsp";
    }

    @RequestMapping(value = "/helloHtml")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","from TemplateController.helloHtml");
        return "/helloHtml";
    }

    @RequestMapping(value = "/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("hello","from templateController.hrlloFtl");
        return "/helloFtl";
    }

    @RequestMapping(value = "/helloVm")
    public ModelAndView helloVelocity(){
        System.out.printf(">>>>>>>>>>到了这里");
        ModelAndView mav = new ModelAndView("helloVelocity");
        mav.addObject("username","from templateController.hrlloVelocity");
        System.out.printf(">>>>>>>>>>到了这里" + mav);
        return mav;
    }

}
