package com.atguigu.rest.controllers;

import com.atguigu.rest.bean.Employee;
import com.atguigu.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@Controller
public class Controllers {

    @Autowired
    private EmployeeDao employeeDao;


    @RequestMapping( value="/employee",method=RequestMethod.GET)
    public String selectAllUser(Model model){

        Collection<Employee> employeeList = employeeDao.getAll();
           model.addAttribute("employeeList",employeeList);
           return "employeeList";



    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }


    @RequestMapping(value = "/employee" ,method = RequestMethod.POST)
    public String addEmployeeTwo(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}" ,method = RequestMethod.GET)
    public String updateEmployee(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee" ,employee);
        return "/update_employee";
    }

    @RequestMapping(value = "/employee" ,method = RequestMethod.PUT)
    public String updateEmployeeTwo(Employee employee){
        employeeDao.save(employee);

        //相同id值直接覆盖
        return "redirect:/employee";

    }

    @RequestMapping(value="/requestBody" ,method = RequestMethod.POST)
    public String requestBody(@RequestBody String requestbody){
        System.out.println("requestbody="+requestbody);
        return "redirect:/employee";


    }

    @RequestMapping(value="/requestEntity" ,method = RequestMethod.POST)
    public String requestENtity(RequestEntity<String> requestEntity ){
        System.out.println("requestbody="+requestEntity.getHeaders());
        System.out.println("requestbody="+requestEntity.getBody());
        System.out.println("requestbody="+requestEntity.getMethod());
        System.out.println("requestbody="+requestEntity.getType());
        System.out.println("requestbody="+requestEntity.getUrl());
        return "redirect:/employee";


    }

    @RequestMapping(value="/responseServlet")
    public void responseServlet(HttpServletResponse response) throws IOException {

        response.getWriter().print("hello,this is responseSevlet");

    }


    @RequestMapping(value="/responseBody")

    @ResponseBody
    public String responseBody()  {

       return "hello,this is responseBody";

    }

    @RequestMapping(value="/responseEmployee")

    @ResponseBody
    public Employee responseBodyEmployee()  {

        return new Employee(12,"许哥","123@qq.com",1);

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


    @RequestMapping(value = "testUpFile")
    public String testUpFile(MultipartFile photo,HttpSession session) throws IOException {
       //获取文件上传的文件名
        String name = photo.getOriginalFilename();

        //获取文件名的后缀名
        String suffixName = name.substring(name.lastIndexOf("."));
        //处理重名问题，使用UUID获取随机数
        name= UUID.randomUUID().toString()+suffixName;
        ServletContext servletContext = session.getServletContext();
        String photo1RealPath = servletContext.getRealPath("/static/music");
        File file = new File(photo1RealPath);
        if(!file.exists()){
            file.mkdir();
        }
   String finalPath= photo1RealPath+file.separator+name;
        photo.transferTo(new File(finalPath));

      return "redirect:/employee";
    }
@RequestMapping(value = "/**/testInterceptor")
    public String testInterceptor(){

        return "redirect:/employee";

    }


    @RequestMapping(value = "/testException")
    public String testException(){

        System.out.println(1/0);

        return "redirect:/employee";
    }

}
