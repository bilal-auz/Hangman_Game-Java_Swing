package com.main.components;

import com.main.components.menuItems.*;

import javax.swing.*;

public class GameMenuBar extends JMenuBar {

    //instances for the parent panel and frame;
    JFrame parentFrame;
    JPanel parentPanel;
    public GameMenuBar(JFrame parentFrame, JPanel parentPanel){
        this.parentFrame = parentFrame;
        this.parentPanel = parentPanel;

        this.add(new FileMenu("File"));
        this.add(new OptionsMenu("Options"));

        this.setVisible(true);
    }

    //Inner class for File Menu Bar
    private class FileMenu extends JMenu{
        FileMenu(String menuTitle){
            this.setText(menuTitle);

            //add Menu Items
            this.add(new NewGameItem("New Game", parentFrame));
            this.add(new SaveGameItem("Save Game", parentFrame));
            this.add(new LoadGameItem("Load Game", parentFrame));
            this.add(new ExitGameItem("Exit Game"));
        }
    }

    //Inner class for Options Menu Bar
    private class OptionsMenu extends JMenu{
        OptionsMenu(String menuTitle){
            this.setText(menuTitle);

            //add Menu Items
            this.add(new OptionGameItem(parentFrame));
        }
    }
}






