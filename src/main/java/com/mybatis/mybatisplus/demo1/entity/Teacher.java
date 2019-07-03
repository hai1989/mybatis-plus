package com.mybatis.mybatisplus.demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.entity
 * ClassName:     Teacher
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/2 18:37
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Data
@TableName(value = "teacher")
public class Teacher implements Serializable {
    private static final long serialVersionUID = -3063635569003553192L;

    @TableId(value = "tid",type = IdType.AUTO)
    private Integer tid;
    private String tname;
    private String ssex;
}
