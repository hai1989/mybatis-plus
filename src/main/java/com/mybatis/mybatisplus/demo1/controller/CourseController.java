package com.mybatis.mybatisplus.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mybatis.mybatisplus.demo1.entity.Course;
import com.mybatis.mybatisplus.demo1.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/insert")
    public String insert(@ModelAttribute Course course){
        return   iCourseService.save(course)==true?"新增成功":"新增失败";
    }

    @GetMapping("/update")
    public String update(String cname,String cid){
        return   iCourseService.update(new UpdateWrapper<Course>().set("cname",cname).in("cid",cid))==true?"更新成功":"更新失败";
    }

    @GetMapping("/select")
    public List<Course> select(Integer cid){
        return   iCourseService.list(new QueryWrapper<Course>().eq("cid",cid).select("cname","tid"));
    }

    @GetMapping("/delete")
    public String delete(String cid){
        return   iCourseService.removeById(cid)==true?"更新成功":"更新失败";
    }
}
