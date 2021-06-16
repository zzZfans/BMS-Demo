package com.zfans.bmsdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.zfans.bmsdemo.mapper")
@SpringBootApplication
public class BmsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsDemoApplication.class, args);
    }

}
