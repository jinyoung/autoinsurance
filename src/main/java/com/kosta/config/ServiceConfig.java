package com.kosta.config;

import com.kosta.service.CreditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public CreditService creditService(){
        return new CreditService();
    }

}
