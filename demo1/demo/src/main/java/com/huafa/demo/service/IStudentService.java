package com.huafa.demo.service;

import com.huafa.demo.mybatis.entity.Student;

import java.util.List;

public interface IStudentService {
    //find student list
    List<Student> findAll();

    //find student list with page break
    List<Student> findStudentList(Integer pageNum, Integer pageSize);

    //find student by id
    Student findById(Long id);

    //add a new student record
    int AddStudent(Student entity);

    //update an exists student
    int UpdateStudent(Student student);

    //delete an exists student
    int DeleteStudent(Long id);
}