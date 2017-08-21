package com.jioong.github.command;

/**
 * Created by jioong on 17-8-18.
 */
public class RemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

    }
}
