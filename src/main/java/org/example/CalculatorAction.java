package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static org.example.Calculator.removeLast;
import static org.example.Calculator.trimmer;

public class CalculatorAction extends Action {
    private static final String ZERO = "0";
    private static String numberVal = "", numberSaved = "", result = "";
    private static String[][] calcHistoryArray = {{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},
                                            {"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},
                                            {"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},
                                            {"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""}};
    private static char calcOperator = '\0'; // Character is Empty
    private boolean isNegative = false, isFloat = false;
    private final String action;
    private final String buttonVal;
    private final JLabel label;
    private static JLabel calcHistoryLabel = new JLabel();
    private static JPanel history;


    public CalculatorAction(String buttonVal, JFrame frame, GridBagConstraints gridConstraint, int gridX, int gridY, String action, JLabel label, JPanel history) {
        super(buttonVal, frame, gridConstraint, gridX, gridY);
        this.action = action;
        this.buttonVal = buttonVal;
        this.label = label;
        this.history = history;
    }

    private static String calculate(String firstNumber, String secondNumber, char operator) {
        double first = Double.parseDouble(firstNumber);
        double second = Double.parseDouble(secondNumber);
        double result;

        switch (operator) {
            case '+': result = first + second; break;
            case '-': result = first - second; break;
            case 'x': result = first * second; break;
            case '/': result = second != 0 ? first / second : Double.NaN; break;
            default: throw new IllegalArgumentException("Unsupported operator: " + operator);
        }

        return trimmer(String.valueOf(result));
    }

    @Override
    void performAction() {
        if (!numberVal.isEmpty() && numberVal.charAt(0) == '-') {
            isNegative = true;
        }

        updateFloatFlag();
        switch (action) {
            case "Add Number": addNumber(); break;
            case "Backspace": backspace(); break;
            case "Clear Entry": clearEntry(); break;
            case "Clear": resetCalculator(); break;
            case "Decimal Number": addDecimal(); break;
            case "Switch": switcher(); break;
            case "Squared": squareNumber(); break;
            case "Square Root": squareRoot(); break;
            case "Turn into decimal": addDecimalPoint(); break;
            case "Percent": calculatePercent(); break;
            case "Divide": setOperator('/'); break;
            case "Multiply": setOperator('x'); break;
            case "Subtraction": setOperator('-'); break;
            case "Add": setOperator('+'); break;
            case "Equals": equals(); break;
            default: throw new IllegalStateException("Unexpected value: " + action);
        }
        history.add(calcHistoryLabel);
        updateLabel();
    }

    private void addNumber() {
        if (!result.isEmpty()) resetCalculator();
        numberVal = numberVal.equals(ZERO) ? buttonVal : numberVal + buttonVal;
    }
    private void backspace() {
        numberVal = numberVal.length() > 1 ? removeLast(numberVal) : ZERO;
        if (numberVal.equals("-")) numberVal = ZERO;
    }
    private void clearEntry() {
        numberVal = numberVal.isEmpty() ? ZERO : "";
    }
    private void addDecimal() {
        if (numberVal.equals(ZERO)) {
            System.out.println("CANNOT DIVIDE BY 0");
            numberVal = "";
        } else {
            numberVal = String.valueOf(1 / Double.parseDouble(numberVal));
        }
    }
    private void switcher() {
        if(!result.isEmpty()) {
            numberSaved = "";
            calcOperator = '\0';
            numberVal = result;
            result = "";
        }
        if (!numberVal.equals(ZERO)) {
            numberVal = isNegative ? numberVal.substring(1) : "-" + numberVal;
            isNegative = !isNegative;
        }
    }
    private void squareNumber() {
        if (!result.isEmpty()) resetCalculator();
        numberVal = trimmer(String.valueOf(Math.pow(Double.parseDouble(numberVal), 2)));
    }
    private void squareRoot() {
        if (!result.isEmpty()) resetCalculator();
        numberVal = trimmer(String.valueOf(Math.sqrt(Double.parseDouble(numberVal))));
    }
    private void addDecimalPoint() {
        if (!isFloat) numberVal += ".";
    }
    private void calculatePercent() {
        if (numberSaved.isEmpty()) {
            numberVal = ZERO;
        } else {
            numberVal = String.valueOf(Double.parseDouble(numberVal) * 0.01);
        }
    }
    private void setOperator(char operator) {
        if (numberSaved.isEmpty()) {
            numberSaved = numberVal;
        } else if(!numberVal.isEmpty()){
            numberSaved = calculate(numberSaved, numberVal, calcOperator);
        }
        calcOperator = operator;
        numberVal = "";
    }
    private void equals() {
        if(!numberVal.isEmpty() && !numberSaved.isEmpty()) {
            result = calculate(numberSaved, numberVal, calcOperator);
            calculatorHistorySave();
        } else if(!numberSaved.isEmpty() && calcOperator != '\0') {
            numberVal = numberSaved;
            result = calculate(numberSaved, numberVal, calcOperator);
            calculatorHistorySave();
        }
    }
    private void resetCalculator() {
        numberSaved = "";
        calcOperator = '\0';
        numberVal = ZERO;
        result = "";
    }
    private void updateFloatFlag() {
        isFloat = numberVal.contains(".");
    }
    private void updateLabel() {
        label.setText(result.isEmpty() ? numberSaved + calcOperator + numberVal : numberSaved + calcOperator + numberVal + "=" + result);
        if (!result.isEmpty()) numberSaved = result;
    }
    private void calculatorHistorySave() {
        for(int i = calcHistoryArray.length-1; i>0; i--) {
            calcHistoryArray[i][0] = calcHistoryArray[i-1][0];
            calcHistoryArray[i][1] = calcHistoryArray[i-1][1];
            calcHistoryArray[i][2] = calcHistoryArray[i-1][2];
            calcHistoryArray[i][3] = calcHistoryArray[i-1][3];
            if(!calcHistoryArray[i][0].isEmpty()) {
                calcHistoryLabel.setText(calcHistoryArray[i][0] + calcHistoryArray[i][1] + calcHistoryArray[i][2] + "=" + calcHistoryArray[i][3]);
            }
        }
        calcHistoryArray[0][0] = numberSaved;
        calcHistoryArray[0][1] = String.valueOf(calcOperator);
        calcHistoryArray[0][2] = numberVal;
        calcHistoryArray[0][3] = result;
    }
}