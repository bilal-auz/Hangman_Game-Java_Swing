package com.main.components.menuItems;


import com.main.GameFrame;
import com.main.GamePanel;
import com.main.components.Game;

import javax.swing.*;
import java.awt.*;

public class NewGameItem extends MenuItem {

    JFrame parentFrame;
    JPanel parentPanel;
    public NewGameItem(String title, JFrame parentFrame, JPanel parentPanel){
        this.parentFrame = parentFrame;
        this.parentPanel = parentPanel;
        this.setText(title);
        this.addActionListener(this);
    }

    public void open(){
        //Reset the Game object
        parentFrame.getContentPane().removeAll();

        parentFrame.add(new GamePanel());

        parentFrame.validate();
        parentFrame.repaint();
        System.out.println(parentFrame.getTitle());
    }
}
