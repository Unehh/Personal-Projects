package org.example;

import javax.swing.*;
import java.awt.*;

import static org.example.Calculator.removeLast;
import static org.example.Calculator.trimmer;

public class CalculatorAction extends Action{
    private static String numberVal = "", numberSaved = "", NumberAfterCalculations = "";
    static Character CalcCharacter = '\0'; //Character is Empty
    boolean isNegative = false, isFloat = false;
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
        if (numberVal != "") {
            if (numberVal.charAt(0) == '-') {
                isNegative = true;
            }
        }
        switch (action){
            case "Add Number":
                if(!NumberAfterCalculations.isEmpty()) {
                    numberSaved = "";
                    CalcCharacter = '\0';
                    numberVal = "";
                }
                if (numberVal.equals("0") || numberVal.isEmpty()) {
                    numberVal = buttonVal;
                } else {
                    numberVal += buttonVal;
                }
                break;
            case "Backspace":
                if (numberVal != "0" && numberVal.length() != 1) {
                    numberVal = removeLast(numberVal);
                    if (numberVal.charAt(0) == '-' && numberVal.length() == 1) {
                        numberVal = "0";
                    }
                } else numberVal = "0";
                break;
            case "Clear Entry":
                if (numberVal == "") {
                    numberSaved = "";
                    CalcCharacter = '\0';
                    numberVal = "0";
                } else {
                    numberVal = "0";
                }
                break;
            case "Clear":
                numberVal = "0";
                numberSaved = "";
                CalcCharacter = 'e';
                break;
            case "Decimal Number":
                if (numberVal == "0") {
                    System.out.println("CANNOT DIVIDE BY 0");
                    numberVal = "";
                    break;
                }
                else {
                    numberVal = String.valueOf(1 / Double.valueOf(numberVal));
                }
                break;
            case "Switch":
                if (numberVal != "0" && !isNegative) {
                    isNegative = true;
                    numberVal = "-" + numberVal;
                } else if (isNegative) {
                    numberVal = numberVal.replace("-", "");
                    isNegative = false;
                }
                break;
            case "Squared":
                if (!NumberAfterCalculations.isEmpty()) {
                    numberVal = NumberAfterCalculations;
                    numberSaved = "";
                }
                numberVal = String.valueOf(Double.valueOf(numberVal) * Double.valueOf(numberVal));
                numberVal = trimmer(numberVal);
                break;
            case "Square Root":
                if (!NumberAfterCalculations.isEmpty()) {
                    numberVal = NumberAfterCalculations;
                    numberSaved = "";
                }
                numberVal = String.valueOf(Math.sqrt(Double.valueOf(numberVal)));
                numberVal = trimmer(numberVal);
                break;
            case "Turn into decimal":
                if (!isFloat) {
                    numberVal = numberVal + ".";
                }
                break;
            case "Percent":
                if (numberSaved == "") {
                    numberVal = "0";
                } else {
                    numberVal = String.valueOf(Double.valueOf(numberVal) * 0.01);
                }
                break;
            case "Divide":
                CalcCharacter = '/';
                break;
            case "Multiply":
                CalcCharacter = 'x';
                break;
            case "Subtraction":
                CalcCharacter = '-';
                break;
            case "Add":
                CalcCharacter = '+';
                break;
                default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        for (int i = 0; i < numberVal.length(); i++) {
            if (numberVal.charAt(i) == '.') {
                isFloat = true;
                break;

            } else {
                isFloat = false;
            }
        }
        label.setText(numberSaved + CalcCharacter + numberVal);
        if(!NumberAfterCalculations.isEmpty()) {
            label.setText(numberSaved + CalcCharacter + numberVal + "=" + NumberAfterCalculations);
        }
    }
}
