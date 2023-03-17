package com.huafa.demo.service;

import com.huafa.demo.mybatis.entity.Student;
import com.huafa.demo.mybatis.mapper.StudentMapper;
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
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    //    业务层查询所有学生

    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    //    业务层查询学生信息数据


    public Long getId(Long id){
        return studentMapper.getId(id);
    }

    public int updateStuMsg(){
    return studentMapper.updateStuMsg.
    }



}
