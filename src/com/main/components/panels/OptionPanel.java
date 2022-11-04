package com.main.components.panels;

import com.main.GamePanel;
import com.main.components.Game;
import com.main.components.menuItems.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
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

    /*
        1- colorMap: used to get the String name value of the awt.Color object
        2- colorMapInverse: used to get the awt.Color object using the color String name
     */
    HashMap<Color, String> colorMap;    //Key: Color name (Black). Value: awt.Color (Color.BLACK)
    HashMap<String, Color> colorMapInverse;    //Key: awt.Color (Color.BLACK) . Value: Color name (Black)
    Color selectedColor;

    public OptionPanel(JFrame parentFrame){
        this.parentFrame = parentFrame;
        selectedFilePath = GamePanel.getCurrentGame().getWordListLocation();;

        colorMap = new HashMap<>();
        colorMap.put(Color.WHITE, "White");
        colorMap.put(Color.BLACK, "Black");
        colorMap.put(Color.CYAN, "Cyan");
        colorMap.put(Color.ORANGE, "Orange");

        colorMapInverse = new HashMap<>();
        for(Color colorKey: colorMap.keySet()){
            String colorValue = colorMap.get(colorKey);
            colorMapInverse.put(colorValue, colorKey);
        }

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

        for (String colorValue: colorMap.values()) {
            colorComboBox.addItem(colorValue);
        }

        colorComboBox.setSelectedItem(colorMap.get(GamePanel.getCurrentGame().getBgColor()));

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
                //accessing MenuItem static function is not a good implementation, but it solves the problem :)
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
                File newDatabaseFile;
                Game newGame;
                try{
                    selectedColor = colorMapInverse.get(colorComboBox.getSelectedItem());
                    //remove from here and add new action to the combox
                    if(!selectedFilePath.equals(GamePanel.getCurrentGame().getWordListLocation())){
                        newDatabaseFile = new File(locationTextField.getText());
                        //check if the selected database location is exists
                        //if exists, check if its empty.
                        if(!newDatabaseFile.exists() || newDatabaseFile.length() <= 0)
                            throw new Exception("The File doesn't exists/File empty");
                        selectedFilePath = locationTextField.getText();

                        newGame = new Game(selectedColor, selectedFilePath);
                    }else{
                        GamePanel.getCurrentGame().setBgColor(selectedColor);
                        newGame = GamePanel.getCurrentGame();
                    }

                    //encase the file path changed
                    //init new Game with new filePath to the desired word list
                    parentFrame.getContentPane().removeAll();
                    parentFrame.add(new GamePanel(newGame));
                }catch (Exception exception){
                    //reset the DB location textField to the original
                    JOptionPane.showMessageDialog(optionsParentPanel,"Can't Apply the new changes.\n"+exception.getMessage(),"Warning", JOptionPane.INFORMATION_MESSAGE);
                    locationTextField.setText(GamePanel.getCurrentGame().getWordListLocation());
                }finally {
                    //finally refresh the main game frame.
                    parentFrame.validate();
                    parentFrame.repaint();
                }
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
