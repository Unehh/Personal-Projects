package org.example;

import javax.swing.*;
import java.awt.*;

public class DecimalPointAction extends Action {
    private final CalculatorState state;
    private final DisplayUI displayUI;

    public DecimalPointAction(JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, DisplayUI displayUI) {
        super(".", frame, gridConstraint, gridX, gridY);
        this.state = state;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        if (!state.getCurrentNumber().contains(".")) {
            state.setCurrentNumber(state.getCurrentNumber() + ".");
            displayUI.updateDisplay(state.getSavedNumber(), state.getCurrentOperator(), state.getCurrentNumber());
        }
    }
}