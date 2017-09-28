package com.jioong.github.signleton;

/**
 * Created by jioong on 17-8-30.
 */
public class LazySingleton {

    private static LazySingleton singleton; //使用静态对象来存储唯一实例

    /*
        该构造器的访问描述符为 private，所以使得其他的类不可以通过构造器来直接实例化该对象。
        那么怎么来构造该类的对象呢？
        通过下面提供的静态方法，在其中通过调用这个私有的构造器来实例化对象。与此同时，在该方法中控制使得该类只能有一个实例化对象。
        当然，单例的构造器也是可以传入参数的。只需要在下面的实例化方法getInstance()中传入构造对象需要的参数，即可。
     */
    private LazySingleton() {

    }

    /*
        该方法实现了对象的构造，并控制使得只能构造一个实例化对象。
     */
    public static LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }

        return singleton;
    }
}
