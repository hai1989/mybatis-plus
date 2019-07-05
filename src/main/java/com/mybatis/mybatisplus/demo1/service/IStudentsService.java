package com.mybatis.mybatisplus.demo1.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.mybatisplus.demo1.entity.Students;

import java.util.List;
import java.util.Map;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.service
 * ClassName:     IStudentsService
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/2 18:15
 * Author         gaohaijiang
 * Version        V1.0.0
 */
public interface IStudentsService extends IService<Students> {

    List<Map<String,Object>> getStuInfoByName(IPage<Map<String,Object>> page, String name);

    List<Map<String,Object>>  getStuInfoById(IPage<Map<String,Object>> page,Integer sid);

    IPage<Map<String,Object>>  getStuInfoTotalById(IPage<Map<String,Object>>  page,Integer sid);
}
