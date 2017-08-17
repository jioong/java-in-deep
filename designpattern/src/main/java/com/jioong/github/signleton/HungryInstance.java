package com.jioong.github.signleton;

/**
 * Created by jioong on 17-8-17.
 */
public class HungryInstance {

    private static HungryInstance singleton = new HungryInstance();

    private HungryInstance() {}

    public static HungryInstance getInstance() {
        return singleton;
    }
}
