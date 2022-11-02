package com.main;

import com.main.components.Game;
import com.main.components.panels.AnswerPanel;
import com.main.components.panels.ChancesPanel;
import com.main.components.panels.LettersPanel;
import com.main.components.panels.WordPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {

    //panel WIDTH
    private static final int SCREEN_WIDTH = 720;
    //panel HEIGHT
    private static final int SCREEN_HEIGHT = 300;
    //panel Current Game
    private static Game currentGame;
    private static final String defaultWordsPath = "src/words.db"; //Default path to the Words (.db)

    //1st constructor for a new game
    public GamePanel(){
        //create new Game and pass it to the other constructor
        this(new Game(defaultWordsPath));
    }

    //2nd constructor for loading games
    public GamePanel(Game loadGame){
        System.out.println("GamePanel loading game");
        currentGame = loadGame;
        initGame();
        initPanel();

        System.out.println(currentGame.getWord());
    }

    public void initGame(){
        System.out.println("init game");
        String randomWord = getRandomWord(currentGame.getWordListLocation());//getting randomWord

        //check if the Game instance is a loaded Game and not a new game (new game word is NULL)
        //check if the random new word is initialized
        if(currentGame.getWord() == null && randomWord != null){
            // Calling getRandomWord method, and pass path to the words.db file of that game.
            currentGame.setWord(randomWord);
            //setting chances
            currentGame.setChances(currentGame.getWord().length()/2);
        }

        this.setBackground(currentGame.getBgColor());
    }

    public void initPanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBorder(new EmptyBorder(10, 10,10,10));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setFocusable(true);

        //Pass to WordPanel the data of the current Game object.
        this.add(new WordPanel(currentGame.getWord(), currentGame.getWord().length()));

        //other panels access the current game object directly through GamePanel.getCurrentGame()
        this.add(new LettersPanel());
        this.add(new AnswerPanel());
        this.add(new ChancesPanel());
    }

    private String getRandomWord(String path){
        String randWord = null;
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            int index = new Random().nextInt(lines.size());
            randWord = lines.get(index);

            //if the word is null, the file is empty, throw exception
            if(randWord == null){
                throw new Exception("The File is Empty");
            }

            return randWord;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error While Reading the Database File.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;//if didn't get the word, it returns null
    }

    public static Game getCurrentGame() {
        return currentGame;
    }
}
