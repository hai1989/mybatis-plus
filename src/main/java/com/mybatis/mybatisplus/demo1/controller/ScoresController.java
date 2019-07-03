package com.mybatis.mybatisplus.demo1.controller;

import com.mybatis.mybatisplus.demo1.entity.Scores;
import com.mybatis.mybatisplus.demo1.service.IScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("findAll")
    public List<Scores> findAll(){
        return  iScoresService.list();
    }
}
