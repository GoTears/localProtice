package com.huafa.demo.service.impl;

import com.huafa.demo.mybatis.entity.Student;
import com.huafa.demo.mybatis.mapper.StudentMapper;
import com.huafa.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: qi_dabin@163.com
 * @date: 2023/3/14 16:10
 * @version: 1.0
 */
@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentMapper studentMapper;

    //     学生DTO
    public int AddStudent(Student entity){
        int result = studentMapper.AddStudent(entity);
        //新增失败需要提示error, 新增失败
        if(result != 1) {
            return 0;
        }
        return result;
    }

    @Override
    public int DeleteStudent(Long id) {
        return studentMapper.DeleteStudent(id);
    }

    @Override
    public int UpdateStudent(Student student) {
        return studentMapper.UpdateStudent(student);
    }


    @Override
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    public List<Student> findAll() {
        return studentMapper.findAll();
    }


    //    学生列表分页功能
    public List<Student> findStudentList(Integer pageNum, Integer pageSize){
        int offset = pageSize * (pageNum - 1);
        return studentMapper.findStudentList(offset, pageSize);
    }







//    public Long getId(Long id){
//        return studentMapper.getId(id);
//    }

//    public int updateStuMsg(){
//    return studentMapper.updateStuMsg.
//    }



}