package org.example;

import javax.swing.*;
import java.awt.*;

import static org.example.Calculator.removeLast;

public class CalculatorAction extends Action{
    private static String displayedNumberVal = "", numberMain = "", equals = "", temp1 = "", temp2 = "";
    private String action;
    private String buttonVal;
    private JLabel label;
    CalculatorAction(String buttonVal, JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, String action, JLabel label) {
        super(buttonVal, frame, gridConstraint, gridX, gridY);
        this.action = action;
        this.buttonVal = buttonVal;
        this.label = label;
    }

    @Override
    void performAction() {
        switch (action){
            case "Add Number":
                if (displayedNumberVal.equals("0") || displayedNumberVal.isEmpty()) {
                    displayedNumberVal = buttonVal;
                } else {
                    displayedNumberVal += buttonVal;
                }
                break;
            case "Backspace":
                if (displayedNumberVal != "0" && displayedNumberVal.length() != 1) {
                    displayedNumberVal = removeLast(displayedNumberVal);
                    if (displayedNumberVal.charAt(0) == '-' && displayedNumberVal.length() == 1) {
                        displayedNumberVal = "0";
                    }
                } else displayedNumberVal = "0";
                break;
            case "Clear Entry":

                break;
                default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        label.setText(displayedNumberVal);
    }
}
