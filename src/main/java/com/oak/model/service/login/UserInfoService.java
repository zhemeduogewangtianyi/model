package com.oak.model.service.login;

import com.oak.model.entity.user.UserInfo;

public interface UserInfoService {

    //通过用户名查询用户信息
    public UserInfo findByUsername(String username);

}
