package com.main.components.menuItems;



public class SaveGameItem extends MenuItem {

    private static String[] extensions = {"sav"};
    public SaveGameItem(String title){
        this.setText(title);
        this.addActionListener(this);
    }

    public void open(){
        openFileChooser("Save", extensions);
    }
}
