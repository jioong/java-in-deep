package com.github.jioong.basic.spring.in.action.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by jioong on 17-3-27.
 */

@Aspect
public class Audience {

    @Pointcut("execution(* com.github.jioong.basic.spring.in.action.aop.Performance.perform(..))")
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    /**
     * 环绕通知
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones from around");
            System.out.println("Taking seats from around");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP from around");
        } catch (Throwable throwable) {
            System.out.println("Demanding a refund from around.");
        }
    }
}
