package com.jioong.github.signleton;

/**
 * Created by jioong on 17-8-17.
 */

/**
 * 使用同步会降低性能
 *
 */
public class SingeltonWithSynchronized {

    private static SingeltonWithSynchronized singleton;

    private SingeltonWithSynchronized() {}

    public static synchronized SingeltonWithSynchronized getInstance() {
        if (singleton == null) {
            singleton = new SingeltonWithSynchronized();
        }

        return singleton;
    }
}
