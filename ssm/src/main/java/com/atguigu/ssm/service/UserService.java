package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> selectAllUser();
}
