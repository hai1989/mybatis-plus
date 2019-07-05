package com.mybatis.mybatisplus.demo1.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.mybatisplus.demo1.entity.Students;
import com.mybatis.mybatisplus.demo1.mapper.StudentsMapper;
import com.mybatis.mybatisplus.demo1.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private   StudentsMapper studentsMapper;

    @Override
    public List<Map<String, Object>> getStuInfoByName(IPage<Map<String, Object>> page, String name) {
        return studentsMapper.getStuByName(page,name);
    }

    @Override
    public List<Map<String, Object>> getStuInfoById(IPage<Map<String, Object>> page, Integer sid) {
        return studentsMapper.getStuById(page,sid);
    }

    @Override
    public IPage<Map<String, Object>> getStuInfoTotalById(IPage<Map<String, Object>> page, Integer sid) {
        return studentsMapper.getStuTotalById(page,sid);
    }
}
