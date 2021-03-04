package com.game.bankline.config;

import springfox.documentation.service.*;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class    SwaggerConfig {
    private Set CONSUMES_PRODUCES = new HashSet<String>();

    @Bean
    public Docket productApi() {
        CONSUMES_PRODUCES.add("application/json");

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.game.bankline"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(singletonList(new ApiKey("Bearer", "Authorization", "header")))
                .securityContexts(singletonList(securityContext()))
                .enableUrlTemplating(true)
                .produces(CONSUMES_PRODUCES)
                .consumes(CONSUMES_PRODUCES)
                .directModelSubstitute(LocalDate.class, String.class)
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfo(
                "Bankline REST API",
                "API REST de um banco online.",
                "1.0",
                "Terms of Service",
                new Contact("Team 7 - Javeiros de Konoha", "https://github.com/tanakav/bankline-gama",
                        "https://github.com/tanakav/bankline-gama"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder
                .builder()
                .operationsSorter(OperationsSorter.METHOD)
                .build();
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(new SecurityReference("Bearer", authorizationScopes));
    }

}
