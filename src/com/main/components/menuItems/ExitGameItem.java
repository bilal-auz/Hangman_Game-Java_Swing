package com.main.components.menuItems;

import com.main.GameFrame;

import javax.swing.*;

public class ExitGameItem extends MenuItem{


    public ExitGameItem(String title){
        this.setText(title);
        this.addActionListener(this);

    }

    @Override
    void open() {
        System.out.println("CLosing");
        int selectedOption = JOptionPane.showConfirmDialog(null, "Sure?", "Warning",JOptionPane.YES_NO_OPTION);
        if(selectedOption == JOptionPane.YES_OPTION){
            int selectedSaveOption = JOptionPane.showConfirmDialog(null, "Save", "Warning",JOptionPane.YES_NO_OPTION);
            if(selectedSaveOption == JOptionPane.YES_OPTION){
                System.out.println("calling Saving JFileChooser");
            }
            System.exit(0);
        }
    }
}
