package com.jioong.github.signleton;

/**
 * Created by jioong on 17-8-17.
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton singleton; // volatile 修饰符保证变量在多线程之间的可见性

    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if (singleton == null) {  // 检查实例，如果不存在就进入同步区
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) { // 进入同步区后在检查一次，如果还是为null,才创建对象
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
