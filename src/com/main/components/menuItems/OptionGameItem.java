package com.main.components.menuItems;

import com.main.GamePanel;
import com.main.components.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

public class OptionGameItem extends MenuItem{

    private static final String TITLE = "Options";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static String[] extensions = {"db"};

    private static String selectedFilePath;

    HashMap<String, Color> colorMap;

    JFrame parentFrame, optionsFrame;
    JPanel parentPanel, optionsParentPanel;
    JTextField locationTextField;
    JComboBox<String> colorComboBox;
    Color selectedColor;

    public OptionGameItem(JFrame parentFrame, JPanel parentPanel){
        this.setText(TITLE);
        this.addActionListener(this);

        this.parentFrame = parentFrame;
        this.parentPanel = parentPanel;

        selectedFilePath = GamePanel.getCurrentGame().getWordListLocation();

        colorMap = new HashMap<>();

        colorMap.put("White", Color.WHITE);
        colorMap.put("Black", Color.BLACK);
        colorMap.put("Cyan", Color.CYAN);
        colorMap.put("Orange", Color.ORANGE);


        selectedColor = GamePanel.getCurrentGame().getBgColor();
//        System.out.println(colorMap.get(colorComboBox.getSelectedItem()));
    }
    @Override
    void open() {
        //parent components
        optionsFrame = createFrame("Game Options",WIDTH, HEIGHT);
        optionsParentPanel = createPanel();


        //sub panels
        JPanel databaseFilePanel = createPanel();
        databaseFilePanel.setLayout(new FlowLayout());
        databaseFilePanel.add(new JLabel("Word Database File: "));

        locationTextField = new JTextField(18);
        locationTextField.setText(selectedFilePath);

        databaseFilePanel.add(locationTextField);
        databaseFilePanel.add(changeButton());

        JPanel colorPanel = createPanel();
        colorPanel.setLayout(new FlowLayout());
        colorPanel.add(new JLabel("Background Color: "));
        colorComboBox = new JComboBox<>();

        for (String colorKey: colorMap.keySet()) {
//            colorComboBox.addItem(colorKey);
            colorComboBox.addItem(colorKey);
        }
        colorComboBox.setSelectedIndex(0);

        colorPanel.add(colorComboBox);

        JPanel confirmationPanel = createPanel();
        confirmationPanel.setLayout(new FlowLayout());
        confirmationPanel.add(okButton());
        confirmationPanel.add(applyButton());
        confirmationPanel.add(cancelButton());


        optionsParentPanel.add(databaseFilePanel);
        optionsParentPanel.add(colorPanel);
        optionsParentPanel.add(confirmationPanel);

        optionsFrame.add(optionsParentPanel);

        System.out.println("Opening Options");
    }

    JButton changeButton(){
        JButton changeButton = new JButton("Change");

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File selectedDatabase = openFileChooser("Choose Database", extensions);

                System.out.println("Old selectedFile: "+ GamePanel.getCurrentGame().getWordListLocation());

                selectedFilePath = selectedDatabase.getAbsolutePath();

                locationTextField.setText(selectedFilePath);
            }
        });

        return changeButton;
    }

    JButton applyButton(){
        JButton applyButton = new JButton("Apply");

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove from here and add new action to the combox
                //TEMP
                selectedColor = colorMap.get(colorComboBox.getSelectedItem());

                //encase the file path changed
                //init new Game with new filePath to the desired word list
                parentFrame.getContentPane().removeAll();
                Game newGame = new Game(selectedColor, selectedFilePath);
                parentFrame.add(new GamePanel(newGame));

                parentFrame.validate();
                parentFrame.repaint();
            }
        });

        return applyButton;
    }

    JButton okButton(){
        JButton okButton = new JButton("ok");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyButton().doClick();
                optionsFrame.dispose();
            }
        });

        return okButton;
    }

    JButton cancelButton(){
        JButton cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionsFrame.dispose();
            }
        });

        return cancelButton;
    }
}

