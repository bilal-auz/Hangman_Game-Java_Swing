package com.main.components.menuItems;

import com.main.components.Game;

import javax.swing.*;
import java.io.File;

public class ExitGameItem extends MenuItem{
    private static final String[] extensions = {"sav"};


    public ExitGameItem(String title){
        this.setText(title);
        this.addActionListener(this);
    }

    //ask if Sure to exit, and want to save.
    @Override
    void implementation() {
        int selectedOption = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Exit?",JOptionPane.YES_NO_OPTION);
        if(selectedOption == JOptionPane.YES_OPTION){
            int selectedSaveOption = JOptionPane.showConfirmDialog(null, "Do You Want To Save The Game?", "Save?",JOptionPane.YES_NO_OPTION);
            if(selectedSaveOption == JOptionPane.YES_OPTION){
                //saving the game
                File selectedFile = openFileChooser("Save", extensions);
                //Serialization
                try{
                    Game.serialize(selectedFile);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }else{
                System.exit(0);
            }
        }
    }
}
