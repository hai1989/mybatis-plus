package com.mybatis.mybatisplus.demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.entity
 * ClassName:     Scores
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 9:58
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Data
@TableName("scores")
public class Scores implements Serializable {

    private static final long serialVersionUID = -119832114657126659L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer sid;
    private Integer cid;
    private Integer score;
}
