package br.com.cotiinformatica.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("API listaDeConvidados - João Paulo")
                        .description("Projeto Spring Boot API para controle de convidados")
                        .version("v1")
                        .contact(new Contact()
                                .name("Dev João Paulo Monteiro")
                                .email("jotapemonteiro507@gmail.com")
                                .url("https://www.cotiinformatica.com.br"))
                        .license(new License()
                                .name("Licença")
                                .url("https://www.cotiinformatica.com.br"))
                        .termsOfService("https://www.cotiinformatica.com.br"));
    }
}