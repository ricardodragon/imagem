package com.dibros.imagem.security.filter;

import com.nimbusds.jwt.SignedJWT;
import com.dibros.core.token.property.JwtConfiguration;
import com.dibros.core.token.converter.TokenConverter;
import com.dibros.core.token.filter.JwtTokenAuthorizationFilter;
import lombok.SneakyThrows;
import org.springframework.lang.NonNull;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.dibros.core.token.util.SecurityContextUtil.setSecurityContext;

public class ImagemJwtTokenAuthorizationFilter extends JwtTokenAuthorizationFilter {

    public ImagemJwtTokenAuthorizationFilter(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter) {
        super(jwtConfiguration, tokenConverter);
    }

    @Override
    @SneakyThrows
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader(jwtConfiguration.getHeader().getName());

        if (header == null || !header.startsWith(jwtConfiguration.getHeader().getPrefix())) {
            filterChain.doFilter(request, response);
            return;
        }

        String signedToken = header.replace(jwtConfiguration.getHeader().getPrefix(), "").trim();

        tokenConverter.validateTokenSignature(signedToken);

        setSecurityContext(SignedJWT.parse(signedToken));

        filterChain.doFilter(request, response);
    }


}
