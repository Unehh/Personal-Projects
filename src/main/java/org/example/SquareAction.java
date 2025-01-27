package org.example;

import javax.swing.*;
import java.awt.*;

public class SquareAction extends Action {
    private final CalculatorState state;
    private final MathematicsOperations mathService;
    private final DisplayUI displayUI;

    public SquareAction(JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, MathematicsOperations mathService, DisplayUI displayUI) {
        super("x²", frame, gridConstraint, gridX, gridY);
        this.state = state;
        this.mathService = mathService;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        try {
            double value = Double.parseDouble(state.getCurrentNumber());
            state.setCurrentNumber(String.valueOf(mathService.square(value)));
            displayUI.updateDisplay(state.getSavedNumber(), state.getCurrentOperator(), state.getCurrentNumber());
            state.setReset(true);
        } catch (Exception e) {
            displayUI.updateDisplay("Error", '\0', "");
        }
    }
}