package com.main.components.panels;

import com.main.GamePanel;

import javax.swing.*;

public class ChancesPanel extends Panel {
    static int chances;
    static JLabel chancesLabel;
    public ChancesPanel(){
        chances = GamePanel.getCurrentGame().getChances();
        init();
    }

    @Override
    void init(){
        chancesLabel = new JLabel("Remaining Chances: "+ chances);
        this.add(chancesLabel);
    }

    public static void updateChance(){
        chancesLabel.setText("Remaining Chances: " + GamePanel.getCurrentGame().getChances());
    }


}
