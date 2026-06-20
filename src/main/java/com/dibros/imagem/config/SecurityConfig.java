package com.dibros.imagem.config;

import com.dibros.core.token.config.TokenConfig;
import com.dibros.core.token.filter.JwtTokenAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig extends TokenConfig {

    @Bean
    @Override
    public SecurityWebFilterChain configure(ServerHttpSecurity http){
        http.addFilterAt(new JwtTokenAuthorizationFilter(), SecurityWebFiltersOrder.AUTHORIZATION);
        return super.configure(http);
    }
}
