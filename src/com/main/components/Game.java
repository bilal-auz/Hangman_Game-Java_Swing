package com.main.components;

import com.main.GamePanel;

import java.awt.*;
import java.io.*;
import java.util.HashMap;

public class Game implements Serializable {
    private String word;
    private int chances;
    private Color bgColor;
    private String wordListLocation = null;

    //Key: index of selected letter in the word, Value: the letter selected
    private HashMap<Integer, String> selectedLetters = new HashMap<>();

    public Game(String wordListLocation){
        this(Color.WHITE, wordListLocation);
    }

    public Game(Color bgColor, String wordListLocation){
        this.bgColor = bgColor;
        this.wordListLocation = wordListLocation;
    }

    //write object to a file path passed.
    public static void serialize(File selectedFile) throws Exception {
        FileOutputStream gameFile = new FileOutputStream(selectedFile);
        ObjectOutputStream objReader = new ObjectOutputStream(gameFile);

        Game currentGameObject = GamePanel.getCurrentGame();

        //current game object
        objReader.writeObject(currentGameObject);

        objReader.close();
    }

    //Read object from a file path passed.
    public static Game deserialize(File selectedGameFile) throws Exception{
//        try{
            FileInputStream gameFile = new FileInputStream(selectedGameFile);
            ObjectInputStream objLoaded = new ObjectInputStream(gameFile);
            return (Game) objLoaded.readObject();


//            System.out.println("NEW WORD: "+ loadedGame.getWord());

//        }catch (Exception e){
//            //add exception Popup Jpanel
//            return null;
//        }

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

    public void setChances(int chances) { this.chances = chances; }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) { this.bgColor = bgColor; }

    public String getWordListLocation() {
        return this.wordListLocation;
    }

    public void setWordListLocation(String wordListLocation) { this.wordListLocation = wordListLocation; }

    public HashMap<Integer, String> getSelectedLetters() { return selectedLetters; }

    public void setSelectedLetters(HashMap<Integer, String> selectedLetters) { this.selectedLetters = selectedLetters; }
}
