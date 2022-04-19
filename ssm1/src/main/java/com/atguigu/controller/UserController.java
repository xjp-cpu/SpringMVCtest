package com.atguigu.controller;


import com.atguigu.pojo.User;

import com.atguigu.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
@Autowired
    private UserServiceImp userServiseImp;


    @RequestMapping("/showUserList")
    public ModelAndView showUserList(){
        List<User> users = userServiseImp.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",users);
    modelAndView.setViewName("userList");

        return modelAndView;
    }
    @RequestMapping("/addUser")
    public void addUser(){

        userServiseImp.addUser();



    }
}
