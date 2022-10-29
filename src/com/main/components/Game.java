package com.main.components;

import java.awt.*;
import java.util.ArrayList;

public class Game {
    private String word;
    private int chances;
    private ArrayList chosenLetters = new ArrayList();
    private Color bgColor = Color.white;
    private String wordListLocation = null;

    public Game(String wordListLocation){
//        this.word = word;
//        chances = (word.length() / 2);

        this.wordListLocation = wordListLocation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getChances() {
        return chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    public ArrayList getChosenLetters() {
        return chosenLetters;
    }

    public void setChosenLetters(ArrayList chosenLetters) {
        this.chosenLetters = chosenLetters;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public String getWordListLocation() {
        return this.wordListLocation;
    }

    public void setWordListLocation(String wordListLocation) {
        this.wordListLocation = wordListLocation;
    }
}
