package com.example.demo;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        final String[] packagesToScan = {"com.example.demo.controller"};
        return GroupedOpenApi
                .builder()
                .group("cars")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/cars/**")
                .build();
    }

}
