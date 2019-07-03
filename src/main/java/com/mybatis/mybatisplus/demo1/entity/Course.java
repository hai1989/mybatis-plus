package com.mybatis.mybatisplus.demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.entity
 * ClassName:     Course
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 9:53
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Data
@TableName("course")
public class Course implements Serializable {

    private static final long serialVersionUID = 5446236271447066459L;

    @TableId(value = "cid",type = IdType.AUTO)
    private  Integer  cid;
    private  String   cname;
    private  Integer tid;
}
