package com.mizael.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mizael.bookstore.service.Dbservice;

@Configuration
@Profile("teste")
public class TestConfig {

    @Autowired
    private Dbservice dbservice;

    @Bean
    public void instanciaBaseDeDados(){
        this.dbservice.instanciaBaseDeDados();
    }



}
