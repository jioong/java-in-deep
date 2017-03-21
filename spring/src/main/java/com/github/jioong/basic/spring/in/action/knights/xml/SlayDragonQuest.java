package com.github.jioong.basic.spring.in.action.knights.xml;

import com.github.jioong.basic.spring.in.action.knights.Quest;

import java.io.PrintStream;

/**
 * Created by jioong on 17-3-21.
 */
public class SlayDragonQuest implements Quest{

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        System.out.println("Embarking on quest to slay the dragon!");
    }
}
