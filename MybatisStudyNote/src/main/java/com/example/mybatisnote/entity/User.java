package com.example.mybatisnote.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    //命名规则 mysql使用下划线 对应java的驼峰命名

    //主键注解
    //TYPE  AUTO:自增长 INPUT:自己输入 NONE:无策略 UUID:使用uuid ID_WORKER:生成19位数值，适用数值  ID_WORKER:适合字符串
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    //插入时自动填充
    @TableField(fill= FieldFill.INSERT)
    private Date createTime;

    //插入和更改的时候自动填充
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //版本号 用于乐观锁（需要插件）
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic //逻辑删除标志位 可以在配置文件设置删除标志值
    private Integer deleted;
}
