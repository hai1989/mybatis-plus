package com.mybatis.mybatisplus.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.mybatisplus.demo1.entity.Students;
import com.mybatis.mybatisplus.demo1.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/byId/{id}")//RequestMapping 使用{}来表明他的变量部分，例如：/byId/{id}
    public Students  findById(@PathVariable(value = "id") int id){
        return   studentsService.getById(id);
    }

    // listByIds--用post方式
    @PostMapping("/listId")
    public Collection<Students>  findByIdList(@RequestParam(value = "idList")  Collection<Integer> idList){
        return studentsService.listByIds(idList);
    }

    // listByMap--用post方式---
    // 有问题：2019-07-04 12:29:23.992  WARN 17080 --- [nio-8083-exec-1] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException: Failed to convert value of type 'java.lang.String' to required type 'java.util.Map'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'java.util.Map': no matching editors or conversion strategy found]
    @PostMapping("/mapId")
    public Collection<Students>  findByMap(@RequestParam("columnMap") Map<String, Object> columnMap){
        return   studentsService.listByMap(columnMap);
    }

    @GetMapping("/getOne")
    public Students   getOne(int  id){
        return   studentsService.getOne(new QueryWrapper<Students>().eq("sid",id));
    }

    @GetMapping("/getMap")
    public Map<String, Object>   getMap(int  id){
        return   studentsService.getMap(new QueryWrapper<Students>().eq("sid",id));
    }

    @GetMapping("/list")
    public List<Students>   list1(){
        return   studentsService.list();
    }

    @GetMapping("/list1")
    public List<Map<String, Object>>   list2(){
        return   studentsService.listMaps();
    }

    //add
    @GetMapping("/add")
    public String insert(@ModelAttribute  Students students){
        return  studentsService.save(students)==true?"新增成功":"新增失败";
    }

    //delete
    @GetMapping("/removeById1")
    public String removeById(Integer  id ){
        return  studentsService.removeById(id)==true?"删除成功":"删除失败";
    }

    @GetMapping("/removeById2")
    public String removeById1(Integer  id ){
        return  studentsService.remove(new QueryWrapper<Students>().eq("sid",id))==true?"删除成功":"删除失败";
    }

    //update
    @GetMapping("/updateById1")
    public String  updateById1(@ModelAttribute Students students ){
        return  studentsService.updateById(students)==true?"更新成功":"更新失败";
    }

    @GetMapping("/updateById2")
    public String  updateById2(@ModelAttribute Students students){
        return  studentsService.update(students,new QueryWrapper<Students>().eq("sage",students.getSage()))==true?"更新成功":"更新失败";
    }

    @PostMapping("/updateById3")//批量更新-可选值每次更新条数
    public String  updateById3(@RequestParam("entityLists")  Collection<Students> entityLists){
        return  studentsService.updateBatchById(entityLists)==true?"更新成功":"更新失败";
    }

    //insert
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
