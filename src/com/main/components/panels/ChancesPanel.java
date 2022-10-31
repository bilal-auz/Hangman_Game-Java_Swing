package com.main.components.panels;

import javax.swing.*;
import java.awt.*;

public class ChancesPanel extends JPanel {
    public ChancesPanel(int chances){
//        this.setBackground(Color.green);
        this.add(new JLabel("Remaining Chances: "+ chances));


    }


}
