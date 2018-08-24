package com.oak.model.controller.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/exception")
public class ExceptionController {

    @RequestMapping(value = "/403")
    @ResponseBody
    public String Exception403(){
        return "生活总有不如意，重新操作一遍试一试~";
    }

}
