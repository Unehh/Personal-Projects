package org.example;

import javax.swing.*;
import java.awt.*;

public class PercentAction extends Action {
    private final CalculatorState state;
    private final MathematicsOperations mathService;
    private final DisplayUI displayUI;

    public PercentAction(JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, MathematicsOperations mathService, DisplayUI displayUI) {
        super("%", frame, gridConstraint, gridX, gridY);
        this.state = state;
        this.mathService = mathService;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        try {
            double value = Double.parseDouble(state.getCurrentNumber());
            state.setCurrentNumber(String.valueOf(mathService.percent(value)));
            displayUI.updateDisplay(state.getSavedNumber(), state.getCurrentOperator(), state.getCurrentNumber());
        } catch (Exception e) {
            displayUI.updateDisplay("Error", '\0', "");
        }
    }
}