package com.github.jioong.basic.spring.in.action.knights.aop;

import java.io.PrintStream;

/**
 * Created by jioong on 17-3-21.
 */
public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest() {
        stream.println("Fa la la");
    }

    public void singAfterQuest() {
        stream.println("Tee hee hee ");
    }
}
