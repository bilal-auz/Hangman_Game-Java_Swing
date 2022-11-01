package com.main.components.panels;

import com.main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerPanel extends Panel implements ActionListener {
    JTextField guessTextField;
    JButton guessBtn;

    public AnswerPanel(){
        init();
    }

    @Override
    void init(){
        guessTextField = new JTextField(25);
        guessTextField.setPreferredSize(new Dimension(0, 25));

        guessBtn = new JButton("Guess");
        guessBtn.setPreferredSize(new Dimension(350, 25));
        guessBtn.addActionListener(this);

        this.add(guessTextField);
        this.add(guessBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(guessTextField.getText().equalsIgnoreCase(GamePanel.getCurrentGame().getWord())){
            JOptionPane.showMessageDialog(this, "Congratulation");
        }else{
            JOptionPane.showMessageDialog(this, "Good luck next time");
        }

        //init new Game
        JFrame parentFrame = (JFrame) this.getRootPane().getParent();

        parentFrame.getContentPane().removeAll();

        parentFrame.getContentPane().add(new GamePanel());

        parentFrame.getContentPane().validate();
        parentFrame.getContentPane().repaint();
    }
}
