package com.main.components.menuItems;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

abstract public class MenuItem extends JMenuItem implements ActionListener {
    //method that implement each Item function
    abstract void implementation();

    //create frame method
//    static JFrame createFrame(String title, int width, int height){
//        JFrame frame = new JFrame();
//
//        frame.setTitle(title);
//        frame.setPreferredSize(new Dimension(width, height));
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        frame.pack();
//        frame.setResizable(false);
//        frame.setVisible(true);
//        frame.setLocationRelativeTo(null);
//
//        return frame;
//    }
//
//    //create panel method
//    static JPanel createPanel(){
//        JPanel panel = new JPanel();
//
//        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//        panel.setVisible(true);
//
//        return panel;
//    }

    //file chooser component to be used by menu items
    public static File openFileChooser(String title, String [] extensions){
        JFileChooser newGameFileChooser = new JFileChooser();
        String selectedFilePath;
        File selectedFile;

        //set filter for files (.sav)
        newGameFileChooser.setAcceptAllFileFilterUsed(false);
        newGameFileChooser.setFileFilter(
                new FileNameExtensionFilter("."+extensions[0], extensions)
        );

        newGameFileChooser.setDialogTitle(title + " Game");
        newGameFileChooser.setApproveButtonText(title);

        //get the chose button of newGameFileChooser
        int status = newGameFileChooser.showOpenDialog(null);

        if(status == JFileChooser.APPROVE_OPTION){
            selectedFilePath = newGameFileChooser.getSelectedFile().getAbsolutePath();

            //check extension of selected file
            if(!selectedFilePath.endsWith(extensions[0])){
                selectedFile = new File(selectedFilePath+"."+extensions[0]);
            }else{
                selectedFile = new File(selectedFilePath);
            }

            return selectedFile;
        }else if(status == JFileChooser.CANCEL_OPTION){
            System.out.println("canceled");
        }

        //return null encase canceled or file wasn't selected
        return null;
    }

    //each instance(Menu Item) has ActionListener that triggers the Menu Item implementation();
    @Override
    public void actionPerformed(ActionEvent e) {
        implementation();
    }

}
