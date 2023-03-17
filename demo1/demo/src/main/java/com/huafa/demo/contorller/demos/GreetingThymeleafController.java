package com.huafa.demo.contorller.demos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @author: qi_dabin@163.com
 * @date: 2023/3/14 15:10
 * @version: 1.0
 */
//@Controller可以标记此类为Controller类
@Controller
public class GreetingThymeleafController{
    //  @GetMapping用于声明/greeting映射到这个函数

    @RequestMapping("/student")
    public ModelAndView greeting2(@RequestParam(name="name", required=false, defaultValue="World") String name, ModelAndView model) {
        //model中的"name"属性会在模板中显示出来
        model.addObject("name", name);
        model.setViewName("student");
        return model;
    }
    @RequestMapping("/")
    public ModelAndView index(ModelAndView model) {
        model.setViewName("index");
        return model;
    }
}
