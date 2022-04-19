package com.atguigu.annotation.controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;

@Controller

public class TestController {
@RequestMapping("/succeed")
    public String indexTest(){

    return "succeed";
    }
    @RequestMapping("/testException")
    public String testException(){

        System.out.println(1/0);

    return "succeed";

    }
    @RequestMapping(value = "/fileDownload")
    public ResponseEntity<byte[]> fileDownload(HttpSession session) throws IOException {

        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/music/music.mp3");
        FileInputStream inputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=music.mp3");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        inputStream.close();
        return responseEntity;

    }

}
