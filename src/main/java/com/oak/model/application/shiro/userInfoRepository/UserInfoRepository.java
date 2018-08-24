package com.oak.model.application.shiro.userInfoRepository;

import com.oak.model.entity.user.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {

    public UserInfo findByUsername(String username);

}
