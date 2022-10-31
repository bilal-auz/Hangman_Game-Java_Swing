package com.main.components.menuItems;


import com.main.GamePanel;
import com.main.components.Game;

import javax.swing.*;
import java.io.*;

public class LoadGameItem extends MenuItem {

    JFrame parentFrame;
    JPanel parentPanel;

    private static String[] extensions = {"sav"};
    public LoadGameItem(String title,JFrame parentFrame, JPanel parentPanel){

        this.parentFrame = parentFrame;
        this.parentPanel = parentPanel;

        this.setText(title);
        this.addActionListener(this);
    }

    public void open(){
        File selectedGameFile = openFileChooser("Load", extensions);

        //Deserialization
        try{
            Game loadedGame = Game.deserialize(selectedGameFile);
//            FileInputStream gameFile = new FileInputStream(selectedGameFile);
//            ObjectInputStream objLoaded = new ObjectInputStream(gameFile);
//
//            Game currentGameObject = GamePanel.getCurrentGame();
//            System.out.println("OLD WORD: "+ currentGameObject.getWord());
////            System.out.println("SAVED");
////                current game object
//            Game loadedGame = (Game) objLoaded.readObject();
//
//            GamePanel.setCurrentGame(loadedGame);
//
//            System.out.println("NEW WORD: "+ loadedGame.getWord());
//
//            objLoaded.close();


            //Optimize this part
            parentFrame.getContentPane().removeAll();

            parentFrame.add(new GamePanel(loadedGame));

            parentFrame.validate();
            parentFrame.repaint();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());

        }


    }
}
