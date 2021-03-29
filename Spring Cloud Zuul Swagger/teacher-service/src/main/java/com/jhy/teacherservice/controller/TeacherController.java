package com.jhy.teacherservice.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jhy.teacherservice.entity.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
@Api(tags = "TeacherController", description = "教师控制器")
public class TeacherController {

    @GetMapping("/show")
    @ApiOperation("展示用户")
    public List<Teacher> showTeachers(){
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher1 = new Teacher(1L, "张三", "男");
        Teacher teacher2 = new Teacher(2L, "李四", "男");
        Teacher teacher3 = new Teacher(3L, "王五", "女");

        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        return teachers;
    }

    @PostMapping("/add")
    @ApiOperation("添加教师信息")
    @ApiOperationSupport(ignoreParameters = {"id"})
    public String addTeacher(@ApiParam("教师信息") Teacher teacher){

        System.out.println(teacher);

        return "添加成功";
    }

    @PostMapping("/upd")
    @ApiOperation("修改教师信息")
    public String updTeacher(@ApiParam("教师信息") Teacher teacher){

        System.out.println(teacher);

        return "修改成功";
    }

    @GetMapping("/del/{id}")
    @ApiOperation("删除教师信息")
    public Map<String, String> delTeacher(@PathVariable("id") Long id){
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
