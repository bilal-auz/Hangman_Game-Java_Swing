package com.main;

import com.main.components.Game;
import com.main.components.panels.AnswerPanel;
import com.main.components.panels.ChancesPanel;
import com.main.components.panels.LettersPanel;
import com.main.components.panels.WordPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {

    private static final int SCREEN_WIDTH = 720;
    private static final int SCREEN_HEIGHT = 300;
    private static Game currentGame;
    private static final String defaultWordsPath = "src/words.db";

    public GamePanel(){
        this(new Game(defaultWordsPath));
    }

    public GamePanel(Game loadGame){
        System.out.println("GamePAnel loading game");
        currentGame = loadGame;
        initGame();
        initPanel();
    }

    public void initGame(){

        System.out.println("init game");
        System.out.println(currentGame.getBgColor());

        //check if the new game is loaded not an actual new game
        if(currentGame.getWord() == null)
            currentGame.setWord(getRandomWord(currentGame.getWordListLocation()));

        System.out.println("LOADING chanced: "+currentGame.getChances());
        if(currentGame.getChances() <= 0)
            currentGame.setChances(currentGame.getWord().length()/2);

        this.setBackground(currentGame.getBgColor());

        this.revalidate();
        this.repaint();
    }

    public void initPanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBorder(new EmptyBorder(10, 10,10,10));
        this.setFocusable(true);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //pass to each panel the data from the current Game object
        this.add(new WordPanel(currentGame.getWord(), currentGame.getWord().length()));
        this.add(new LettersPanel());
        this.add(new AnswerPanel());
        this.add(new ChancesPanel());
    }

    private String getRandomWord(String path){
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            int index = new Random().nextInt(lines.size());
            String randWord = lines.get(index);
            return randWord;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game newCurrentGame){
        currentGame = newCurrentGame;
    }

    public void refreshPanel(){
        this.validate();
        this.repaint();

    }
}
