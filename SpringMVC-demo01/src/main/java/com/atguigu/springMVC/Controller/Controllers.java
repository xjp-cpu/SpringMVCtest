package com.atguigu.springMVC.Controller;


import com.atguigu.springMVC.pojo.User;
import com.sun.deploy.nativesandbox.comm.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.sql.SQLOutput;
import java.util.Map;

@Controller
public class Controllers {


//
//    @RequestMapping("/")
//    public String index(){
//
//        return "index";
//
//    }

    @RequestMapping("/target")

    public String target(){
        return "target";
    }
    @RequestMapping("/target1/{id}/{admitname}")
    public String target1(@PathVariable("id") int id,@PathVariable("admitname") String admitname){


        System.out.println(id+"  "+admitname);


        return "target";


    }

    @RequestMapping("/**/target2")

    public String target2(){
        return "target";
    }

    @RequestMapping("/a?a/target3")

    public String target3(){
        return "target";
    }
    @RequestMapping("/a*a/target4")

    public String target4(){
        return "target";
    }



    @RequestMapping("/target5")
    public String target5(int id,String password){

        System.out.println(id+"  "+password);


        return "target";
    }


    @RequestMapping("/target6")
    public String target6(User user){

        System.out.println(user);


        return "target";
    }


    @RequestMapping("/target7")
    public ModelAndView target7(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testScope","hello modelAndView");


     modelAndView.setViewName("testmodelandview");
        return modelAndView;
    }

@RequestMapping("target8")
    public String testModel(Model model){

        model.addAttribute("testScope","hello model");
        return "testmodelandview";

    }

    @RequestMapping("target9")
    public String testMap(Map<String,Object> map){

        map.put("testScope","hello map");
        return "testmodelandview";

    }
    @RequestMapping("target10")
    public String testMapModel(ModelMap modelMap){

    modelMap.addAttribute("testScope","hello mapModel");

        return "testmodelandview";

    }


    @RequestMapping("target11")
    public String testServletApi(HttpServletRequest request){

      request.setAttribute("testScope","hello ServletApi");

        return "testmodelandview";

    }

    @RequestMapping("target12")
    public String testSession(HttpSession httpSession){

      httpSession.setAttribute("testSessionScope","hello testSession" );

        return "testSessionScope";

    }

    @RequestMapping("target13")
    public String testApplicationContext(HttpSession httpSession){

        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute("testContextScope","hello SessionContext");
        return "testContextScope";

    }

    @RequestMapping("target14")
    public String forwardTest (){

       return  "forward:/target";

    }

    @RequestMapping("target15")
    public String redirectTest (){

        return  "redirect:/target";

    }


}
