package org.example;

import javax.swing.*;
import java.awt.*;

public class ClearEntryAction extends Action {
    private final CalculatorState state;
    private final DisplayUI displayUI;

    public ClearEntryAction(JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, DisplayUI displayUI) {
        super("CE", frame, gridConstraint, gridX, gridY);
        this.state = state;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        state.setCurrentNumber("");
        if (state.isReset()) {
            state.setSavedNumber("");
            state.setReset(false);
        }
        displayUI.updateDisplay(state.getSavedNumber(), state.getCurrentOperator(), state.getCurrentNumber());
    }
}
