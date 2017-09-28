package com.jioong.github.decorator;

/**
 * Created by jioong on 17-9-1.
 */

/**
 * 现在小店只提供一种茶，茉莉茶。
 *
 * 可以向它添加不同的茶调料，搭配不同的口味
 */
public class JasmineTea extends Tea {

    @Override
    public String getDescription() {
        return "jasmine tea";
    }
}
