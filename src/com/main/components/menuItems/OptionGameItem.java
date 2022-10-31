package com.main.components.menuItems;

import javax.swing.*;
import java.awt.*;

public class OptionGameItem extends MenuItem{

    private static final String TITLE = "Options";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;

    public OptionGameItem(){
        this.setText(TITLE);
        this.addActionListener(this);
    }
    @Override
    void open() {
        JFrame frame = createFrame("Game Options",WIDTH, HEIGHT);
        JPanel parentPanel = createPanel();

        JPanel databaseFilePanel = createPanel();
        databaseFilePanel.add(new Label("db"));

        JPanel colorPanel = createPanel();
        colorPanel.add(new Label("color"));

        JPanel confirmationPanel = createPanel();
        confirmationPanel.add(new Label("okay, apply, cancel"));

        parentPanel.add(databaseFilePanel);
        parentPanel.add(colorPanel);
        parentPanel.add(confirmationPanel);

        frame.add(parentPanel);
        System.out.println("Opening Options");
    }





}
