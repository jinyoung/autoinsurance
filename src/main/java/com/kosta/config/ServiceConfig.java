package com.kosta.config;

import com.kosta.service.CreditService;
import com.kosta.service.CreditServiceImp;
import com.kosta.service.DMVService;
import com.kosta.service.DMVServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public CreditService creditService(){
        return new CreditServiceImp();
    }

    @Bean
    public DMVService dmvService(){
        return new DMVServiceImp();
    }

}
