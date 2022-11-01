package com.main;

import javax.swing.*;

import com.main.components.GameMenuBar;

public class GameFrame extends JFrame {

    //Frame Title
    private static String FRAME_TITLE = "Hangman";
//    public Game currentGame;
//    private final String defaultWordsPath = "src/words.db";


    public GameFrame(){

        //init+add the panel to the frame
        JPanel parentPanel = new GamePanel();
        this.add(parentPanel);

        // set MenuBar
        this.setJMenuBar(new GameMenuBar(this,parentPanel));

        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }


//    public void initGame(Game newGame){
//        if(newGame != null){
//            currentGame = newGame;
//        }else{
//            currentGame = new Game(getRandomWord(), defaultWordsPath);
//        }
//        this.revalidate();
//        this.repaint();
//    }
//
//    private String getRandomWord(){
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(defaultWordsPath));
//            int index = new Random().nextInt(lines.size());
//            String randWord = lines.get(index);
//            return randWord;
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }


}
