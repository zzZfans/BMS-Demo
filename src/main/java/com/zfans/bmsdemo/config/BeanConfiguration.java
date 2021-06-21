package com.zfans.bmsdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author Zfans
 * @DateTime 2021/6/21 17:07
 * ImportResource 引入资源文件有三种方式：
 * 1.直接引入，该路径就是 src/resources/ 下面的文件：file
 * 2.classpath 引入：该路径就是 src/java 下面的配置文件：classpath:file
 * 3.引入本地文件：该路径是一种绝对路径：file:C://....
 */
@ImportResource(locations = {"bean.xml"})
@Configuration
public class BeanConfiguration {
}
