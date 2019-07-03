package com.mybatis.mybatisplus.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.mybatisplus.demo1.entity.Teacher;
import com.mybatis.mybatisplus.demo1.mapper.TeacherMapper;
import com.mybatis.mybatisplus.demo1.service.ITeacherService;
import org.springframework.stereotype.Service;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.service.impl
 * ClassName:     TeacherServiceImpl
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:39
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>  implements ITeacherService {
}
