package com.saivarshith.springbootstarter.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Todo API")
                        .description("A spring boot starter template with JWT authentication, swagger docs and more")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("Sai Varshith")
                                .email("hosvarshith@gmail.com")));
    }
}
