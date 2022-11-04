package com.main;

import javax.swing.*;

import com.main.components.GameMenuBar;

public class GameFrame extends JFrame {
    private static final String FRAME_TITLE = "Hangman";

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
}
