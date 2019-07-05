package com.mybatis.mybatisplus.demo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mybatis.mybatisplus.demo1.entity.Students;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.mapper
 * ClassName:     StudentsMapper
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/2 18:11
 * Author         gaohaijiang
 * Version        V1.0.0
 */
public interface StudentsMapper extends BaseMapper<Students> {

    //ByName
    @Select("select  a.sid,a.sname,a.ssex,c.cname,b.score,d.tname " +
            "from students a LEFT JOIN scores b ON b.sid=a.sid LEFT JOIN course c on b.cid=c.cid  LEFT  JOIN teacher d ON c.tid=d.tid " +
            "where a.sname=#{name}")
    List<Map<String,Object>>  getStuByName(IPage<Map<String,Object>> page,String name);

    //ById
    @Select("select  a.sid,a.sname,a.ssex,c.cname,b.score,d.tname " +
            "from students a LEFT JOIN scores b ON b.sid=a.sid LEFT JOIN course c on b.cid=c.cid  LEFT  JOIN teacher d ON c.tid=d.tid " +
            "where a.sid=#{sid}")
    List<Map<String,Object>>  getStuById(IPage<Map<String,Object>> page,Integer sid);

    //ById--return:Ipage
    @Select("select  a.sid,a.sname,a.ssex,c.cname,b.score,d.tname " +
            "from students a LEFT JOIN scores b ON b.sid=a.sid LEFT JOIN course c on b.cid=c.cid  LEFT  JOIN teacher d ON c.tid=d.tid " +
            "where a.sid=#{sid}")
    IPage<Map<String,Object>>  getStuTotalById(IPage<Map<String,Object>>  page,Integer sid);
}
