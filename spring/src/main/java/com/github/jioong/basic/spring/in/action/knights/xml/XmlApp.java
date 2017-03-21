package com.github.jioong.basic.spring.in.action.knights.xml;

import com.github.jioong.basic.spring.in.action.knights.Knight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jioong on 17-3-21.
 */
public class XmlApp {

    public static void main(String[] args) {

        /**
         * xml配置文件的根目录为 resources 目录
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/xml-wiring.xml");

        Knight knight = (SlayKnight) context.getBean("knight");
        knight.embarkOnQUest();
    }
}
