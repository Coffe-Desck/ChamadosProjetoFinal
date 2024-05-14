package com.ElasTechProjetoFinal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springBlogPessoalOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Coffee Desck")
                        .description("Projeto final ElasTech - SoulCode")
                        .version("V0.0.1")
                        .license(new License()
                                .name("Coffe Desck")
                                .url("https://github.com/Coffe-Desck"))
                        .contact(new Contact()
                                .name("Repositorio da api")
                                .url("https://github.com/Coffe-Desck/ChamadosProjetoFinal")
                                .email("coffedesck@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub")
                        .url("https://github.com/Coffe-Desck/ChamadosProjetoFinal"));
    }
}
