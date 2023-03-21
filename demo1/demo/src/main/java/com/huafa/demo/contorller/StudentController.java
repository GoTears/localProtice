package com.huafa.demo.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huafa.demo.dto.StudentDto;
import com.huafa.demo.mybatis.entity.Student;
import com.huafa.demo.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description:
 * @author: qi_dabin@163.com
 * @date: 2023/3/14 16:09
 * @version: 1.0
 */
@Controller
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService ;

//        添加学生信息
    public String addStudent(Student entity){
        studentService.AddStudent(entity);
        return "redirect:/student";
    }

//    删除学生信息
    @PostMapping("DeleteStudent")
    @ResponseBody
    public StudentDto DeleteStudent(Long id){
        StudentDto stuDto = new StudentDto();
        int result = studentService.DeleteStudent(id);

        if(result==1){
            stuDto.setMsg("delete successfully!");
            stuDto.setCode(result);
        }else {
            stuDto.setMsg("delete failed!");
            stuDto.setCode(0);
        }
        stuDto.setData(null);
        stuDto.setCount(result);
        return stuDto;
}

//    修改学生信息
    @RequestMapping("UpdateStudent")
    @ResponseBody
    public int UpdateStudent(Student student){
     return studentService.UpdateStudent(student);

    }


    //    查询所有学生
    @RequestMapping("findAll")
    @ResponseBody
    public StudentDto findAll(){
        StudentDto stuDto = new StudentDto();
        stuDto.setCode(0);
        stuDto.setMsg("");
        List<Student> studentList = studentService.findAll();
        stuDto.setData(studentList);
        stuDto.setCount(studentList.size());
        return stuDto;
    }

//    查询学生id
    @GetMapping("findById")
    @ResponseBody
    public Student findById(Long id){
       return studentService.findById(id);
    }


//    分页功能Controller







}