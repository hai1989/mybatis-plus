package com.mybatis.mybatisplus.demo1.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.mybatisplus.demo1.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.mapper
 * ClassName:     TeacherMapper
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:36
 * Author         gaohaijiang
 * Version        V1.0.0
 */
public interface TeacherMapper  extends BaseMapper<Teacher> {

    //Mybatisplus 自定义sql 使用条件构造器
    //动态查找：
//    @Select("select ${ew.SqlSelect} from ${tableName} ${ew.customSqlSegment}")
//    @Select("select ${ew.sqlSelect}  from ${tableName}  ${ew.customSqlSegment}")//xml启用后此处注释
    List<Teacher>  listByCondition(@Param("tableName") String tableName,@Param("ew") Wrapper wrapper);

//    动态修改：
//    @Update("update ${tableName} set ${ew.sqlSet} ${ew.customSqlSegment}")
//     int  updateByCondition(@Param("tableName") String tableName, @Param("ew") Wrapper wrapper);
    void  updateByCondition(@Param("tableName") String tableName, @Param("ew") Wrapper wrapper);

//    xml用法：
//    Page<File> selectPage(Page page, @Param("tableName") String tableName, @Param("ew") Wrapper wrapper);
//
//<select id="selectPage" resultType="com.example.entity.File">
//    select * from ${tableName} ${ew.customSqlSegment}
//</select>
}
