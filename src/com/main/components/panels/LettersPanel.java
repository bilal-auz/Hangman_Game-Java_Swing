package com.main.components.panels;

import com.main.GamePanel;

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


        //OPTIMIZE...
        //Check if pressed letter exists in the word and user has chances
        //if wrong letter and have chance decrease one.
        if(GamePanel.getCurrentGame().getChances() > 0 && WordPanel.checkLetter(btn.getText().charAt(0))){
            btn.setEnabled(WordPanel.wordList.contains(String.valueOf(btn.getText().charAt(0))));
        }else if(GamePanel.getCurrentGame().getChances() > 0){
            GamePanel.getCurrentGame().setChances(GamePanel.getCurrentGame().getChances() - 1);
            ChancesPanel.updateChance();
        }
    }
}
