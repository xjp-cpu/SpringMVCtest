package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {

    public List<User> selectAllUser();

    public User selectUserById();
}
