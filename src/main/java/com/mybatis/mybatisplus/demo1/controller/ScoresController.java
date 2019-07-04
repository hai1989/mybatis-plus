package com.mybatis.mybatisplus.demo1.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.mybatisplus.demo1.entity.Scores;
import com.mybatis.mybatisplus.demo1.mapper.ScoresMapper;
import com.mybatis.mybatisplus.demo1.service.IScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.controller
 * ClassName:     ScoresController
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:49
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@RestController
@RequestMapping("scores")
public class ScoresController {

    @Autowired
    private IScoresService iScoresService;
    @Autowired
    private ScoresMapper scoresMapper;

    @GetMapping("findAll")
    public List<Scores> findAll(){
        return  iScoresService.list();
    }

    @GetMapping("searchPage1")//service分页
    public IPage<Scores> searchPage1(long current, long size){

        Page<Scores> page = new Page<Scores>(current,size,true);
        return  iScoresService.page(page);
    }

    @GetMapping("searchPage11")//service分页
    public IPage<Map<String, Object>> searchPage11(long current, long size){

        Page<Scores> page = new Page<Scores>(current,size,true);
        return  iScoresService.pageMaps(page);
    }
    @GetMapping("searchPage2")//mapper分页
    public IPage<Scores> searchPage2(long current, long size){

        return  scoresMapper.selectPage(new Page<Scores>(current,size,true),null);
    }

    @GetMapping("searchPage3")//XML 自定义分页
    public IPage<Scores> searchPage3(long current, long size,Integer sid){

        Page<Scores> page = new Page<Scores>(current,size,true);
//        page.setOptimizeCountSql(true);
//        page.setOrders(orders);
        return  iScoresService.selectScorePage(page,sid);
    }
}
