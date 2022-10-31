package com.main.components;

import com.main.components.menuItems.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;


public class GameMenuBar extends JMenuBar {
    JFrame parentFrame;
    JPanel parentPanel;
    public GameMenuBar(JFrame parentFrame, JPanel parentPanel){
        this.parentFrame = parentFrame;
        this.parentPanel = parentPanel;
        this.add(new FileMenu("File"));
        this.add(new OptionsMenu("Options"));

        this.setVisible(true);
    }


    private class FileMenu extends JMenu{
        String [] fileMenuItems = {"New Game", "Save Game", "Load Game", "Exit"};
        FileMenu(String menuTitle){
            this.setText(menuTitle);

//            for(String title: fileMenuItems){
//                this.add(new JMenuItem(title));
//            }

            this.add(new NewGameItem("New Game", parentFrame, parentPanel));
            this.add(new SaveGameItem("Save Game", parentFrame, parentPanel));
            this.add(new LoadGameItem("Load Game", parentFrame, parentPanel));
            this.add(new ExitGameItem("Exit Game"));
        }
    }

    private class OptionsMenu extends JMenu{
        String [] optionsMenuItems = {"Options"};
        OptionsMenu(String menuTitle){
            this.setText(menuTitle);

            for(String title: optionsMenuItems){
                this.add(new OptionGameItem(parentFrame, parentPanel));
            };
        }
    }
}






