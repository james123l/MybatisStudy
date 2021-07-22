package com.example.mybatisnote.testApi.querywrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisnote.entity.User;

public class UserQueryWrapper {

    private QueryWrapper<User> wrapper =  new QueryWrapper<User>();

    //复杂条件查询
    public void selectQuery(){
        //查询age>30的数据 gt大于 ge大于等于 lt小于 le小于等于
        QueryWrapper<User> ageLargerThan30 = wrapper.ge("age", 30);
        //查询name 等于lilei的数据   eq等于 ne不等于
        QueryWrapper<User> eqlilei = wrapper.eq("name", "lilei");
        //查询between/notbetween 年龄在20-30
        QueryWrapper<User> between = wrapper.between("age", 20, 30);
        //模糊查询 like lilei的都查询
        QueryWrapper<User> like = wrapper.like("name", "lilei");
        //orderby 升降序
        //last 拼接到sql最后一句
        wrapper.like("name", "lilei").last(" limit 1");
        //指定查询的列 只查询id name
        wrapper.select("id","name");

    }
}
