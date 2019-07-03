package com.mybatis.mybatisplus.demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.entity
 * ClassName:     Students
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/2 18:00
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Data
@TableName(value = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Students implements Serializable {

    private static final long serialVersionUID = 2668869280449957356L;

    @TableId(value = "sid",type = IdType.AUTO)
    private Integer sid;
    private String sname;
    private Integer sage;
    private String ssex;

    public Students(String sname,Integer sage,String ssex){
        this.sname = sname;
        this.sage  = sage;
        this.ssex  = ssex;
    }
}
