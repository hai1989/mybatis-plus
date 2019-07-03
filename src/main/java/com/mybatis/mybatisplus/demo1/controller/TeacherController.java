package com.mybatis.mybatisplus.demo1.controller;

import com.mybatis.mybatisplus.demo1.entity.Teacher;
import com.mybatis.mybatisplus.demo1.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.controller
 * ClassName:     TeacherController
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:40
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService iTeacherService;

    @GetMapping("/findAll")
    public List<Teacher> findAll(){

        return  iTeacherService.list();
    }

}
