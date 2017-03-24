package com.github.jioong.basic.spring.in.action.condition;

import com.github.jioong.basic.spring.in.action.CD.impl.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by jioong on 17-3-24.
 */

@Configuration
@PropertySource("classpath:/META-INF/spring/app.properties") //这里路径的根也是resources目录
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(env.getProperty("disc.title"), env.getProperty("disc.artist"));
    }
}
