package com.main.components.panels;

import com.main.GamePanel;
import com.main.components.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LettersPanel extends JPanel implements ActionListener{

    HashMap<Integer, JButton> lettersBtn = new HashMap<>();
    int i;
    public LettersPanel(){
        this.setPreferredSize(new Dimension(100, 100));
        initLetters();
    }

    private void initLetters(){
        for(int i = 0; i < 26; i++){
            lettersBtn.put(65 + i,new JButton(String.valueOf((char) (65+i))));

            lettersBtn.get(65+i).addActionListener(this);

            this.add(lettersBtn.get(65+i));
        }

        for(String index: GamePanel.getCurrentGame().getSelectedLetters().values()){


            lettersBtn.get((int) index.charAt(0)).doClick();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if(WordPanel.checkLetter(btn.getText().charAt(0))){
            btn.setEnabled(false);
        }
    }
}
