package com.huafa.demo.service;

import com.huafa.demo.mybatis.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();


    List<Student> findById(Long id);


    int addStudent(Student student);


    int updateStudent(Student student);


    int deleteStudent(Long id);
}
