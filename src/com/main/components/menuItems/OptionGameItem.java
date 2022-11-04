package com.main.components.menuItems;


import com.main.components.panels.OptionPanel;

import javax.swing.*;


public class OptionGameItem extends MenuItem{
    private static final String TITLE = "Options";
    JFrame parentFrame;

    public OptionGameItem(JFrame parentFrame){
        this.setText(TITLE);
        this.addActionListener(this);
        this.parentFrame = parentFrame;
    }

    //calling the OptionPanel
    @Override
    void implement() {
        new OptionPanel(parentFrame);
    }
}

