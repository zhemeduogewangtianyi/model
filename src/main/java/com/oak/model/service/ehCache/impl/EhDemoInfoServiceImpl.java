package com.oak.model.service.ehCache.impl;

import com.oak.model.common.DemoInfoRepository;
import com.oak.model.entity.DemoInfo;
import com.oak.model.service.ehCache.EhDemoInfoService;
import javassist.NotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class EhDemoInfoServiceImpl implements EhDemoInfoService {

    //这里的单引号不能少，否则会报错，被识别是一个对象
    public static final String CHECK_KEY = "'demoInfo'";

    @Resource
    private DemoInfoRepository demoInfoRepository;

    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String DEMO_CACHE_NAME = "demo";


    @CacheEvict(value = DEMO_CACHE_NAME,key = "'demoInfo_'+#id")
    @Override
    public void delete(Long id) {
        demoInfoRepository.deleteById(id);
    }

    @Override
    public DemoInfo update(DemoInfo updated) throws NotFoundException {
        Optional<DemoInfo> byId = demoInfoRepository.findById(updated.getId());
        if(byId == null){
            throw new NotFoundException("No find");
        }

        byId.get().setUsername(updated.getUsername());
        byId.get().setPassword(updated.getPassword());
        return byId.get();
    }

    @Override
    public DemoInfo findById(Long id) {
        Optional<DemoInfo> optional = demoInfoRepository.findById(id);
        return optional.get();
    }

    @Override
    public DemoInfo save(DemoInfo demoInfo) {
        DemoInfo save = demoInfoRepository.save(demoInfo);
        return save;
    }
}
