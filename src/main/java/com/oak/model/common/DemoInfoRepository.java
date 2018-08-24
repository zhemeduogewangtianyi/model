package com.oak.model.common;

import com.oak.model.entity.DemoInfo;
import org.springframework.data.repository.CrudRepository;

public interface DemoInfoRepository extends CrudRepository<DemoInfo,Long> {
}
