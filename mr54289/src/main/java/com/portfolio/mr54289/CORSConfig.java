package com.portfolio.mr54289;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer CORSConfigurer(){
        return new WebMvcConfigurerImpl();
    }

    private static class WebMvcConfigurerImpl implements WebMvcConfigurer {

        public WebMvcConfigurerImpl() {
        }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedOrigins("https://proyectoargprogr.web.app/","http://localhost:4200/").allowedMethods("*").allowedHeaders("*");
        }
    }
}
