package com.oak.model.dao.user;

import com.oak.model.entity.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userMapper")
public interface UserMapper {

    public List<UserInfo> pageQuery();

    public Integer queryCount();

    public UserInfo getUserById(Long id);

    public void update(UserInfo userInfo);

}
