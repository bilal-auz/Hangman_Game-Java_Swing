package com.main.components.panels;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel {
    JLabel [] labels;
    public WordPanel(int wordLength){
        labels = new JLabel[wordLength];

        this.setPreferredSize(new Dimension(100, 100));
//        this.setBackground(Color.RED);
        this.setLayout(new FlowLayout());

        for (JLabel label:labels){
            label = new JLabel();
            label.setPreferredSize(new Dimension(20,20));
            label.setBorder(BorderFactory.createLineBorder(Color.blue));
            this.add(label);
        }
    }
}
