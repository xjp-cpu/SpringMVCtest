package com.atguigu.ssm.controllers;

import com.atguigu.ssm.pojo.User;
import com.atguigu.ssm.service.UserService;

import com.atguigu.ssm.serviceImp.UserServiseImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @Autowired
    private UserServiseImp userServiseImp;


    @RequestMapping("/showUserList")
    public String showUserList(Model model){
        System.out.println("11");
        List<User> list = userServiseImp.selectAllUser();
        System.out.println(list);
        model.addAttribute("userList",list);
        return "userList";
    }
}
