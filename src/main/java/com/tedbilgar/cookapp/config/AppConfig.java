package com.tedbilgar.cookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

/**
 * Менять:
 * - basePackages
 * */
@Configuration
@Import({DatasourceConfig.class, PersistenceConfig.class})
@ComponentScan(basePackages = {"com.tedbilgar.cookapp.services", "com.tedbilgar.cookapp.mappers"})
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
