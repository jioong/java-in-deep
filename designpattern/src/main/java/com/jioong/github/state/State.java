package com.jioong.github.state;

/**
 * Created by jioong on 17-8-23.
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
