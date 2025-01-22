package org.example;

import javax.swing.*;
import java.awt.*;

import static org.example.Calculator.removeLast;
import static org.example.Calculator.trimmer;

public class CalculatorAction extends Action{
    private static String numberVal = "", numberSaved = "", NumberAfterCalculations = "";
    static Character calcCharacter = '\0'; //Character is Empty
    boolean isNegative = false, isFloat = false;
    private String action;
    private String buttonVal;
    private JLabel label;
    private static String Calculate(String FirstNumber, String SecondNumber, Character calcCharacter) {
        String calculated = "0";
        switch (calcCharacter){
            case '+':
                calculated = String.valueOf(Double.valueOf(FirstNumber)+Double.valueOf(SecondNumber));
                break;
            case '-':
                calculated = String.valueOf(Double.valueOf(FirstNumber)-Double.valueOf(SecondNumber));
                break;
            case 'x':
                calculated = String.valueOf(Double.valueOf(FirstNumber)*Double.valueOf(SecondNumber));
                break;
            case '/':
                calculated = String.valueOf(Double.valueOf(FirstNumber)/Double.valueOf(SecondNumber));
                break;
        }
        calculated = trimmer(calculated);
        return calculated;
    }
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
                    calcCharacter = '\0';
                    numberVal = "";
                    NumberAfterCalculations = "";
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
                    calcCharacter = '\0';
                    numberVal = "0";
                } else {
                    numberVal = "0";
                }
                break;
            case "Clear":
                numberVal = "0";
                numberSaved = "";
                calcCharacter = '\0';
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
                    if(!NumberAfterCalculations.isEmpty()) {
                        numberSaved = "";
                        calcCharacter = '\0';
                        numberVal = "0";
                        NumberAfterCalculations = "";
                    }
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
                if(numberSaved.isEmpty()) {
                    numberSaved = numberVal;
                } else if (numberVal == "0") {
                    System.out.println("CANNOT DIVIDE BY 0");
                    break;
                } else{
                    numberSaved = Calculate(numberSaved, numberVal, calcCharacter);
                }
                calcCharacter = '/';
                numberVal = "";
                break;
            case "Multiply":
                if(numberSaved.isEmpty()) {
                    numberSaved = numberVal;
                } else{
                    numberSaved = Calculate(numberSaved, numberVal, calcCharacter);
                }
                calcCharacter = 'x';
                numberVal = "";
                break;
            case "Subtraction":
                if(numberSaved.isEmpty()) {
                    numberSaved = numberVal;
                } else{
                    numberSaved = Calculate(numberSaved, numberVal, calcCharacter);
                }
                calcCharacter = '-';
                numberVal = "";
                break;
            case "Add":
                if(numberSaved.isEmpty()) {
                    numberSaved = numberVal;
                } else{
                    numberSaved = Calculate(numberSaved, numberVal, calcCharacter);
                }
                calcCharacter = '+';
                numberVal = "";
                break;
            case "Equals":
                NumberAfterCalculations = Calculate(numberSaved, numberVal, calcCharacter);
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
        label.setText(numberSaved + calcCharacter + numberVal);
        if(!NumberAfterCalculations.isEmpty()) {
            label.setText(numberSaved + calcCharacter + numberVal + "=" + NumberAfterCalculations);
            numberSaved = NumberAfterCalculations;
        }
    }
}
