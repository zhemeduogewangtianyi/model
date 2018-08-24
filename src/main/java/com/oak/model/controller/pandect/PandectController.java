package com.oak.model.controller.pandect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pandect")
public class PandectController {

    @RequestMapping(value = "/list")
    public ModelAndView list(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manager/pandect/list");
        return mav;
    }

}
