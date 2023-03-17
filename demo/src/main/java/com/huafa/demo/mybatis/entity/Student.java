package com.huafa.demo.mybatis.entity;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: qi_dabin@163.com
 * @date: 2023/3/14 16:12
 * @version: 1.0
 */
@Component
public class Student {
    private Long id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生ID，自增',
    private String studentNum;// varchar(30) DEFAULT NULL COMMENT '学号',
    private String name;// varchar(30) NOT NULL COMMENT '姓名',
    private String email;//varchar(50) DEFAULT '' COMMENT '邮箱',
    private String phone;// varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '手机号码',
    private String sex;//char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
    private String hobby;//  varchar(255) COMMENT '业余爱好',


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
