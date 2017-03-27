package com.github.jioong.basic.spring.in.action.aop;

import com.github.jioong.basic.spring.in.action.aop.config.ConcertConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jioong on 17-3-27.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
        Performance jay = (Performance) context.getBean("jay");
        jay.perform();

    }

}
