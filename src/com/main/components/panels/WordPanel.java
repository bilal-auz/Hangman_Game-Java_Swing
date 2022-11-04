package com.main.components.panels;

import com.main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WordPanel extends Panel {
    static JLabel [] labels;

    //ArrayList of characters in the word
    static ArrayList<String> wordList;

    public WordPanel(String word, int wordLength){
        WordPanel.labels = new JLabel[wordLength];

        //convert the word String to Array, and then to ArrayList of characters.
        wordList = new ArrayList<>(Arrays.asList(word.toUpperCase().split("")));

        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new FlowLayout());

        init();
    }

    @Override
    void init(){
        //init the labels
        for (int i =0; i < labels.length; i++){
            labels[i] = new JLabel();
            labels[i].setPreferredSize(new Dimension(50,50));
            labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setBackground(Color.WHITE);
            labels[i].setFont(new Font("Serif",Font.PLAIN ,30));
            this.add(labels[i]);
        }
    }

    //checks if the passed(pressed) character is in the word(ArrayList)
    public static boolean checkLetter(char letter){
        if(wordList.contains(String.valueOf(letter))){
            int indexOfLetter = wordList.indexOf(String.valueOf(letter));

            //remove the chosen character from wordList by replace it with '-1'
            wordList.set(wordList.indexOf(String.valueOf(letter)), "-1");

            //set the character to its label
            labels[indexOfLetter].setText(String.valueOf(letter));

            //add new selected character and its index.
            GamePanel.getCurrentGame().getSelectedLetters().put(indexOfLetter,String.valueOf(letter));

            return true;
        }else{
            System.out.println("NO");
        }
        return false;
    }
}
