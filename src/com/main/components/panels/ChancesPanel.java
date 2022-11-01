package com.main.components.panels;

import com.main.GamePanel;

import javax.swing.*;

public class ChancesPanel extends JPanel {
    static int chances;
    static JLabel chancesLabel;
    public ChancesPanel(){
        chances = GamePanel.getCurrentGame().getChances();
        initPanel();
    }

    private void initPanel(){
        chancesLabel = new JLabel("Remaining Chances: "+ chances);
        this.add(chancesLabel);
    }


    public static void updateChance(){
        chancesLabel.setText("Remaining Chances: " + GamePanel.getCurrentGame().getChances());
    }


}
