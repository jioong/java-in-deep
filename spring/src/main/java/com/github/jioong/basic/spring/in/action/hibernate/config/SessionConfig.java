package com.github.jioong.basic.spring.in.action.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Created by jioong on 17-3-29.
 */
@Configuration
@ComponentScan
public class SessionConfig {

    @Bean
    public DataSource dataSource() {
        return new SimpleDriverDataSource();
    }

/*    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);

    }*/
}
