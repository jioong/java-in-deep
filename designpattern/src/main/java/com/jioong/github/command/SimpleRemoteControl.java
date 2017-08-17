package com.jioong.github.command;

/**
 * Created by jioong on 17-8-17.
 */
public class SimpleRemoteControl {

    private Command slot;

    public SimpleRemoteControl() {}

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
