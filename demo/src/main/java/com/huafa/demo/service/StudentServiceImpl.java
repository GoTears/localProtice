package com.huafa.demo.service;

import com.huafa.demo.mybatis.entity.Student;
import com.huafa.demo.mybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: qi_dabin@163.com
 * @date: 2023/3/14 16:10
 * @version: 1.0
 */

//学生接口实现类
@Service
@Transactional
public class StudentServiceImpl {
    @Autowired
    StudentMapper studentMapper;
    public List<Student> findAll() {
        return studentMapper.findAll();
    }


    public List<Student> findById(){
        return studentMapper.findById();
    }


    public int addStudent(Student student){
        return studentMapper.addStudent(student);
    }

    public int updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }

    public int deleteStudent(Long id){
        return studentMapper.deleteStudent(id);
    }
}

