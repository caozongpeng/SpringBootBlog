package com.wip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.wip.dao")
//@EnableCaching
public class MyBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogApplication.class, args);
    }
}
