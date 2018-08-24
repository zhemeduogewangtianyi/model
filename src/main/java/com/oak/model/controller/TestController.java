//package com.oak.model.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import resource.Wisely2Settings;
//import resource.WiselySettings;
//
//@Controller
//public class TestController {
//
//    @Autowired
//    private WiselySettings wiselySettings;
//    @Autowired
//    private Wisely2Settings wisely2Settings;
//
//    @RequestMapping("/test")
//    public @ResponseBody String test(){
//        System.out.println(wiselySettings.getGender()+"---"+wiselySettings.getName());
//
//        System.out.println(wisely2Settings.getGender()+"==="+wisely2Settings.getGender());
//
//        return "ok";
//    }
//}
