package com.bankingsystem.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


@Bean
public OpenAPI bankingOpenAPI() {

    return new OpenAPI()
            .info(
                    new Info()
                            .title("Banking Mini Core System API")
                            .description("Enterprise Banking Backend APIs")
                            .version("1.0")
                            .contact(
                                    new Contact()
                                            .name("Developer")
                                            .email("developer@bank.com")
                            )
            )
            .externalDocs(
                    new ExternalDocumentation()
                            .description("Project Documentation")
            );
}


}
