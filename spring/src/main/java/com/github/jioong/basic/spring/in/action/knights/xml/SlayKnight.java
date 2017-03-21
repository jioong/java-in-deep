package com.github.jioong.basic.spring.in.action.knights.xml;

import com.github.jioong.basic.spring.in.action.knights.Knight;
import com.github.jioong.basic.spring.in.action.knights.Quest;

/**
 * Created by jioong on 17-3-21.
 */
public class SlayKnight implements Knight {

    private Quest quest;

    public SlayKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQUest() {
        quest.embark();
    }
}
