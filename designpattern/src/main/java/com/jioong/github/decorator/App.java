package com.jioong.github.decorator;

/**
 * Created by jioong on 17-9-1.
 */
public class App {

    public static void main(String[] args) {

        Tea jasmineTea = new JasmineTea(); // 先冲一杯倾向的茉莉茶
        Tea lemonJasmineTea = new Lemon(jasmineTea); // 然后向茶中加入一颗柠檬

        System.out.println(lemonJasmineTea.getDescription()); // 一杯生津止渴的 “lemon jasmine tea” 就泡好了
    }

    /*

     */
    public void test(String a, String b) {

        // 风格1
        if (condition) {
            statement;
        }

        // 风格2
        if (condition)
        {
            statement;
        }
    }
}
