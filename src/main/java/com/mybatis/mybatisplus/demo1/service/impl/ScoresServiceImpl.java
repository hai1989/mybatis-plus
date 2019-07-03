package com.mybatis.mybatisplus.demo1.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.mybatisplus.demo1.entity.Scores;
import com.mybatis.mybatisplus.demo1.mapper.ScoresMapper;
import com.mybatis.mybatisplus.demo1.service.IScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.service.impl
 * ClassName:     ScoresServiceImpl
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:48
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Service
public class ScoresServiceImpl extends ServiceImpl<ScoresMapper, Scores>  implements IScoresService {

    @Autowired
    private  ScoresMapper scoresMapper;

    @Override
    public IPage<Scores> selectScorePage(Page<Scores> page, Integer sid) {
        return scoresMapper.selectPageScore(page,sid);
    }
}
