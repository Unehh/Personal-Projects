package org.example;

import javax.swing.*;

public class DisplayUI {
    private final JLabel displayLabel;

    public DisplayUI(JLabel displayLabel) {
        this.displayLabel = displayLabel;
    }

    public void updateDisplay(String savedInput, char operator, String currentInput) {
        StringBuilder displayText = new StringBuilder();

        if (!savedInput.isEmpty()) {
            displayText.append(savedInput);
        }
        if (operator != '\0') {
            displayText.append(" ").append(operator);
        }
        if (!currentInput.isEmpty()) {
            displayText.append(" ").append(currentInput);
        }

        displayLabel.setText(displayText.toString().isEmpty() ? "0" : displayText.toString());
    }

    public void resetDisplay() {
        displayLabel.setText("0");
    }
}
