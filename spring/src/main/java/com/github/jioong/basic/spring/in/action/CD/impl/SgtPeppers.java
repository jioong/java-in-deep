package com.github.jioong.basic.spring.in.action.CD.impl;

import com.github.jioong.basic.spring.in.action.CD.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Created by jioong on 17-3-22.
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band.";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
