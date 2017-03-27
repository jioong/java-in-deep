package com.github.jioong.basic.spring.in.action.aop;

/**
 * Created by jioong on 17-3-27.
 */
public class JayChou implements Performance {

    @Override
    public void perform() {

        System.out.println("Welcome to Jay Chou's concert");
        try {
            throw new Exception("忘词了。");
        } catch (Exception e) {
            System.out.println("/(ㄒoㄒ)/~~");
        }

    }
}
