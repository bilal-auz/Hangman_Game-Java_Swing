package com.main.components;

import com.main.GamePanel;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Game implements Serializable {
    private String word;
    private int chances;
    private ArrayList chosenLetters = new ArrayList();
    private Color bgColor = Color.WHITE;
    private String wordListLocation = null;

    private HashMap<Integer, String> selectedLetters = new HashMap<>();

    public Game(Color bgColor, String wordListLocation){
        this.bgColor = bgColor;
        this.wordListLocation = wordListLocation;
    }

    //should only be one game(Object)
    public Game(String wordListLocation){
        this(Color.WHITE, wordListLocation);
    }



    public static void serialize(File selectedFile) throws Exception {
        FileOutputStream gameFile = new FileOutputStream(selectedFile);
        ObjectOutputStream objReader = new ObjectOutputStream(gameFile);

        Game currentGameObject = GamePanel.getCurrentGame();

//                current game object
        objReader.writeObject(currentGameObject);

        objReader.close();
    }

    public static Game deserialize(File selectedGameFile){
        try{
            FileInputStream gameFile = new FileInputStream(selectedGameFile);
            ObjectInputStream objLoaded = new ObjectInputStream(gameFile);

            Game currentGameObject = GamePanel.getCurrentGame();
            System.out.println("OLD WORD: "+ currentGameObject.getWord());
//            System.out.println("SAVED");
//                current game object

            return (Game) objLoaded.readObject();

//            System.out.println("NEW WORD: "+ loadedGame.getWord());

        }catch (Exception e){
            //add exception Popup Jpanel
            return null;
        }

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

    public HashMap<Integer, String> getSelectedLetters() {
        return selectedLetters;
    }

    public void setSelectedLetters(HashMap<Integer, String> selectedLetters) {
        this.selectedLetters = selectedLetters;
    }

//    public ArrayList<Integer> getSelectedLetters() {
//        return selectedLetters;
//    }
//
//    public void setSelectedLetters(ArrayList<Integer> selectedLetters) {
//        this.selectedLetters = selectedLetters;
//    }
}
