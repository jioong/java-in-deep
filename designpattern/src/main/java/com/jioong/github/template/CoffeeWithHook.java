package com.jioong.github.template;

/**
 * Created by jioong on 17-8-21.
 */
public class CoffeeWithHook extends CaffeeBeverageWithHook {
    void brew() {
        System.out.println("riping coffee through filter");
    }

    void addCondiments() {
        System.out.println("Adding sugar into milk");
    }

    /**
     * 这里可以自定义钩子的判断
     * @return
     */
    public boolean customerWantsCondiments() {
        return false;
    }




}
