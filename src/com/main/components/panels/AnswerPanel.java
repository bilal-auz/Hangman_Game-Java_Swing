package com.main.components.panels;

import javax.swing.*;
import java.awt.*;

public class AnswerPanel extends JPanel {
    public AnswerPanel(){
        this.setBackground(Color.blue);
        this.add(new JLabel("answers"));
        this.setPreferredSize(new Dimension(100, 50));


    }
}
