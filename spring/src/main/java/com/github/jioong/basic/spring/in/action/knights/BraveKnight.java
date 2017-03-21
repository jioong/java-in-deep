package com.github.jioong.basic.spring.in.action.knights;

/**
 * Created by jioong on 17-3-21.
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQUest() {
        quest.embark();
    }
}
