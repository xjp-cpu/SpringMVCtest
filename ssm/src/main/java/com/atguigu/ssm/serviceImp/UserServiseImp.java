package com.atguigu.ssm.serviceImp;

import com.atguigu.ssm.mapper.UserMapper;
import com.atguigu.ssm.pojo.User;
import com.atguigu.ssm.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiseImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Test
    @Override
    public List<User> selectAllUser() {
        List<User> userlist = userMapper.selectAllUser();
        System.out.println(userlist);
        return userlist;
    }
}
