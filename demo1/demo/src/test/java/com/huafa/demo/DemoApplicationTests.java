package com.huafa.demo;

import com.huafa.demo.mybatis.entity.Student;
import com.huafa.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    StudentService studentService ;
    @Test
    public void testStudentInsert() {
        Student student=new Student();
        student.setName("李雷");
        student.setStudentNum("151513245");
        student.setEmail("3403907385@qq.com");
        student.setHobby("打篮球");
        student.setSex("男");
    }

}
