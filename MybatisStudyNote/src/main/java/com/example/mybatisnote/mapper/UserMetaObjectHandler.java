package com.example.mybatisnote.mapper;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
* 实现user的create 和 update date 和乐观锁version的自动填充
* */
@Component //需要作为组件才起作用
public class UserMetaObjectHandler implements MetaObjectHandler {
    @Override   //添加操作的时候此方法执行
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("version",1,metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("createTime",new Date(),metaObject);
    }

    @Override  //修改操作的时候此方法执行
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }


}
