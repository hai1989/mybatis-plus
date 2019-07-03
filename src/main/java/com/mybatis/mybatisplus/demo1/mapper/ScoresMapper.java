package com.mybatis.mybatisplus.demo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.mybatisplus.demo1.entity.Scores;
import org.apache.ibatis.annotations.Param;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.mapper
 * ClassName:     ScoresMapper
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:44
 * Author         gaohaijiang
 * Version        V1.0.0
 */
public interface ScoresMapper  extends BaseMapper<Scores> {

    //自定义分页-注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
    public IPage<Scores>  selectPageScore(Page<Scores>page, @Param("sid") Integer sid);
}
