package com.tedbilgar.cookapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Конфигурация работы с репозиториями
 * Менять:
 * - EnableJpaRepositories(value)
 * - setPackagesToScan (value)
 * */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = "com.tedbilgar.cookapp.repos")
public class PersistenceConfig {

    @Autowired
    private DataSource dataSource;

    @Resource
    private Properties dataSourceProperties;

    /**
     * Бин для работы с FactoryManager -> Для EntityManager -> для создания собственных запросов через Criteria API
     * */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.tedbilgar.cookapp.entities");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(dataSourceProperties);
        return em;
    }

    /**
     * Для использования над методом репозитория @Transactional
     * */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
