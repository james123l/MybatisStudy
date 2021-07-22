package com.example.mybatisnote.testApi.mapperapi;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisnote.entity.User;
import com.example.mybatisnote.mapper.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.*;

public class UserMapperApi {
    @Resource
    private UserMapper userMapper;

    //查询所有User
    public List selectList(){
        List<User> users = userMapper.selectList(null);
        return users;
    }

    //根据id查询User
    public User selectLById(int id){
        User user = userMapper.selectById(id);
        // 测试乐观锁
        // user.setAge(200);
        //userMapper.updateById(user);
        return user;
    }

    //多id批量查询
    public List queryUserBatchId(Integer... ids){
        List<User> list = userMapper.selectBatchIds(Arrays.asList(ids));
        //ByMap查询
//        Map map = new HashMap();
//        map.put("name","James");
//        map.put("age","18");
//        List byMap = userMapper.selectByMap(map);
        return list;
    }

    //添加user
    public void addUser(){
        User user = new User();
        //主键自增不需要赋值
        user.setAge(1);
        user.setEmail("123@gmail.com");
        user.setName("Tom");
        //返回影响行数
        int i = userMapper.insert(user);
    }

    //修改
    public void updateUser(int id){
        User user = new User();
        user.setId(2l);
        user.setAge(200);
        //只会更改年龄 其他的不会修改
        int i = userMapper.updateById(user);
    }

    //分页查询
    public Page queryByPages(){
        //查找第一页 每页有三个记录
        Page<User> page = new Page<>(1,3);
        //将分页封装的数据放在page对象内
        userMapper.selectPage(page,null);
        page.getCurrent();//当前页
        page.getRecords();//获取每页数据的list集合
        page.getSize();//每页记录数
        page.getTotal();//总记录数
        page.getPages();//总页数
        page.hasNext();//是否有下一页
        page.hasPrevious();//是否有上一页
        return page;
    }

    //如果没配置逻辑删除就是物理删除 配置后就是逻辑删除
    public void deleteById(Integer id){
        //影响行数
        int i = userMapper.deleteById(id);
    }

    //批量删除
    public void deleteBatchById(Integer... ids){
        //影响行数
        int i = userMapper.deleteBatchIds(Arrays.asList(ids));
    }


}
