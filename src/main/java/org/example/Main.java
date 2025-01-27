package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


class Calculator {
    JLabel displayLabel;
    JFrame frame;
    GridBagConstraints gridConstraint = new GridBagConstraints();
    public static String removeLast(String original) {
        return original.substring(0, original.length() - 1);
    }

    public static String trimmer(String trimmedNumber) {
        boolean isFloat = false;
        for (int i = 0; i < trimmedNumber.length(); i++) {
            if (trimmedNumber.charAt(i) == '.') {
                isFloat = true;
                break;
            }
        }
        if (isFloat) {
            while (trimmedNumber.charAt(trimmedNumber.length() - 1) == '0' || trimmedNumber.charAt(trimmedNumber.length() - 1) == '.') {
                if (trimmedNumber.charAt(trimmedNumber.length() - 1) == '.') {
                    trimmedNumber = removeLast(trimmedNumber);
                    break;
                }
                trimmedNumber = removeLast(trimmedNumber);
            }
        }
        return trimmedNumber;
    }
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridBagLayout());
        gridConstraint.fill = GridBagConstraints.BOTH;
        gridConstraint.insets = new Insets(5, 5, 5, 5);
        displayLabel = new JLabel();
        displayLabel.setFont(new Font("Serif", Font.BOLD, 50));
        displayLabel.setText("0");
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setVerticalAlignment(SwingConstants.CENTER);
        gridConstraint.weightx = 0.2;
        gridConstraint.weighty = 0.2;
        gridConstraint.gridwidth = 4;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        frame.add(displayLabel, gridConstraint);

        gridConstraint.gridwidth = 1;
        CalculatorState state = new CalculatorState();
        MathematicsOperations mathService = new MathematicsOperations();
        DisplayUI displayUI = new DisplayUI(displayLabel);

        ArrayList<Action> actions = new ArrayList<>();

        actions.add(new PercentAction(frame, gridConstraint, 0, 1, state, mathService, displayUI));
        actions.add(new ClearEntryAction(frame, gridConstraint, 1, 1, state, displayUI));
        actions.add(new ClearAction(frame, gridConstraint, 2, 1, state, displayUI));
        actions.add(new BackspaceAction(frame, gridConstraint, 3, 1, state, displayUI));

        actions.add(new DecimalAction(frame, gridConstraint, 0, 2, state, mathService, displayUI));
        actions.add(new SquareAction(frame, gridConstraint, 1, 2, state, mathService, displayUI));
        actions.add(new SquareRootAction(frame, gridConstraint, 2, 2, state, mathService, displayUI));
        actions.add(new OperationAction('/', frame, gridConstraint, 3, 2, state, displayUI));

        actions.add(new AddNumberAction("7", frame, gridConstraint, 0, 3, state, displayUI));
        actions.add(new AddNumberAction("8", frame, gridConstraint, 1, 3, state, displayUI));
        actions.add(new AddNumberAction("9", frame, gridConstraint, 2, 3, state, displayUI));
        actions.add(new OperationAction('x', frame, gridConstraint, 3, 3, state, displayUI));

        actions.add(new AddNumberAction("4", frame, gridConstraint, 0, 4, state, displayUI));
        actions.add(new AddNumberAction("5", frame, gridConstraint, 1, 4, state, displayUI));
        actions.add(new AddNumberAction("6", frame, gridConstraint, 2, 4, state, displayUI));
        actions.add(new OperationAction('-', frame, gridConstraint, 3, 4, state, displayUI));

        actions.add(new AddNumberAction("1", frame, gridConstraint, 0, 5, state, displayUI));
        actions.add(new AddNumberAction("2", frame, gridConstraint, 1, 5, state, displayUI));
        actions.add(new AddNumberAction("3", frame, gridConstraint, 2, 5, state, displayUI));
        actions.add(new OperationAction('+', frame, gridConstraint, 3, 5, state, displayUI));

        actions.add(new SwitchSignAction(frame, gridConstraint, 0, 6, state, displayUI));
        actions.add(new AddNumberAction("0", frame, gridConstraint, 1, 6, state, displayUI));
        actions.add(new DecimalPointAction(frame, gridConstraint, 2, 6, state, displayUI));
        actions.add(new EqualsAction(frame, gridConstraint, 3, 6, state, mathService, displayUI));
        frame.setVisible(true);

    }
}

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}