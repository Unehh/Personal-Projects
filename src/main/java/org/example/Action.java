package org.example;

import javax.swing.*;
import java.awt.*;

abstract class Action {
    protected final JButton button;
    public Action(String label, JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY) {
        button = new JButton(label);
        button.addActionListener(e -> performAction());
        gridConstraint.gridx = gridX;
        gridConstraint.gridy = gridY;
        frame.add(button, gridConstraint);
    }

    abstract void performAction();
}
