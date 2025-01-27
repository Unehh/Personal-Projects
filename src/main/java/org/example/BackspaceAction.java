package org.example;

import javax.swing.*;
import java.awt.*;

import static org.example.Calculator.removeLast;

public class BackspaceAction extends Action {
    private final CalculatorState state;
    private final DisplayUI displayUI;

    public BackspaceAction(JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, DisplayUI displayUI) {
        super("⌫", frame, gridConstraint, gridX, gridY);
        this.state = state;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        String current = state.getCurrentNumber();
        state.setCurrentNumber(removeLast(current));
        displayUI.updateDisplay(state.getSavedNumber(), state.getCurrentOperator(), state.getCurrentNumber());
    }
}