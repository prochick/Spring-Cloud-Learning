package com.jhy.studentservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;


@ApiModel(value = "Student", description = "学生实体类")
@Component
public class Student {

    @ApiModelProperty("学生ID")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String sex;

    public Student() {
    }

    public Student(Long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
