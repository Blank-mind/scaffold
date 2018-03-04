package com.appauth.config;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.sql.Timestamp;

/**
 * swagger-ui的配置
 *
 * @author ScienJus
 * @date 2015/7/10.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.appauth.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();


    }

    private ApiInfo apiInfo() {

        //这里可以是markdown
        String descriptionMarkdown =
                "AUTH";

        return new ApiInfoBuilder()
                .title("EDU-CMS")
                .description(descriptionMarkdown)
                .termsOfServiceUrl("39.106.59.44")
                .contact(new Contact(
                        "vzard",
                        "",
                        "vzardlloo.gmail.com"
                )).version("1.0").build();


    }


}
