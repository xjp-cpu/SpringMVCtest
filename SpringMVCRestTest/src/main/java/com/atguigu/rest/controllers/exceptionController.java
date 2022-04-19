package com.atguigu.rest.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//该类与普通控制类类似

//声名为异常组件
@ControllerAdvice
public class exceptionController {

//该注解需要错误类型的.class
    @ExceptionHandler(ArithmeticException.class)
    public String exceptionHandler(Exception ex, Model model){
       //将错误信息存储到model中
        model.addAttribute("ex",ex);

        return "index2";
    }

}
