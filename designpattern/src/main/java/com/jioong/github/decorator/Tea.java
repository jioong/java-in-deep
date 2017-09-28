package com.jioong.github.decorator;

/**
 * Created by jioong on 17-9-1.
 */

/*
    为一个抽象类，所有的茶都需要直接或间接的继承它
 */
public abstract class Tea {

    private String description = "tea";

    public String getDescription() {
        return description;
    }
}
