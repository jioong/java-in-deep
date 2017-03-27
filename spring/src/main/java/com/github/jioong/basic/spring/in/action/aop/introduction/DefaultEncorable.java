package com.github.jioong.basic.spring.in.action.aop.introduction;

/**
 * Created by jioong on 17-3-27.
 */
public class DefaultEncorable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("Encorable ...");
    }
}
