package com.huafa.demo.dto;

import com.huafa.demo.mybatis.entity.Student;
import lombok.Data;

import java.util.List;
import java.util.Objects;



@Data
public class StudentDto {
    private Integer code;
    private String msg;
    private List<Student> data;
    private Integer count;




}