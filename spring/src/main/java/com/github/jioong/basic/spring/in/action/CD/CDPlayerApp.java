package com.github.jioong.basic.spring.in.action.CD;

import com.github.jioong.basic.spring.in.action.CD.impl.BlankDisc;
import com.github.jioong.basic.spring.in.action.condition.ExpressiveConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jioong on 17-3-23.
 */
public class CDPlayerApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/xml-wiring.xml");
        CompactDisc cd = (CompactDisc) context.getBean("compactDisc");
        cd.play();

        context = new AnnotationConfigApplicationContext(ExpressiveConfig.class);
        cd = (CompactDisc) context.getBean("disc");
        cd.play();
    }
}
