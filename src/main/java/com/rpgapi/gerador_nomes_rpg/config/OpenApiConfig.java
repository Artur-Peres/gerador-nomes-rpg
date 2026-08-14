package com.rpgapi.gerador_nomes_rpg.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public static final String SECURITY_SCHEME_NAME = "Bearer Authentication";

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Gerador de Nomes/NPCs RPG API")
                        .description("API REST desenvolvida para gerar NPC'S e Nomes para RPG de mesa")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Artur Peres e Jonatham Alves")
                                .email("jonatham.alves@academico.ifpb.edu.br")
                                .email("artur.peres@academico.ifpb.edu.br")
                                .url("https://github.com/Artur-Peres/gerador-nomes-rpg")))

                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))

                .schemaRequirement(
                        SECURITY_SCHEME_NAME,new SecurityScheme()
                                .name(SECURITY_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                );
    }
}
