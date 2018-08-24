package com.oak.model.service.login.impl;

import com.oak.model.entity.user.UserInfo;
import com.oak.model.service.login.UserInfoService;
import com.oak.model.application.shiro.userInfoRepository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }
}
