package com.demo.springcloud.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Jusven
 * @Date 2020/10/14 17:30
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.demo.springcloud.controller"})
public class SwaggerConfig {
@Bean
    public Docket productApi() {
            return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
//            .select()
//            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //添加ApiOperiation注解的被扫描
//            .paths(PathSelectors.any())
//            .build();
        }
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("Spring Boot中使用Swagger2构建RESTful APIs")
                    .description("8001")
                    .termsOfServiceUrl("http://blog.didispace.com/")
                    .contact("jusven")
                    .version("1.0")
                    .build();
            }
        }