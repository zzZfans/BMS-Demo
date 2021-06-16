package com.zfans.bmsdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 11:20
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("BMSDemo RESTful APIs")
                        .description("BMSDemo RESTful APIs")
                        .termsOfServiceUrl("http://www.BMSDemo.com/")
                        .contact(new Contact("Zfans", "https://zzzfans.gitee.io/", "zzzfans@qq.com"))
                        .version("0.1")
                        .build())
                //分组名称
                .groupName("api")
                .select()
                //这里指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.zfans.bmsdemo.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}