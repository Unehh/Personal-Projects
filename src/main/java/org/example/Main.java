package org.example;

import javax.swing.*;
import java.awt.*;


class Calculator {
    JLabel label;
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
        new CalculatorAction("x²", frame, gridConstraint, 1, 2, "Squared", label);
        new CalculatorAction("√", frame, gridConstraint, 2, 2, "Square Root", label);
        new CalculatorAction("/", frame, gridConstraint, 3, 2, "Divide", label);
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
        new CalculatorAction(".", frame, gridConstraint, 2, 6, "Turn into decimal", label);
        new CalculatorAction("=", frame, gridConstraint, 3, 6, "Equals", label);
        frame.setVisible(true);

    }

   /* @Override
    public void actionPerformed(ActionEvent e) {

        if (numberVal != "") {
            if (numberVal.charAt(0) == '-') {
                isMinus = true;
            }
        }

        if (e.getSource() == button0) {
            if (numberVal == "" || numberVal == "0") numberVal = "0";
            else {
                numberVal = numberVal + 0;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button1) {
            if (numberVal == "" || numberVal == "0") numberVal = "1";
            else {
                numberVal = numberVal + 1;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button2) {
            if (numberVal == "" || numberVal == "0") numberVal = "2";
            else {
                numberVal = numberVal + 2;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button3) {
            if (numberVal == "" || numberVal == "0") numberVal = "3";
            else {
                numberVal = numberVal + 3;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button4) {
            if (numberVal == "" || numberVal == "0") numberVal = "4";
            else {
                numberVal = numberVal + 4;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button5) {
            if (numberVal == "" || numberVal == "0") numberVal = "5";
            else {
                numberVal = numberVal + 5;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button6) {
            if (numberVal == "" || numberVal == "0") numberVal = "6";
            else {
                numberVal = numberVal + 6;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button7) {
            if (numberVal == "" || numberVal == "0") numberVal = "7";
            else {
                numberVal = numberVal + 7;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button8) {
            if (numberVal == "" || numberVal == "0") numberVal = "8";
            else {
                numberVal = numberVal + 8;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button9) {
            if (numberVal == "" || numberVal == "0") numberVal = "9";
            else {
                numberVal = numberVal + 9;
            }
            if (equals != "") {
                CalcCharacter = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button1x) {
            if (numberVal == "0") System.out.println("CANNOT DIVIDE BY 0");
            else {
                numberVal = String.valueOf(1 / Double.valueOf(numberVal));
            }
        }
        if (e.getSource() == buttonCE) {
            if (numberVal == "") {
                numberMain = "";
                CalcCharacter = 'e';
                numberVal = "0";
            } else {
                numberVal = "0";
            }
        }
        if (e.getSource() == buttonC) {
            numberVal = "0";
            numberMain = "";
            CalcCharacter = 'e';
        }
        if (e.getSource() == buttonSwitch) {
            if (numberVal != "0" && !isMinus) {
                isMinus = true;
                numberVal = "-" + numberVal;
            } else if (isMinus) {
                numberVal = numberVal.replace("-", "");
                isMinus = false;
            }
        }
        if (e.getSource() == buttonBackSpace) {
            if (numberVal != "0" && numberVal.length() != 1) {
                numberVal = removeLast(numberVal);
                if (numberVal.charAt(0) == '-' && numberVal.length() == 1) {
                    numberVal = "0";
                }
            } else numberVal = "0";
        }
        if (e.getSource() == buttonSquared) {
            if (equals != "") {
                numberVal = equals;
                numberMain = "";
            }
            numberVal = String.valueOf(Double.valueOf(numberVal) * Double.valueOf(numberVal));
            numberVal = trimmer(numberVal);
        }
        if (e.getSource() == buttonSquareRoot) {
            if (equals != "") {
                numberVal = equals;
                numberMain = "";
            }
            numberVal = String.valueOf(Math.sqrt(Double.valueOf(numberVal)));
            numberVal = trimmer(numberVal);
        }
        if (e.getSource() == buttonDot) {
            if (!isFloat) {
                numberVal = numberVal + ".";
            }
        }
        if (e.getSource() == buttonPercent) {
            if (numberMain == "") {
                numberVal = "0";
            } else {
                numberVal = String.valueOf(Double.valueOf(numberVal) * 0.01);
            }
        }
        if (e.getSource() == buttonDivide) {
            if (numberVal == "0" && numberMain != "") {
                System.out.println("CANNOT DIVIDE BY 0");

            } else if (equals != "") {
                numberMain = equals;
                CalcCharacter = '/';
                equals = "";
            } else if (numberMain == "") {
                numberMain = numberVal;
                CalcCharacter = '/';
                numberVal = "";
            } else if (numberVal != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) / Double.valueOf(numberVal));
                numberMain = trimmer(numberMain);
                numberVal = "";
            }
        }
        if (e.getSource() == buttonX) {
            if (equals != "") {
                numberMain = equals;
                CalcCharacter = 'x';
                equals = "";
            } else if (numberMain == "") {
                numberMain = numberVal;
                CalcCharacter = 'x';
                numberVal = "";
            } else if (numberVal != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) * Double.valueOf(numberVal));
                numberMain = trimmer(numberMain);
                numberVal = "";
            }
        }
        if (e.getSource() == buttonPlus) {
            if (equals != "") {
                numberMain = equals;
                CalcCharacter = '+';
                equals = "";
            } else if (numberMain == "") {
                numberMain = numberVal;
                CalcCharacter = '+';
                numberVal = "";
            } else if (numberVal != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) + Double.valueOf(numberVal));

                numberMain = trimmer(numberMain);

                numberVal = "";
            }
        }
        if (e.getSource() == buttonMinus) {
            if (equals != "") {
                numberMain = equals;
                CalcCharacter = '-';
                equals = "";
            } else if (numberMain == "") {
                numberMain = numberVal;
                CalcCharacter = '-';
                numberVal = "";
            } else if (numberVal != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) - Double.valueOf(numberVal));
                numberMain = trimmer(numberMain);
                numberVal = "";
            }
        }
        for (int i = 0; i < numberVal.length(); i++) {
            if (numberVal.charAt(i) == '.') {
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