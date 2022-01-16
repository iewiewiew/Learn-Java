/*
package com.wmh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.collect.Lists;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //作为Springfox框架的主要接口的构建器,提供合理的默认值和方便的配置方法。
    @Bean
    public Docket docket() {
        ParameterBuilder builder = new ParameterBuilder();
        builder.parameterType("header").name("token")
                .description("token值")
                .required(false) //设置为true则必须要传token
                .modelRef(new ModelRef("string")); //在swagger里显示header

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("java_web")
                .apiInfo(apiInfo())
                .globalOperationParameters(Lists.newArrayList(builder.build()))
                .select().paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Learn-Java系统") //标题
                .description("学习Java-Web接口文档") //描述
                .contact(new Contact("wmh", "", "1425615649@qq.com")) //联系人
                .version("1.0") //版本号
                .build();
    }
}*/
