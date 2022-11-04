package com.main.components.menuItems;


import com.main.GamePanel;

import javax.swing.*;

public class NewGameItem extends MenuItem {
    JFrame parentFrame;

    public NewGameItem(String title, JFrame parentFrame){
        this.parentFrame = parentFrame;
        this.setText(title);
        this.addActionListener(this);
    }

    //Reset the Game object by initialize new Panel
    public void implement(){
        parentFrame.getContentPane().removeAll();

        parentFrame.add(new GamePanel());

        parentFrame.validate();
        parentFrame.repaint();
    }
}
