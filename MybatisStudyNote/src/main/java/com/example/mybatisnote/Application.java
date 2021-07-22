package com.example.mybatisnote;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("om.example.mybatisnote.mapper") //扫描mapper接口,因为componentscan扫描的是实现类 所以mybatis实现了这个接口扫描
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
