package com.mybatis.mybatisplus.demo1.controller;

import com.mybatis.mybatisplus.demo1.entity.Students;
import com.mybatis.mybatisplus.demo1.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.controller
 * ClassName:     StudentsController
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/2 18:20
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private IStudentsService  studentsService;

    @GetMapping("findAll")
    public List<Students> findAll(){

        return  studentsService.list();
    }

}
