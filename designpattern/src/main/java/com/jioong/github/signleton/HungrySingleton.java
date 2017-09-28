package com.jioong.github.signleton;

/**
 * Created by jioong on 17-8-30.
 */
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton(); // 直接创建唯一实例

    private HungrySingleton() {

    }

    /*
        获取对象的唯一访问点
     */
    public static HungrySingleton getInstance() {
        return singleton; // 每次直接使用已创建的实例对象返回
    }
}
