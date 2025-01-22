package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract class Action {
    private JButton button;
    Action(String label, ActionListener actionListener, JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY){
        button= new JButton(label);
        button.addActionListener(actionListener);
        frame.add(button,gridConstraint);
        gridConstraint.gridx = gridX;
        gridConstraint.gridy = gridY;
        frame.add(button, gridConstraint);
    }
    abstract void performAction();
}
