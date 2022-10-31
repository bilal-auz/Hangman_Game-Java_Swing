package com.main.components.menuItems;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

abstract public class MenuItem extends JMenuItem implements ActionListener {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

//    abstract JFrame initFrame();
//    abstract JPanel initPanel();
    abstract void open();

    static JFrame createFrame(String title, int width, int height){
        JFrame frame = new JFrame();

        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    public static File openFileChooser(String title, String [] extensions){
        JFileChooser newGameFileChooser = new JFileChooser();
        String selectedFilePath;
        File selectedFile;

        newGameFileChooser.setAcceptAllFileFilterUsed(false);
        newGameFileChooser.setFileFilter(
                new FileNameExtensionFilter(".sav", extensions)
        );

        newGameFileChooser.setDialogTitle(title + " Game");
        newGameFileChooser.setApproveButtonText(title);

        int status = newGameFileChooser.showOpenDialog(null);

        if(status == JFileChooser.APPROVE_OPTION){
            selectedFilePath = newGameFileChooser.getSelectedFile().getAbsolutePath();

            if(!selectedFilePath.endsWith(".sav")){
                selectedFile = new File(selectedFilePath+"."+"sav");
            }else{
                selectedFile = new File(selectedFilePath);
            }

            System.out.print("saving file: " + selectedFile.getName());

            return selectedFile;
        }else if(status == JFileChooser.CANCEL_OPTION){
            System.out.println("canceled");
        }

        return null;
    }

    static JPanel createPanel(){
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setVisible(true);

        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        open();
    }

}
