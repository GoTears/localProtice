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
public interface StudentMapper {

    //查询所有学生
    @Select("select * from sys_student")
    List<Student>findAll();

    //查询学生列表分页功能
    @Select("select * from sys_student LIMIT #{pageNum}, #{pageSize}")
    List<Student> findStudentList(Integer pageNum, Integer pageSize);

    //    根据id查找
    @Select("select * from sys_student where id=#{id}")
    Student findById(long id);

    //    新增数据
    @Insert("INSERT INTO sys_student (student_num,name,email,phone,sex,hobby) VALUES (#{studentNum},#{name},#{email},#{phone},#{sex},#{hobby})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    public int AddStudent(Student student);

    //    删除数据
    @Delete("delete from sys_student where id=#{id}")
    public int DeleteStudent(long id);

    //    根据id查找
    //@Select("select * from sys_student where id=#{id}")
    //public Student getId(long id);

    //更新数据
    @Update("update student set student_num=#{student_num},name=#{name},email=#{email},phone=#{phone},hobby=#{hobby} whrere id=#{id}")
    public int UpdateStudent(Student student);
}