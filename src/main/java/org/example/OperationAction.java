package org.example;

import javax.swing.*;
import java.awt.*;

public class OperationAction extends Action {
    private final char operator;
    private final CalculatorState state;
    private final MathematicsOperations mathService;
    private final DisplayUI displayUI;

    public OperationAction(char operator, JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, DisplayUI displayUI) {
        super(String.valueOf(operator), frame, gridConstraint, gridX, gridY);
        this.operator = operator;
        this.state = state;
        this.mathService = new MathematicsOperations();
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        if (!state.getSavedNumber().isEmpty() && !state.getCurrentNumber().isEmpty()) {
            double result = mathService.calculate(
                    Double.parseDouble(state.getSavedNumber()),
                    Double.parseDouble(state.getCurrentNumber()),
                    state.getCurrentOperator()
            );
            state.setSavedNumber(String.valueOf(result));
            state.setCurrentNumber("");
        } else if (!state.getCurrentNumber().isEmpty()) {
            state.setSavedNumber(state.getCurrentNumber());
            state.setCurrentNumber("");
        }

        state.setLastOperator('\0');
        state.setLastNumber("");

        state.setCurrentOperator(operator);
        state.setReset(false);
        displayUI.updateDisplay(state.getSavedNumber(), state.getCurrentOperator(), state.getCurrentNumber());
    }
}