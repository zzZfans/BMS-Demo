package com.zfans.bmsdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class BmsDemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void dataSourceTest() throws SQLException {
        System.out.println(dataSource.getClass());
        // Hikari: class com.zaxxer.hikari.HikariDataSource -> Spring Boot 默认使用的是 HikariDataSource 数据源
        // Druid: class com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        // Hikari: HikariProxyConnection@1060512053 wrapping com.mysql.cj.jdbc.ConnectionImpl@21eee94f
        // Druid: com.mysql.cj.jdbc.ConnectionImpl@7b81616b
        //关闭连接
        connection.close();
    }
}
