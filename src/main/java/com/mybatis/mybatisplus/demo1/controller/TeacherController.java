package com.mybatis.mybatisplus.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mybatis.mybatisplus.demo1.entity.Teacher;
import com.mybatis.mybatisplus.demo1.mapper.TeacherMapper;
import com.mybatis.mybatisplus.demo1.service.ITeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.controller
 * ClassName:     TeacherController
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 12:40
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private ITeacherService iTeacherService;
    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/findCon")
    public List<Teacher> findCon(String column,String values){

        return  teacherMapper.listByCondition("teacher",Wrappers.query().select("*").in(column,values));
    }

//    @GetMapping("/updateCon")
//    public String updateCon(String column,String values){
//
//        return  teacherMapper.updateByCondition("teacher",Wrappers.<Teacher>update().set("ssex","女").in(column,values))==1?"成功":"失败";
//    }
    @GetMapping("/updateCon")
    public String updateCon(String column,String values){
           boolean flag =false;
          teacherMapper.updateByCondition("teacher",Wrappers.<Teacher>update().set("ssex","女").in(column,values));
          flag=true;
          return  flag==true?"成功":"失败";

    }
    @GetMapping("/findAll")
    public List<Teacher> findAll(){

        return  iTeacherService.list();
    }
    //条件构造器
    //AbstractWrapper
    //1-全部eq(或个别isNull)
    @GetMapping("/findAllEq")
    public List<Teacher> findAllEq(){
       Map<String,Object> map = new HashMap<>();
       map.put("tname","张老师");
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().allEq(map));
    }
    //2-等于 =
    @GetMapping("/findColumnEq")
    public List<Teacher> findColumnEq(String column,String value){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().eq(column,value));
    }

    //3-不等于 <>
    @GetMapping("/findColumnNe")
    public List<Teacher> findColumnNe(String column,String value){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().ne(true,column,value));
    }

    //4-大于 >
    @GetMapping("/findColumnGt")
    public List<Teacher> findColumnGt(Integer id){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().gt("tid",id));
    }

    //5-大于等于 >=
    @GetMapping("/findColumnGe")
    public List<Teacher> findColumnGe(Integer id){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().ge("tid",id));
    }

    //6-小于 <
    @GetMapping("/findColumnLt")
    public List<Teacher> findColumnLt(Integer id){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().lt("tid",id));
    }

    //7-小于等于 <=
    @GetMapping("/findColumnLe")
    public List<Teacher> findColumnLe(Integer id){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().le("tid",id));
    }

    //8-BETWEEN 值1 AND 值2
    @GetMapping("/findIdBeteen")
    public List<Teacher> findIdBeteen(Integer id1,Integer id2){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().between("tid",id1,id2));
    }

    //10-LIKE '%值%'
    @GetMapping("/findNameLike")
    public List<Teacher> findNameLike(String nameLike){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().like("tname",nameLike));
    }

    //11-NOT LIKE '%值%'
    @GetMapping("/findNameNotLike")
    public List<Teacher> findNameNotLike(String nameLike){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().notLike("tname",nameLike));
    }

    //12-LIKE '%值'
    @GetMapping("/findNameLikeLeft")
    public List<Teacher> findNameLikeLeft(String nameLike){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().likeLeft("tname",nameLike));
    }

    //13-LIKE '值%'
    @GetMapping("/findNameLikeRight")
    public List<Teacher> findNameLikeRight(String nameLike){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().likeRight("tname",nameLike));
    }
    //14- isNull
    @GetMapping("/findSexNull")
    public List<Teacher> findSexNull(String column){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().isNull(column).or().eq(column,""));
    }

    //15- isNotNull
    @GetMapping("/findSexNotNull")
    public List<Teacher> findSexNotNull(String column){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().isNotNull(column));
    }

    //16- 字段 IN (value.get(0), value.get(1), ...)
    @PostMapping("/findIdIN")
    public List<Teacher> findIdIN(String column,String ...values){//String ...values 多值-相当于list
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().in(column,values));
    }

    //17- 字段 NOT IN (v0, v1, ...)
    @PostMapping("/findIdNotIN")
    public List<Teacher> findIdNotIN(String column,String ...values){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().notIn(column,values));
    }

    //18- 字段 IN ( sql语句 )
    //例: inSql("age", "1,2,3,4,5,6")--->age in (1,2,3,4,5,6)
    //例: inSql("id", "select id from table where id < 3")--->id in (select id from table where id < 3)
    @PostMapping("/findIdInSql")
    public List<Teacher> findIdInSql(String column,String sqlStr){
        log.info(sqlStr);
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().inSql(column,sqlStr));
    }

    //19- 字段 NOT IN ( sql语句 )
    //例: notInSql("age", "1,2,3,4,5,6")--->age not in (1,2,3,4,5,6)
    //例: notInSql("id", "select id from table where id < 3")--->age not in (select id from table where id < 3)
    @PostMapping("/findIdInNotSql")
    public List<Teacher> findIdInNotSql(String column,String sqlStr){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().notInSql(column,sqlStr));
    }

    //20-分组：GROUP BY 字段, ...
    @GetMapping("/findNameGroupBy")
    public List<Teacher> findNameGroupBy(String column){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().groupBy(column));
    }

    //21-HAVING ( sql语句 )
    @PostMapping("/findNameGroupByHaving")
    public List<Teacher> findNameGroupByHaving(String column,String sqlHaving){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().groupBy(column).having(sqlHaving));
    }

    //22-排序：ORDER BY 字段, ...
    @GetMapping("/findNameOrderBy")
    public List<Teacher> findNameOrderBy(String column){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().orderByAsc(column));
    }

    //22-排序：ORDER BY 字段, ...
    @GetMapping("/findNameOrderBy1")
    public List<Teacher> findNameOrderBy1(String column){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().orderByDesc(column));
    }

    //23-拼接 OR 主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
    //OR 嵌套
    //例: or(i -> i.eq("name", "李白").ne("status", "活着"))--->or (name = '李白' and status <> '活着')
//    AND 嵌套
////    例: and(i -> i.eq("name", "李白").ne("status", "活着"))--->and (name = '李白' and status <> '活着')

    @GetMapping("/findAnd")
    public List<Teacher> findAnd(String column1,String value1,String column2,String value2){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().eq(column1,value1).gt(column2,value2));
    }

    //24-拼接 EXISTS ( sql语句 )
    @PostMapping("/findexists")
    public List<Teacher> findexists(String sql){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().exists(sql));
    }

    //25-last-无视优化规则直接拼接到 sql 的最后
    @PostMapping("/findLast")
    public List<Teacher> findLast(String sql){
        return  teacherMapper.selectList(new QueryWrapper<Teacher>().last(sql));
    }

    //26-nested    正常嵌套 不带 AND 或者 OR
    //    例: nested(i -> i.eq("name", "李白").ne("status", "活着"))--->(name = '李白' and status <> '活着')
    //apply --拼接 sql该方法可用于数据库函数 动态入参的params对应前面applySql内部的{index}部分.这样是不会有sql注入风险的,反之会有!
    //
    //    例: apply("id = 1")--->id = 1
    //    例: apply("date_format(dateColumn,'%Y-%m-%d') = '2008-08-08'")--->date_format(dateColumn,'%Y-%m-%d') = '2008-08-08'")
    //    例: apply("date_format(dateColumn,'%Y-%m-%d') = {0}", "2008-08-08")--->date_format(dateColumn,'%Y-%m-%d') = '2008-08-08'")

     //QueryWrapper
     @PostMapping("/findSelect")
     public List<Teacher> findSelect(String ...column){
         return  teacherMapper.selectList(new QueryWrapper<Teacher>().select(column));
//         return  teacherMapper.selectList(new QueryWrapper<Teacher>().select(i->i.getProperty().endsWith("s")));
     }

     // UpdateWrapper
     @PostMapping("/updateSetSql")
     public String updateSetSql(@ModelAttribute   Teacher teacher, String setSql){
         return  teacherMapper.update(teacher,new UpdateWrapper<Teacher>().eq("tid",teacher.getTid()).setSql(setSql))==1?"成功":"失败";
     }


}
