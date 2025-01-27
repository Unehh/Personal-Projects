package org.example;

import javax.swing.*;
import java.awt.*;

public class AddNumberAction extends Action {
    private final String value;
    private final CalculatorState state;
    private final DisplayUI displayUI;

    public AddNumberAction(String value, JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, DisplayUI displayUI) {
        super(value, frame, gridConstraint, gridX, gridY);
        this.value = value;
        this.state = state;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        if (state.isReset()) {
            state.setCurrentNumber(value);
            state.setSavedNumber("");
            state.setReset(false);
        } else {
            String currentInput = state.getCurrentNumber().equals("0") ? "" : state.getCurrentNumber();
            state.setCurrentNumber(currentInput + value);
        }

        displayUI.updateDisplay(state.getSavedNumber(), state.getCurrentOperator(), state.getCurrentNumber());
    }
}
