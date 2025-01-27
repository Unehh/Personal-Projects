package org.example;

import javax.swing.*;
import java.awt.*;

public class SwitchSignAction extends Action {
    private final CalculatorState state;
    private final DisplayUI displayUI;

    public SwitchSignAction(JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, DisplayUI displayUI) {
        super("+/-", frame, gridConstraint, gridX, gridY);
        this.state = state;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        String current = state.getCurrentNumber();
        if (!current.equals("0")) {
            if (current.startsWith("-")) {
                state.setCurrentNumber(current.substring(1));
            } else {
                state.setCurrentNumber("-" + current);
            }
            displayUI.updateDisplay(state.getSavedNumber(), state.getCurrentOperator(), state.getCurrentNumber());
        }
    }
}