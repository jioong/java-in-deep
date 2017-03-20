package com.github.jioong.basic.quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jioong on 17-3-20.
 */

@Configuration
@ComponentScan
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }

    @Bean
    MessageService  mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Happy to see you!";
            }
        };
    }
}
