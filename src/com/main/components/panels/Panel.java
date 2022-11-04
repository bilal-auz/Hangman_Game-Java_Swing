package com.main.components.panels;

import javax.swing.*;
import java.awt.*;

abstract public class Panel extends JPanel {

    abstract void init();
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
    //create panel method
    static JPanel createPanel(){
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setVisible(true);

        return panel;
    }
}
