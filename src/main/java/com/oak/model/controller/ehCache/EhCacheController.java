package com.oak.model.controller.ehCache;

import com.oak.model.entity.DemoInfo;
import com.oak.model.service.ehCache.EhDemoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EhCacheController {

    @Resource
    private EhDemoInfoService ehDemoInfoService;

    @Autowired

    @RequestMapping(value = "ehCache")
    public String ehCache(){
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setUsername("张三");
        demoInfo.setPassword("123456");
//        DemoInfo save = ehDemoInfoService.save(demoInfo);

        //不走缓存
//        System.out.println(ehDemoInfoService.findById(save.getId()));

        //走缓存
//        System.out.println(ehDemoInfoService.findById(save.getId()));

        demoInfo = new DemoInfo();
        demoInfo.setUsername("李四");
        demoInfo.setPassword("111111");

        //不走缓存
//        System.out.println(ehDemoInfoService.findById(save.getId()));

        //走缓存
//        System.out.println(ehDemoInfoService.findById(save.getId()));

        DemoInfo updated = new DemoInfo();
        updated.setUsername("李四-update");
        updated.setPassword("888888");
//        try {
//            DemoInfo update = ehDemoInfoService.update(updated);
//
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//        }

        //走缓存.
//        System.out.println(ehDemoInfoService.findById(updated.getId()));

        return "ok";



    }

}
