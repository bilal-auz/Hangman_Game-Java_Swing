package com.main.components.panels;

import javax.swing.*;
import java.awt.*;

public class LettersPanel extends JPanel {

    public LettersPanel(){
        this.setBackground(Color.cyan);
        this.add(new JLabel("Letters"));
        this.setPreferredSize(new Dimension(100, 100));


    }
}
