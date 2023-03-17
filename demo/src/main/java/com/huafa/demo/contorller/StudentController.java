package com.huafa.demo.contorller;

import com.huafa.demo.mybatis.entity.Student;
import com.huafa.demo.mybatis.mapper.StudentMapper;
import com.huafa.demo.service.StudentService;
import com.huafa.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @description:
 * @author: qi_dabin@163.com
 * @date: 2023/3/14 16:09
 * @version: 1.0
 */
@Controller

@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Student> findAll(){
        return studentMapper.findAll();
    }

    @RequestMapping ()
    public String addstudent(Student student){
        StudentService.addstudent(student);
        return "redirect:/student";
    }


}
