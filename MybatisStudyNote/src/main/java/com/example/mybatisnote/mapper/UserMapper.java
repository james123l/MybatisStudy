package com.example.mybatisnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisnote.entity.User;
import org.springframework.stereotype.Component;

//user类的映射类
@Component
public interface UserMapper extends BaseMapper<User> {

}
