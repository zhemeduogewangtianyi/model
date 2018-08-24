package com.oak.model.service.ehCache;

import com.oak.model.entity.DemoInfo;
import javassist.NotFoundException;

public interface EhDemoInfoService {

    /**
     * 通过ID删除
     * */
    public void delete(Long id);

    /**
     * 修改
     * */
    public DemoInfo update(DemoInfo updated) throws NotFoundException;

    /**
     * 通过ID查询
     * */
    public DemoInfo findById(Long id);

    /**
     * 保存
     * */
    DemoInfo save(DemoInfo demoInfo);

}
