package com.mybatis.mybatisplus.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.mybatisplus.demo1.entity.Students;
import com.mybatis.mybatisplus.demo1.mapper.StudentsMapper;
import com.mybatis.mybatisplus.demo1.service.IStudentsService;
import org.springframework.stereotype.Service;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.service.impl
 * ClassName:     StudentsServiceImpl
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/2 18:17
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper,Students> implements IStudentsService {

}
