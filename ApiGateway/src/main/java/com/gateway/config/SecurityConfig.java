package com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;

@Configuration
@EnableWebFluxSecurity // We used this because we are using Api gateway
public class SecurityConfig {

    /**
     * We are using Webflux security
     */
    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange((exchanges) -> exchanges
                        .pathMatchers("/quiz/**").permitAll()
                        .pathMatchers("//quiz-test//**").permitAll()
                        .pathMatchers("/question/**").permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2Client(Customizer.withDefaults()) // Configure OAuth2 client with default settings
                .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));
        return http.build();
    }

//    @Bean
//    public ReactiveJwtDecoder jwtDecoder() {
//        // Configure the JwtDecoder with the necessary details for your JWT provider
//        // For example, if using NimbusJwtDecoder:
//        return NimbusReactiveJwtDecoder.withJwkSetUri("https://dev-54450627.okta.com/oauth2/default/.well-known/jwks.json")
//                .build();
//    }

}
