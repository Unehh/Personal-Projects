package org.example;

import javax.swing.*;
import java.awt.*;


class Calculator {
    String numberMain = "", equals = "", temp1 = "", temp2 = "";
    JLabel label;
    boolean isMinus = false, isFloat = false;
    Character character = '\0';
    GridBagConstraints gridConstraint = new GridBagConstraints();
    JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPercent, buttonCE, buttonC, buttonBackSpace, button1x, buttonSquared, buttonSquareRoot, buttonDivide, buttonX, buttonMinus, buttonPlus, buttonSwitch, buttonEquals, buttonDot;

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

        JFrame frame = new JFrame("Calculator");
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
        gridConstraint.gridwidth = 1;
        new CalculatorAction("%", frame, gridConstraint, 0, 1, "Percent", label);
        new CalculatorAction("CE", frame, gridConstraint, 1, 1, "Clear Entry", label);
        new CalculatorAction("C", frame, gridConstraint, 2, 1, "Clear", label);
        new CalculatorAction("⌫", frame, gridConstraint, 3, 1, "Backspace", label);
        new CalculatorAction("1/x", frame, gridConstraint, 0, 2, "Decimal Number", label);
        new CalculatorAction("x²", frame, gridConstraint, 1, 2, "squared", label);
        new CalculatorAction("√", frame, gridConstraint, 2, 2, "square root", label);
        new CalculatorAction("/", frame, gridConstraint, 3, 2, "divide", label);
        new CalculatorAction("7", frame, gridConstraint, 0, 3, "Add Number", label);
        new CalculatorAction("8", frame, gridConstraint, 1, 3, "Add Number", label);
        new CalculatorAction("9", frame, gridConstraint, 2, 3, "Add Number", label);
        new CalculatorAction("x", frame, gridConstraint, 3, 3, "Multiply", label);
        new CalculatorAction("4", frame, gridConstraint, 0, 4, "Add Number", label);
        new CalculatorAction("5", frame, gridConstraint, 1, 4, "Add Number", label);
        new CalculatorAction("6", frame, gridConstraint, 2, 4, "Add Number", label);
        new CalculatorAction("-", frame, gridConstraint, 3, 4, "Subtraction", label);
        new CalculatorAction("1", frame, gridConstraint, 0, 5, "Add Number", label);
        new CalculatorAction("2", frame, gridConstraint, 1, 5, "Add Number", label);
        new CalculatorAction("3", frame, gridConstraint, 2, 5, "Add Number", label);
        new CalculatorAction("+", frame, gridConstraint, 3, 5, "Add", label);
        new CalculatorAction("+/-", frame, gridConstraint, 0, 6, "Switch", label);
        new CalculatorAction("0", frame, gridConstraint, 1, 6, "Add Number", label);
        new CalculatorAction(".", frame, gridConstraint, 2, 6, "turn into decimal", label);
        new CalculatorAction("=", frame, gridConstraint, 3, 6, "equals", label);
        frame.setVisible(true);

    }

   /* @Override
    public void actionPerformed(ActionEvent e) {

        if (displayedNumberVal != "") {
            if (displayedNumberVal.charAt(0) == '-') {
                isMinus = true;
            }
        }

        if (e.getSource() == button0) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "0";
            else {
                displayedNumberVal = displayedNumberVal + 0;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button1) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "1";
            else {
                displayedNumberVal = displayedNumberVal + 1;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button2) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "2";
            else {
                displayedNumberVal = displayedNumberVal + 2;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button3) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "3";
            else {
                displayedNumberVal = displayedNumberVal + 3;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button4) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "4";
            else {
                displayedNumberVal = displayedNumberVal + 4;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button5) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "5";
            else {
                displayedNumberVal = displayedNumberVal + 5;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button6) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "6";
            else {
                displayedNumberVal = displayedNumberVal + 6;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button7) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "7";
            else {
                displayedNumberVal = displayedNumberVal + 7;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button8) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "8";
            else {
                displayedNumberVal = displayedNumberVal + 8;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button9) {
            if (displayedNumberVal == "" || displayedNumberVal == "0") displayedNumberVal = "9";
            else {
                displayedNumberVal = displayedNumberVal + 9;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button1x) {
            if (displayedNumberVal == "0") System.out.println("CANNOT DIVIDE BY 0");
            else {
                displayedNumberVal = String.valueOf(1 / Double.valueOf(displayedNumberVal));
            }
        }
        if (e.getSource() == buttonCE) {
            if (displayedNumberVal == "") {
                numberMain = "";
                character = 'e';
                displayedNumberVal = "0";
            } else {
                displayedNumberVal = "0";
            }
        }
        if (e.getSource() == buttonC) {
            displayedNumberVal = "0";
            numberMain = "";
            character = 'e';
        }
        if (e.getSource() == buttonSwitch) {
            if (displayedNumberVal != "0" && !isMinus) {
                isMinus = true;
                displayedNumberVal = "-" + displayedNumberVal;
            } else if (isMinus) {
                displayedNumberVal = displayedNumberVal.replace("-", "");
                isMinus = false;
            }
        }
        if (e.getSource() == buttonBackSpace) {
            if (displayedNumberVal != "0" && displayedNumberVal.length() != 1) {
                displayedNumberVal = removeLast(displayedNumberVal);
                if (displayedNumberVal.charAt(0) == '-' && displayedNumberVal.length() == 1) {
                    displayedNumberVal = "0";
                }
            } else displayedNumberVal = "0";
        }
        if (e.getSource() == buttonSquared) {
            if (equals != "") {
                displayedNumberVal = equals;
                numberMain = "";
            }
            displayedNumberVal = String.valueOf(Double.valueOf(displayedNumberVal) * Double.valueOf(displayedNumberVal));
            displayedNumberVal = trimmer(displayedNumberVal);
        }
        if (e.getSource() == buttonSquareRoot) {
            if (equals != "") {
                displayedNumberVal = equals;
                numberMain = "";
            }
            displayedNumberVal = String.valueOf(Math.sqrt(Double.valueOf(displayedNumberVal)));
            displayedNumberVal = trimmer(displayedNumberVal);
        }
        if (e.getSource() == buttonDot) {
            if (!isFloat) {
                displayedNumberVal = displayedNumberVal + ".";
            }
        }
        if (e.getSource() == buttonPercent) {
            if (numberMain == "") {
                displayedNumberVal = "0";
            } else {
                displayedNumberVal = String.valueOf(Double.valueOf(displayedNumberVal) * 0.01);
            }
        }
        if (e.getSource() == buttonDivide) {
            if (displayedNumberVal == "0" && numberMain != "") {
                System.out.println("CANNOT DIVIDE BY 0");

            } else if (equals != "") {
                numberMain = equals;
                character = '/';
                equals = "";
            } else if (numberMain == "") {
                numberMain = displayedNumberVal;
                character = '/';
                displayedNumberVal = "";
            } else if (displayedNumberVal != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) / Double.valueOf(displayedNumberVal));
                numberMain = trimmer(numberMain);
                displayedNumberVal = "";
            }
        }
        if (e.getSource() == buttonX) {
            if (equals != "") {
                numberMain = equals;
                character = 'x';
                equals = "";
            } else if (numberMain == "") {
                numberMain = displayedNumberVal;
                character = 'x';
                displayedNumberVal = "";
            } else if (displayedNumberVal != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) * Double.valueOf(displayedNumberVal));
                numberMain = trimmer(numberMain);
                displayedNumberVal = "";
            }
        }
        if (e.getSource() == buttonPlus) {
            if (equals != "") {
                numberMain = equals;
                character = '+';
                equals = "";
            } else if (numberMain == "") {
                numberMain = displayedNumberVal;
                character = '+';
                displayedNumberVal = "";
            } else if (displayedNumberVal != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) + Double.valueOf(displayedNumberVal));

                numberMain = trimmer(numberMain);

                displayedNumberVal = "";
            }
        }
        if (e.getSource() == buttonMinus) {
            if (equals != "") {
                numberMain = equals;
                character = '-';
                equals = "";
            } else if (numberMain == "") {
                numberMain = displayedNumberVal;
                character = '-';
                displayedNumberVal = "";
            } else if (displayedNumberVal != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) - Double.valueOf(displayedNumberVal));
                numberMain = trimmer(numberMain);
                displayedNumberVal = "";
            }
        }
        for (int i = 0; i < displayedNumberVal.length(); i++) {
            if (displayedNumberVal.charAt(i) == '.') {
                isFloat = true;
                break;

            } else {
                isFloat = false;
            }
        }

    }*/
}

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}