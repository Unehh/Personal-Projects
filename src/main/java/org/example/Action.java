package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract class Action {


    Action(String label, ActionListener actionListener, Frame frame){
        button= new JButton(label);
        button.addActionListener(actionListener);
        frame.add(button0,c);
        c.gridx =2;
        c.gridy =6;
    }

    private JButton button;

    abstract void performAction();
}
