package com.github.jioong.basic.spring.in.action.CD.impl;

import com.github.jioong.basic.spring.in.action.CD.CompactDisc;
import com.github.jioong.basic.spring.in.action.CD.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jioong on 17-3-22.
 */
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {

    }
}
