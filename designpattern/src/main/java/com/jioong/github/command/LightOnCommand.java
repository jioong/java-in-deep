package com.jioong.github.command;

import com.jioong.github.command.model.Light;

/**
 * Created by jioong on 17-8-17.
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
