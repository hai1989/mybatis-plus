package com.mybatis.mybatisplus.demo1.controller;

import com.mybatis.mybatisplus.demo1.entity.Course;
import com.mybatis.mybatisplus.demo1.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.controller
 * ClassName:     CourseController
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:49
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @GetMapping("findAll")
    public List<Course>  findAll(){
        return   iCourseService.list();
    }
}
