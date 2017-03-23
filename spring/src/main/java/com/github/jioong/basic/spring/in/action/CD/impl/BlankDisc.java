package com.github.jioong.basic.spring.in.action.CD.impl;

import com.github.jioong.basic.spring.in.action.CD.CompactDisc;

/**
 * Created by jioong on 17-3-23.
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;


    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
