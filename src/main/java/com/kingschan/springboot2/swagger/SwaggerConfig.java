package com.kingschan.springboot2.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${info.version}")
    private String version;

    @Bean
    public Docket innerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .genericModelSubstitutes(DeferredResult.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(false)
            .groupName("API-" + version)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.kingschan.springboot2"))
            .paths(PathSelectors.any())//过滤的接口
            .build();
    }

    @Bean
    public Docket openApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("开放API-" + version)
            .genericModelSubstitutes(DeferredResult.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(false)
            .apiInfo(openApiInfo())
            .select()
            .paths(PathSelectors.ant("/api/**"))//过滤的接口
            .build();
    }



    private ApiInfo apiInfo() {
        return createApiInfo("标题：spring boot 2 demo工程", "spring boot2练习工程");
    }

    private ApiInfo openApiInfo() {
        return createApiInfo("在线接口文档(开放文档)", "简单优雅的restfun风格");
    }


    private ApiInfo createApiInfo(String title, String description) {
        return new ApiInfoBuilder()
            .title(title)
            .description(description)
            .contact(new Contact("kings.chan", "", "kings.chan@qq.com"))
            .version(version)
            .build();
    }


}
