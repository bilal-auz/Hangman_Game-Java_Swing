package com.main.components.panels;

import com.main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WordPanel extends JPanel {
    static JLabel [] labels;
    static ArrayList<String> wordList;

    public WordPanel(String word, int wordLength){
        WordPanel.labels = new JLabel[wordLength];

        wordList = new ArrayList<>(Arrays.asList(word.toUpperCase().split("")));

        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new FlowLayout());

        for (int i =0; i < labels.length; i++){
            labels[i] = new JLabel();
            labels[i].setPreferredSize(new Dimension(20,20));
            labels[i].setBorder(BorderFactory.createLineBorder(Color.blue));
            this.add(labels[i]);
        }

    }

    public static boolean checkLetter(char letter){
        System.out.println(wordList);
        System.out.println(letter);

        if(wordList.contains(String.valueOf(letter))){
            int indexOfLetter = wordList.indexOf(String.valueOf(letter));


            System.out.println("getSelectedLetters: "+ GamePanel.getCurrentGame().getSelectedLetters());
            System.out.println("YES");


            wordList.set(wordList.indexOf(String.valueOf(letter)), "-1");

            WordPanel.labels[indexOfLetter].setText(String.valueOf(letter));

            GamePanel.getCurrentGame().getSelectedLetters().put(indexOfLetter,String.valueOf(letter));

            if(wordList.contains(String.valueOf(letter))){
                return false;
            }


            System.out.println(wordList);
            return true;
        }else{
            System.out.println("NO");
        }
        return false;
    }
}
