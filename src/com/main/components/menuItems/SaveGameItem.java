package com.main.components.menuItems;


import com.main.components.Game;

import javax.swing.*;
import java.io.File;


public class SaveGameItem extends MenuItem {

    JFrame parentFrame;
    JPanel parentPanel;

    private static String[] extensions = {"sav"};
    public SaveGameItem(String title , JFrame parentFrame, JPanel parentPanel){
        this.parentFrame = parentFrame;
        this.parentPanel = parentPanel;

        this.setText(title);
        this.addActionListener(this);
    }

    public void open(){
        File selectedFile = openFileChooser("Save", extensions);

        //Serialization
        try{
            Game.serialize(selectedFile);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


//        try {
//            FileOutputStream gameFile = new FileOutputStream(selectedFile + "." + extensions[0]);
//            ObjectOutputStream objReader = new ObjectOutputStream(gameFile);
//
//            Game currentGameObject = GamePanel.getCurrentGame();
//
////                current game object
//                objReader.writeObject(currentGameObject);
//
//            objReader.close();
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
    }
}
