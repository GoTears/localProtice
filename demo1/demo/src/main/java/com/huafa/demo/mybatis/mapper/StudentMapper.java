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

    //    新增数据
    @Insert("insert into sys_student(student_num,name,email,phone,hobby) value(#(student_num),#(name),#(email),#(phone),#(hobby),)")
    public int saveStuMsg(Student student);

    //    删除数据
    @Delete("delete from sys_student where id=#{id}")
    public int deleteStuId(long id);

    //    根据id查找
    @Select("select * from sys_student where id=#{id}")
    public Student getId(long id);

    //更新数据
    @Update("update student set student_num=#{student_num},name=#{name},email=#{email},phone=#{phone},hobby=#{hobby}")
    public int updateStuMsg(Student student);
}
