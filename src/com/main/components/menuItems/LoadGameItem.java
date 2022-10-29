package com.main.components.menuItems;



public class LoadGameItem extends MenuItem {

    private static String[] extensions = {"sav"};
    public LoadGameItem(String title){
        this.setText(title);
        this.addActionListener(this);
    }

    public void open(){
        openFileChooser("Load", extensions);


    }
}
