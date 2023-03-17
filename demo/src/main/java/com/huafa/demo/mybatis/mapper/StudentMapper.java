package com.huafa.demo.mybatis.mapper;

import com.huafa.demo.mybatis.entity.Student;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @description:
 * @author: qi_dabin@163.com
 * @date: 2023/3/14 16:11
 * @version: 1.0
 */
@Mapper
//@Repository("StudentMapper")
public interface StudentMapper {
//    查询全部
    public List<Student> findAll();
//    查询学生id
   List<Student> findById();

//    添加一个学生信息
   int addStudent(Student student);

//    修改一个学生信息
   int updateStudent(Student student);

//    根据学生ID删除信息
   int deleteStudent(Long id);

}
