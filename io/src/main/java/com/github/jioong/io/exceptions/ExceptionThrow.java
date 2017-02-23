package com.github.jioong.io.exceptions;

/**
 * Created by jioong on 17-2-23.
 */
public class ExceptionThrow {

    public static void main(String[] args) {
        try {
            calledWithThrow();
        } catch (NullPointerException e) {
            System.out.println("happy to see you");
        }
        calledWithoutThrow();
    }

    public static void calledWithThrow() throws NullPointerException{
        throw new NullPointerException("With throw...");
    }

    public static void calledWithoutThrow() {
        throw new NullPointerException("Without throw...");
    }
}
