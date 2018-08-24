package com.oak.model.service.user;

import com.oak.model.entity.responseResult.ResponseResult;
import com.oak.model.entity.user.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserService {


    public List<UserInfo> pageQuery();

    public Integer queryCount();

    public UserInfo getUserInfoById(Long id);

    public ResponseResult updatePassword(Long uid, String password, String newPassword, String repeatPassword);

}
