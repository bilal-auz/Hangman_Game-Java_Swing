package com.main.components.menuItems;


import com.main.GamePanel;
import com.main.components.Game;

import javax.swing.*;
import java.io.*;

public class LoadGameItem extends MenuItem {

    JFrame parentFrame;
    private static final String[] extensions = {"sav"};

    public LoadGameItem(String title,JFrame parentFrame){
        this.parentFrame = parentFrame;
        this.setText(title);
        this.addActionListener(this);
    }

    //load(deserialize) the Game Object previously saved.
    public void implement(){
        //get the location of saved Game Object
        File selectedGameFile = openFileChooser("Load", extensions);

        //Deserialization
        try{
            Game deserializedGame = Game.deserialize(selectedGameFile);

            parentFrame.getContentPane().removeAll();

            parentFrame.add(new GamePanel(deserializedGame));

            parentFrame.validate();
            parentFrame.repaint();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error While Reading the Game Save File", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
