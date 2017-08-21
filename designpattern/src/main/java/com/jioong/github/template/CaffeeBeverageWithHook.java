package com.jioong.github.template;

/**
 * Created by jioong on 17-8-21.
 */
public abstract class CaffeeBeverageWithHook {

    public void prepareRecipe() {
        boilWater();
        brew();
        poutInCup();
        if (customerWantCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    private final void boilWater() {
        System.out.println("Boiling water");
    }

    private void poutInCup() {
        System.out.println("Pouring into cup");
    }

    public boolean customerWantCondiments() {
        return true;
    }

}
