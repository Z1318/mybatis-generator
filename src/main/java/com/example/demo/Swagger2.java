package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ Author     ：ZYP
 * @ Date       ：Created in 10:31 2019/1/10
 * @ Description：Swagger2配置类
 * 在与spring boot集成时，放在与Application.java同级的目录下。
 * 通过@Configuration注解，让Spring来加载该类配置。
 * 再通过@EnableSwagger2注解来启用Swagger2。
 *
 * @ Modified By：
 * @Version: $version$
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))//扫描包路径
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiImplicitParams.class))//根据注解定制
                .paths(PathSelectors.any())//定义那些接口需要生成文档
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        Contact contact = new Contact("ZYP","www.baidu.com","13259517109@163.com");
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful API")//文档首页标题
                .description("swagger2-文档构建利器")//文档描述信息
                .contact(contact) //创建者信息
                .version("1.0.0") //文档版本
                .build();
    }



}
