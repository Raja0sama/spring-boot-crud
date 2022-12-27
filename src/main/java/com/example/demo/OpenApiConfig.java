package com.example.demo;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SwaggerConfig {

    /*
    User API
     */
    @Bean
    public GroupedOpenApi userApi() {
        final String[] packagesToScan = {"com.controller"};
        return GroupedOpenApi
                .builder()
                .group("Car API")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/**")
                .addOpenApiCustomiser(statusApiCostumizer())
                .build();
    }

    private OpenApiCustomiser statusApiCostumizer() {
        return openAPI -> openAPI
                .info(new Info()
                        .title("Springboot & OpenAPI")
                        .description("This is a sample Spring Boot RESTful service using OpenAPI")
                        .version("3.0.0")
                        .contact(new Contact()
                                .name("Raja Osama")
                                .url("https://rajaosama.me")
                                .email("rajaosama.me@gmail.com")));
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Contact Application API").description(
                        "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }

}
