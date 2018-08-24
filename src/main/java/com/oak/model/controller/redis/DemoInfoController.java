package com.oak.model.controller.redis;

import com.oak.model.entity.DemoInfo;
import com.oak.model.service.redis.DemoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoInfoController {

    @Autowired
    private DemoInfoService demoInfoService;

    @RequestMapping("/test")
    public @ResponseBody
    String test(){
        try{
            DemoInfo loaded = demoInfoService.findById(1);
            System.out.println("loaded="+loaded);
            DemoInfo cached = demoInfoService.findById(1);
            System.out.println("cached="+cached);
            loaded = demoInfoService.findById(2);
            System.out.println("loaded2="+loaded);
            return "<table border=\"1\">\n" +
                    "    <tr>\n" +
                    "        <td>"+cached.getId()+"</td>\n" +
                    "        <td>"+cached.getUsername()+"</td>\n" +
                    "        <td>"+cached.getPassword()+"</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td>"+loaded.getId()+"</td>\n" +
                    "        <td>"+loaded.getUsername()+"</td>\n" +
                    "        <td>"+loaded.getPassword()+"</td>\n" +
                    "    </tr>\n" +
                    "</table>";
        }catch(Exception ex){
            ex.printStackTrace();
            return "<h1>你丫数据库没数据啊</h1>";
        }

    }


    @RequestMapping("/delete")
    public @ResponseBody String delete(long id){
        demoInfoService.deleteFromCache(id);
        return"ok";
    }

    @RequestMapping("/test1")
    public @ResponseBody String test1(){
        demoInfoService.test();
        System.out.println("DemoInfoController.test1()");
        return "ok";
    }

    @RequestMapping("/cache")
    public @ResponseBody String cache(){
        List<DemoInfo> cached = demoInfoService.findByCache();
        System.out.println("DemoInfoController.test1()");
        StringBuffer buff = new StringBuffer();
        for(int i = 0 ; i < cached.size() ; i++){
            buff.append("<table border=\"1\">" +
                    "<td>"+cached.get(i).getId()+"</td>" +
                    "<td>"+cached.get(i).getUsername()+"</td>" +
                    "<td>"+cached.get(i).getPassword()+"</td>" +
                    "</table>");
        }
        return buff.toString();
    }

}
