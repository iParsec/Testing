package com.crud.test.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfig {

	@Bean
    public DataSource dataSource() {
        // configuration de la source de données
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		/*
		 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 * dataSource.setUrl("jdbc:mysql://localhost:3306/crudtest");
		 * dataSource.setUsername("root"); dataSource.setPassword("");
		 */            
        dataSource.setUsername("BABA");
        dataSource.setPassword("1234");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");

        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        // configuration de l'objet JdbcTemplate
        return new JdbcTemplate(dataSource);
    }
    
    @Bean
    public LocalValidatorFactoryBean validator() {
        // configuration de l'objet Validator
        return new LocalValidatorFactoryBean();
    }
    
}
