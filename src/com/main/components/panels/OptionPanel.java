package com.main.components.panels;

import com.main.GamePanel;
import com.main.components.Game;
import com.main.components.menuItems.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;


public class OptionPanel extends Panel {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final String[] extensions = {"db"};
    private static String selectedFilePath;

    JFrame parentFrame, optionsFrame;
    JPanel optionsParentPanel;
    JTextField locationTextField;
    JComboBox<String> colorComboBox;
    HashMap<String, Color> colorMap;    //Key: Color name (Black). Value: awt.Color (Color.BLACK)
    Color selectedColor;

    public OptionPanel(JFrame parentFrame){
        this.parentFrame = parentFrame;
        selectedFilePath = GamePanel.getCurrentGame().getWordListLocation();

        colorMap = new HashMap<>();
        colorMap.put("White", Color.WHITE);
        colorMap.put("Black", Color.BLACK);
        colorMap.put("Cyan", Color.CYAN);
        colorMap.put("Orange", Color.ORANGE);

        selectedColor = GamePanel.getCurrentGame().getBgColor();

        init();
    }

    @Override
    void init() {
        //init parent components
        optionsFrame = createFrame("Game Options",WIDTH, HEIGHT);
        optionsParentPanel = createPanel();

        //init and add panels to the parent panel
        optionsParentPanel.add(initDatabaseFile());
        optionsParentPanel.add(initColorPanel());
        optionsParentPanel.add(initConfirmationPanel());

        //add the parent panel to the parent frame
        optionsFrame.add(optionsParentPanel);
    }

    private JPanel initDatabaseFile(){
        JPanel databaseFilePanel = createPanel();
        databaseFilePanel.setLayout(new FlowLayout());
        databaseFilePanel.add(new JLabel("Word Database File: "));

        locationTextField = new JTextField(18);
        locationTextField.setText(selectedFilePath);

        databaseFilePanel.add(locationTextField);
        databaseFilePanel.add(changeButton());

        return databaseFilePanel;
    }

    private JPanel initColorPanel(){
        JPanel colorPanel = createPanel();
        colorPanel.setLayout(new FlowLayout());
        colorPanel.add(new JLabel("Background Color: "));

        colorComboBox = new JComboBox<>();

        for (String colorKey: colorMap.keySet()) {
            colorComboBox.addItem(colorKey);
        }
        colorComboBox.setSelectedIndex(0);

        colorPanel.add(colorComboBox);

        return colorPanel;
    }

    private JPanel initConfirmationPanel(){
        JPanel confirmationPanel = createPanel();

        confirmationPanel.setLayout(new FlowLayout());
        confirmationPanel.add(okButton());
        confirmationPanel.add(applyButton());
        confirmationPanel.add(cancelButton());

        return confirmationPanel;
    }

    JButton changeButton(){
        JButton changeButton = new JButton("Change");

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File selectedDatabase = MenuItem.openFileChooser("Choose Database", extensions);

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
