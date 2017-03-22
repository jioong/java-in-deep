package com.github.jioong.basic.spring.in.action.CD.impl;

import com.github.jioong.basic.spring.in.action.CD.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jioong on 17-3-22.
 */

@Configuration
//@ComponentScan 屏蔽自动扫描机制
public class CDPlayerConfig {

    @Bean(name = {"happy", "nice"})
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }
}
