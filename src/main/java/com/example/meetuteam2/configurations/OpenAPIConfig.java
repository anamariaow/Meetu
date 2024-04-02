package com.example.meetuteam2.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPIConfig(){
        //developers
        Contact developer = new Contact();
        developer.setName("Antonio Taminto, Ana Balasa, Samira Saud, Elisabetta Tacconelli, Mattia Lattanzio");
        developer.setEmail("meetu@gmail.com");


        Info info = new Info();
        info.title("Meetu@");
        info.setContact(developer);
        info.setVersion("0.5");
        info.setDescription("welcome to my webApp Meetu@");

        return new OpenAPI().info(info);
    }
}
