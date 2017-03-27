package com.github.jioong.basic.spring.in.action.aop.config;

import com.github.jioong.basic.spring.in.action.aop.JayChou;
import com.github.jioong.basic.spring.in.action.aop.Performance;
import com.github.jioong.basic.spring.in.action.aop.aspectj.Audience;
import com.github.jioong.basic.spring.in.action.aop.introduction.DefaultEncorable;
import com.github.jioong.basic.spring.in.action.aop.introduction.EncorableIntroducer;
import com.github.jioong.basic.spring.in.action.aop.introduction.Encoreable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by jioong on 17-3-27.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public Performance jay() {
        return new JayChou();
    }

    @Bean
    public Encoreable  encoreable() {
        return new DefaultEncorable();
    }

    @Bean
    public EncorableIntroducer encorableIntroducer() {
        return new EncorableIntroducer();
    }
}
