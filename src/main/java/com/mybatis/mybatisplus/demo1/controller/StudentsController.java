package com.mybatis.mybatisplus.demo1.controller;

import com.mybatis.mybatisplus.demo1.entity.Students;
import com.mybatis.mybatisplus.demo1.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    //select
    @GetMapping("findAll")
    public List<Students> findAll(){
        return  studentsService.list();
    }

    @GetMapping("/count")
    public int getCount(){
        return  studentsService.count();
    }

    //add
    @GetMapping("/add")
    public String insert(@ModelAttribute  Students students){
        return  studentsService.save(students)==true?"新增成功":"新增失败";
    }

    @GetMapping("/addBatch")//批量插入--count条数，batchSize每批次插入多少条
    public String insertBatch(int  count,int batchSize){
        List<Students> list = new ArrayList<>();
        for(int i=1;i<=count;i++){
            list.add(new Students("autoTest"+i,i,i%2==0?"男":"女"));
        }
        return studentsService.saveBatch(list,batchSize)==true?"新增成功":"新增失败";
    }

    @GetMapping("/saveOrUpdateBatch")//批量修改插入--count条数，batchSize每批次插入多少条
    public String saveOrUpdateBatch(int  count,int batchSize){
        List<Students> list1 = new ArrayList<>();
        for(int i=1;i<=count;i++){
            list1.add(new Students("autoTest"+i,i,i%2==0?"女":"男"));
        }
        return studentsService.saveOrUpdateBatch(list1,batchSize)==true?"新增成功":"新增失败";
    }
}
