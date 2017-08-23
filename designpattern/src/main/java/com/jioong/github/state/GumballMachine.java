package com.jioong.github.state;

/**
 * Created by jioong on 17-8-23.
 */
public class GumballMachine {

    private static final int SOLD_OUT = 0;
    private static final int NO_QUARTER = 1;
    private static final int HAS_QUARTER = 2;
    private static final int SOLD = 3;

    private int state = SOLD_OUT;
    private int count = 0;

    public GumballMachine(int count) {
        this.count = count;

        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("You cannot insert another quarter");
        } else if (state == NO_QUARTER) {
            System.out.println("You inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("you cannot insert a quarter");
        } else if (state == SOLD) {
            System.out.println("Please wait");
        }
    }
}
