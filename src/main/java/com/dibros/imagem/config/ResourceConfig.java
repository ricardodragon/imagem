package com.dibros.imagem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class ResourceConfig implements WebFluxConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
        resourceHandlerRegistry
            .addResourceHandler("/public/imagens/**")
            .addResourceLocations("file:///C:/Users/ricar/OneDrive/Área de Trabalho/Projects/SERVIDOR - PROD -/imagens/");
    }
}
