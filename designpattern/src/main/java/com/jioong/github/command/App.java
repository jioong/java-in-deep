package com.jioong.github.command;

import com.jioong.github.command.model.Light;

/**
 * Created by jioong on 17-8-17.
 */
public class App {

    public static void main(String[] args) {
        SimpleRemoteControl control = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        control.setCommand(lightOnCommand);
        control.buttonWasPressed();
    }
}
