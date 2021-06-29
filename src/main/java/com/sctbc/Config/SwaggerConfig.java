package com.sctbc.Config;


import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    //初始化组件

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30) //文档类型
                .apiInfo(apiInfo())  //界面信息 调用自己的
                .select() //扫描这个包下的所有接口
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) //加载接口信息
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()) //接口地址
                .build();
    }
    //Swagger界面的信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Sctbc接口文档")
                .description("Myxiaowang")
                .contact(new Contact("Myxiaowang","http://www.iwck.top","1049835177@qq.com"))
                .version("1.0")
                .build();
    }
}
