package org.example;

import javax.swing.*;
import java.awt.*;

public class ClearAction extends Action {
    private final CalculatorState state;
    private final DisplayUI displayUI;

    public ClearAction(JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, DisplayUI displayUI) {
        super("C", frame, gridConstraint, gridX, gridY);
        this.state = state;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        state.reset();
        displayUI.resetDisplay();
    }
}