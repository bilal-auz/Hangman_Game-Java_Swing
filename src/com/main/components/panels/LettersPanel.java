package com.main.components.panels;

import com.main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LettersPanel extends Panel implements ActionListener{

    //Key: character in ASCII. Value its button
    //Key is an Integer, so we can easily loop through them and initialize them in loop(i = 65 and i++);
    HashMap<Integer, JButton> lettersBtn = new HashMap<>();

    public LettersPanel(){
        this.setPreferredSize(new Dimension(100, 100));
        init();
    }

    @Override
    void init(){
        for(int i = 0; i < 26; i++){
            //E.g. put(65, new JButton("A"))
            lettersBtn.put(65 + i,new JButton(String.valueOf((char) (65+i))));

            lettersBtn.get(65+i).addActionListener(this);

            this.add(lettersBtn.get(65+i));
        }

        //clicking each selected letter.
        for(String index: GamePanel.getCurrentGame().getSelectedLetters().values()){
            /*
            * Getting the btn using the characters.
            * E.g. A = 65, then we can get the btn of letter A by passing letter "A" and convert it to ASCII.
            */
            lettersBtn.get((int) index.charAt(0)).doClick();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        //Check if pressed letter exists in the word and user has chances
        //if wrong letter and have chance, then decrease one chance.
        if(GamePanel.getCurrentGame().getChances() > 0 && WordPanel.checkLetter(btn.getText().charAt(0))){
            btn.setEnabled(WordPanel.wordList.contains(String.valueOf(btn.getText().charAt(0))));
        }else if(GamePanel.getCurrentGame().getChances() > 0){
            GamePanel.getCurrentGame().setChances(GamePanel.getCurrentGame().getChances() - 1);
            ChancesPanel.updateChance();
        }
    }
}
