package com.mybatis.mybatisplus.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.mybatisplus.demo1.entity.Course;
import com.mybatis.mybatisplus.demo1.mapper.CourseMapper;
import com.mybatis.mybatisplus.demo1.service.ICourseService;
import org.springframework.stereotype.Service;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.service.impl
 * ClassName:     CourseServiceImpl
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:46
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Service
public class CourseServiceImpl  extends ServiceImpl<CourseMapper, Course> implements ICourseService {
}
