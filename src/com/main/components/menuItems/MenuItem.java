package com.main.components.menuItems;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

abstract public class MenuItem extends JMenuItem implements ActionListener {
    private static int WIDTH = 600;
    private static int HEIGHT = 400;

//    abstract JFrame initFrame();
//    abstract JPanel initPanel();
    abstract void open();

    static JFrame createFrame(String title){
        JFrame frame = new JFrame();

        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    public static void openFileChooser(String title, String [] extensions){
        JFileChooser newGameFileChooser = new JFileChooser();
        newGameFileChooser.setAcceptAllFileFilterUsed(false);
        newGameFileChooser.setFileFilter(
                new FileNameExtensionFilter(".sav", extensions)
        );

        newGameFileChooser.setDialogTitle(title + " Game");
        newGameFileChooser.setApproveButtonText(title);
        int status = newGameFileChooser.showOpenDialog(null);

        if(status == JFileChooser.APPROVE_OPTION){
            File selectedFile = newGameFileChooser.getSelectedFile();
            System.out.print("saving file: ");
            System.out.println(selectedFile.getName());
        }else if(status == JFileChooser.CANCEL_OPTION){
            System.out.println("canceled");
        }
    }
//    static JPanel createPanel(){
//        JPanel panel = new JPanel();
//
//        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//        panel.setVisible(true);
//
//        return panel;
//    }


    @Override
    public void actionPerformed(ActionEvent e) {
        open();
    }
}
