package com.jhy.studentservice.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jhy.studentservice.entity.Student;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Api(tags = "StudentController", description = "学生控制器")
public class StudentController {

    @GetMapping("/show")
    @ApiOperation("展示用户")
    public List<Student> showStudents(){
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1L, "张三", "男");
        Student student2 = new Student(2L, "李四", "男");
        Student student3 = new Student(3L, "王五", "女");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }

    @PostMapping("/add")
    @ApiOperation("添加学生信息")
    @ApiOperationSupport(ignoreParameters = {"id"})
    public String addStudent(@ApiParam("学生信息") Student student){

        System.out.println(student);

        return "添加成功";
    }

    @PostMapping("/upd")
    @ApiOperation("修改学生信息")
    public String updStudent(@ApiParam("学生信息") Student student){

        System.out.println(student);

        return "修改成功";
    }

    @GetMapping("/del/{id}")
    @ApiOperation("删除学生信息")
    public Map<String, String> delStudent(@PathVariable("id") Long id){
        Map<String, String> result = new HashMap<>();
        result.put("type", "success");
        result.put("msg", "删除成功");

        return result;
    }

    @GetMapping("/error")
    @ApiIgnore
    public String error(){

        return "error";
    }
}
