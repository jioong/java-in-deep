package com.jioong.github.signleton;

/**
 * Created by jioong on 17-8-17.
 */
public class LazyInstance {

    private static LazyInstance singleton;

    private LazyInstance() {}

    public static LazyInstance getInstance() {
        if (singleton == null) {
            singleton = new LazyInstance();
        }

        return singleton;
    }
}
