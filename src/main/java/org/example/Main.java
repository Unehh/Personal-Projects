package org.example;

import javax.swing.*;
import java.awt.*;


class Calculator {
    JLabel label, calcHistoryLabel;
    JFrame frame;
    JPanel history;
    GridBagConstraints gridConstraint = new GridBagConstraints();
    public static String removeLast(String original) {
        return original.substring(0, original.length() - 1);
    }

    public static String trimmer(String trimmedNumber) {
        boolean isFloat = false;
        for (int i = 0; i < trimmedNumber.length(); i++) {
            if (trimmedNumber.charAt(i) == '.') {
                isFloat = true;
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
        label = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 50));
        label.setText("0");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        gridConstraint.weightx = 0.2;
        gridConstraint.weighty = 0.2;
        gridConstraint.gridwidth = 4;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        frame.add(label, gridConstraint);
        history = new JPanel();

        history.setLayout(new BoxLayout (history,BoxLayout.Y_AXIS));
        history.setSize((int) (frame.getWidth() * 0.2),frame.getHeight());
        gridConstraint.gridheight = 7;
        gridConstraint.gridx = 4;
        gridConstraint.gridy = 0;
        frame.add(history,gridConstraint);
        gridConstraint.gridheight = 1;
        gridConstraint.gridwidth = 1;
        new CalculatorAction("%", frame, gridConstraint, 0, 1, "Percent", label, history);
        new CalculatorAction("CE", frame, gridConstraint, 1, 1, "Clear Entry", label, history);
        new CalculatorAction("C", frame, gridConstraint, 2, 1, "Clear", label, history);
        new CalculatorAction("⌫", frame, gridConstraint, 3, 1, "Backspace", label, history);
        new CalculatorAction("1/x", frame, gridConstraint, 0, 2, "Decimal Number", label, history);
        new CalculatorAction("x²", frame, gridConstraint, 1, 2, "Squared", label, history);
        new CalculatorAction("√", frame, gridConstraint, 2, 2, "Square Root", label, history);
        new CalculatorAction("/", frame, gridConstraint, 3, 2, "Divide", label, history);
        new CalculatorAction("7", frame, gridConstraint, 0, 3, "Add Number", label, history);
        new CalculatorAction("8", frame, gridConstraint, 1, 3, "Add Number", label, history);
        new CalculatorAction("9", frame, gridConstraint, 2, 3, "Add Number", label, history);
        new CalculatorAction("x", frame, gridConstraint, 3, 3, "Multiply", label, history);
        new CalculatorAction("4", frame, gridConstraint, 0, 4, "Add Number", label, history);
        new CalculatorAction("5", frame, gridConstraint, 1, 4, "Add Number", label, history);
        new CalculatorAction("6", frame, gridConstraint, 2, 4, "Add Number", label, history);
        new CalculatorAction("-", frame, gridConstraint, 3, 4, "Subtraction", label, history);
        new CalculatorAction("1", frame, gridConstraint, 0, 5, "Add Number", label, history);
        new CalculatorAction("2", frame, gridConstraint, 1, 5, "Add Number", label, history);
        new CalculatorAction("3", frame, gridConstraint, 2, 5, "Add Number", label, history);
        new CalculatorAction("+", frame, gridConstraint, 3, 5, "Add", label, history);
        new CalculatorAction("+/-", frame, gridConstraint, 0, 6, "Switch", label, history);
        new CalculatorAction("0", frame, gridConstraint, 1, 6, "Add Number", label, history);
        new CalculatorAction(".", frame, gridConstraint, 2, 6, "Turn into decimal", label, history);
        new CalculatorAction("=", frame, gridConstraint, 3, 6, "Equals", label, history);
        frame.setVisible(true);

    }
}

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}