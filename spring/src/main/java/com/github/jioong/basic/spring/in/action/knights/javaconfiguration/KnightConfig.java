package com.github.jioong.basic.spring.in.action.knights.javaconfiguration;

import com.github.jioong.basic.spring.in.action.knights.BraveKnight;
import com.github.jioong.basic.spring.in.action.knights.Knight;
import com.github.jioong.basic.spring.in.action.knights.Quest;
import com.github.jioong.basic.spring.in.action.knights.xml.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jioong on 17-3-21.
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
