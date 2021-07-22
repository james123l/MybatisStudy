package com.example.mybatisnote.config;


import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MpConfig {

    //mybatis plus 乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    //逻辑删除插件
    public ISqlInjector iSqlInjector(){
        return new LogicSqlInjector();
    }

    //sql效率检测插件
    @Bean
    @Profile({"dev","test"})    //用户dev和test组
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // 在工作中，不允许用户等待
        performanceInterceptor.setMaxTime(20); // ms 设置sql执行的最大s时间,如果超过了则不执行
        performanceInterceptor.setFormat(true); // 是否进行格式化
        return new PerformanceInterceptor();
    }

}
