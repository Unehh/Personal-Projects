package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorAction extends Action{
    private String action;
    CalculatorAction(String label, JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, String action) {
        super(label, frame, gridConstraint, gridX, gridY);
        this.action = action;
    }

    @Override
    void performAction() {
        System.out.println("Action: "+ action);
        switch (action){
            case "Add Number":
                System.out.println("number added");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }
}
