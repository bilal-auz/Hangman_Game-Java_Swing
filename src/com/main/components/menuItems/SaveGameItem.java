package com.main.components.menuItems;


import com.main.components.Game;

import javax.swing.*;
import java.io.File;


public class SaveGameItem extends MenuItem {
    JFrame parentFrame;
    private static final String[] extensions = {"sav"};

    public SaveGameItem(String title , JFrame parentFrame){
        this.parentFrame = parentFrame;
        this.setText(title);
        this.addActionListener(this);
    }

    //Save(serialize) the current game instance;
    public void implementation(){
        //get the desired location(where to save the game object)
        File selectedFile = openFileChooser("Save", extensions);

        //Serialization
        try{
            Game.serialize(selectedFile);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
