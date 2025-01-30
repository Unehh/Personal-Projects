package org.example;

import javax.swing.*;
import java.awt.*;

public class EqualsAction extends Action {
    private final CalculatorState state;
    private final MathematicsOperations mathService;
    private final DisplayUI displayUI;

    public EqualsAction(JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, CalculatorState state, MathematicsOperations mathService, DisplayUI displayUI) {
        super("=", frame, gridConstraint, gridX, gridY);
        this.state = state;
        this.mathService = mathService;
        this.displayUI = displayUI;
    }

    @Override
    public void performAction() {
        System.out.println(state.getLastOperator());
        System.out.println(state.getLastNumber());
        if (!state.getSavedNumber().isEmpty() && !state.getCurrentNumber().isEmpty() && state.getCurrentOperator() != '\0') {

                double result = mathService.calculate(
                        Double.parseDouble(state.getSavedNumber()),
                        Double.parseDouble(state.getCurrentNumber()),
                        state.getCurrentOperator()
                );
                state.setSavedNumber(String.valueOf(result));
                state.setLastNumber(state.getCurrentNumber());
                state.setLastOperator(state.getCurrentOperator());
                state.setCurrentNumber("");
                state.setCurrentOperator('\0');
        } else if (!state.getSavedNumber().isEmpty() && state.getLastOperator() != '\0' && !state.getLastNumber().isEmpty()) {
            double result = mathService.calculate(
                    Double.parseDouble(state.getSavedNumber()),
                    Double.parseDouble(state.getLastNumber()),
                    state.getLastOperator()
            );
            state.setSavedNumber(String.valueOf(result));
        }
        displayUI.updateDisplay(state.getSavedNumber(), '\0', "");
        state.setReset(true);
    }
}