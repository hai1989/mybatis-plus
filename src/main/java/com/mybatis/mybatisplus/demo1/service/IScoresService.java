package com.mybatis.mybatisplus.demo1.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.mybatisplus.demo1.entity.Scores;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.service
 * ClassName:     IScoresService
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:46
 * Author         gaohaijiang
 * Version        V1.0.0
 */
public interface IScoresService extends IService<Scores> {

    public IPage<Scores> selectScorePage(Page<Scores> page,Integer sid);
}
