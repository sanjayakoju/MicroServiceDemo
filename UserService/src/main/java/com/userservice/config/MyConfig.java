package com.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {


        RestTemplate restTemplate = new RestTemplate();

//        List<ClientHttpRequestInterceptor> interceptors=new ArrayList<>();
//
//        interceptors.add(new RestTemplateInterceptor(manager(
//                clientRegistrationRepository,
//                oAuth2AuthorizedClientRepository
//        )));
//
//        restTemplate.setInterceptors(interceptors);


        return restTemplate;


    }
}
