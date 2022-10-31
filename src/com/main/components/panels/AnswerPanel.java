package com.main.components.panels;

import javax.swing.*;
import java.awt.*;

public class AnswerPanel extends JPanel {
    JTextField guessTextField;
    JButton guessBtn;

    public AnswerPanel(){
//        this.setBackground(Color.blue);
//        this.setPreferredSize(new Dimension(100, 50));

        guessTextField = new JTextField(25);
        guessTextField.setPreferredSize(new Dimension(0, 25));

        guessBtn = new JButton("Guess");
        guessBtn.setPreferredSize(new Dimension(350, 25));

        this.add(guessTextField);
        this.add(guessBtn);

    }
}
