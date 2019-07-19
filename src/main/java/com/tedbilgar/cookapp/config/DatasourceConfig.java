package com.tedbilgar.cookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Конифигурация для дата соурса
 *
 * Менять:
 * - getDataSource
 * */
@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource dataSource(){
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        dataSourceLookup.setResourceRef(true);
        DataSource dataSource = dataSourceLookup.getDataSource("jdbc/cookapp_db");
        return dataSource;
    }

    @Bean
    public Properties dataSourceProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
        properties.setProperty("hibernate.jdbc.batch_size", "25");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.format_sql", "false");
        properties.setProperty("hibernate.use_sql_comments", "false");
        return properties;
    }
}
