package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Action {
    JButton button;
    Action(String label, JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY){
        button= new JButton(label);
        button.addActionListener(e -> performAction());
        gridConstraint.gridx = gridX;
        gridConstraint.gridy = gridY;
        frame.add(button, gridConstraint);
    }
    abstract void performAction();
}
