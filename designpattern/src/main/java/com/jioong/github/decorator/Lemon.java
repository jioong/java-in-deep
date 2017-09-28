package com.jioong.github.decorator;

/**
 * Created by jioong on 17-9-1.
 */

/*
    这是一个“茶”的装饰者，表示在茶中加入柠檬
 */
public class Lemon extends TeaDecorator {

    private Tea tea;

    /**
     * 注意：这里需要传入“一杯茶”，也就是要“被装饰”的对象
     * 这里的语义：有一杯茶，需要向茶中加入柠檬。
     * 理所当然的，柠檬就是一个“装饰者”
     */
    public Lemon(Tea tea) {
        this.tea = tea;
    }

    public String getDescription() {
        return "lemon " + tea.getDescription();
    }
}
