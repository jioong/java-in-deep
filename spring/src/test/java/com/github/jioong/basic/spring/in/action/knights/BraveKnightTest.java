package com.github.jioong.basic.spring.in.action.knights;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by jioong on 17-3-21.
 */
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = Mockito.mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQUest();

        Mockito.verify(mockQuest, Mockito.times(1)).embark();
    }
}