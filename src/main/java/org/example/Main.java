package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator implements ActionListener {
    String numberVariable = "0", numberMain = "", equals = "", temp1 = "", temp2 = "";
    JLabel label;
    boolean isMinus = false, isFloat = false;
    char character = 'e';
    GridBagConstraints gridConstraint = new GridBagConstraints();
    JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPercent, buttonCE, buttonC, buttonBackSpace, button1x, buttonSquared, buttonSquareRoot, buttonDivide, buttonX, buttonMinus, buttonPlus, buttonSwitch, buttonEquals, buttonDot;

    public static String removeLast(String original) {
        return original.substring(0, original.length() - 1);
    }

    public static String trimmer(String x) {
        boolean isFloat = false;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '.') {
                isFloat = true;
            }
        }
        if (isFloat) {
            while (x.charAt(x.length() - 1) == '0' || x.charAt(x.length() - 1) == '.') {
                if (x.charAt(x.length() - 1) == '.') {
                    x = removeLast(x);
                    break;
                }
                x = removeLast(x);
            }
        }
        return x;
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
        new CalculatorAction("%", frame, gridConstraint, 0, 1, "Percent");
        new CalculatorAction("CE", frame, gridConstraint, 1, 1, "Clear Entry");
        new CalculatorAction("C", frame, gridConstraint, 2, 1, "Clear");
        new CalculatorAction("⌫", frame, gridConstraint, 3, 1, "Backspace");
        new CalculatorAction("1/x", frame, gridConstraint, 0, 2, "Decimal Number");
        new CalculatorAction("x²", frame, gridConstraint, 1, 2, "squared");
        new CalculatorAction("√", frame, gridConstraint, 2, 2, "square root");
        new CalculatorAction("/", frame, gridConstraint, 3, 2, "divide");
        new CalculatorAction("7", frame, gridConstraint, 0, 3, "Add Number");
        new CalculatorAction("8", frame, gridConstraint, 1, 3, "Add Number");
        new CalculatorAction("9", frame, gridConstraint, 2, 3, "Add Number");
        new CalculatorAction("x", frame, gridConstraint, 3, 3, "Multiply");
        new CalculatorAction("4", frame, gridConstraint, 0, 4, "Add Number");
        new CalculatorAction("5", frame, gridConstraint, 1, 4, "Add Number");
        new CalculatorAction("6", frame, gridConstraint, 2, 4, "Add Number");
        new CalculatorAction("-", frame, gridConstraint, 3, 4, "Subtraction");
        new CalculatorAction("1", frame, gridConstraint, 0, 5, "Add Number");
        new CalculatorAction("2", frame, gridConstraint, 1, 5, "Add Number");
        new CalculatorAction("3", frame, gridConstraint, 2, 5, "Add Number");
        new CalculatorAction("+", frame, gridConstraint, 3, 5, "Add");
        new CalculatorAction("+/-", frame, gridConstraint, 0, 6, "Switch");
        new CalculatorAction("0", frame, gridConstraint, 1, 6, "Add Number");
        new CalculatorAction(".", frame, gridConstraint, 2, 6, "turn into decimal");
        new CalculatorAction("=", frame, gridConstraint, 3, 6, "equals");
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (numberVariable != "") {
            if (numberVariable.charAt(0) == '-') {
                isMinus = true;
            }
        }

        if (e.getSource() == button0) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "0";
            else {
                numberVariable = numberVariable + 0;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button1) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "1";
            else {
                numberVariable = numberVariable + 1;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button2) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "2";
            else {
                numberVariable = numberVariable + 2;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button3) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "3";
            else {
                numberVariable = numberVariable + 3;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button4) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "4";
            else {
                numberVariable = numberVariable + 4;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button5) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "5";
            else {
                numberVariable = numberVariable + 5;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button6) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "6";
            else {
                numberVariable = numberVariable + 6;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button7) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "7";
            else {
                numberVariable = numberVariable + 7;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button8) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "8";
            else {
                numberVariable = numberVariable + 8;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button9) {
            if (numberVariable == "" || numberVariable == "0") numberVariable = "9";
            else {
                numberVariable = numberVariable + 9;
            }
            if (equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if (e.getSource() == button1x) {
            if (numberVariable == "0") System.out.println("CANNOT DIVIDE BY 0");
            else {
                numberVariable = String.valueOf(1 / Double.valueOf(numberVariable));
            }
        }
        if (e.getSource() == buttonCE) {
            if (numberVariable == "") {
                numberMain = "";
                character = 'e';
                numberVariable = "0";
            } else {
                numberVariable = "0";
            }
        }
        if (e.getSource() == buttonC) {
            numberVariable = "0";
            numberMain = "";
            character = 'e';
        }
        if (e.getSource() == buttonSwitch) {
            if (numberVariable != "0" && !isMinus) {
                isMinus = true;
                numberVariable = "-" + numberVariable;
            } else if (isMinus) {
                numberVariable = numberVariable.replace("-", "");
                isMinus = false;
            }
        }
        if (e.getSource() == buttonBackSpace) {
            if (numberVariable != "0" && numberVariable.length() != 1) {
                numberVariable = removeLast(numberVariable);
                if (numberVariable.charAt(0) == '-' && numberVariable.length() == 1) {
                    numberVariable = "0";
                }
            } else numberVariable = "0";
        }
        if (e.getSource() == buttonSquared) {
            if (equals != "") {
                numberVariable = equals;
                numberMain = "";
            }
            numberVariable = String.valueOf(Double.valueOf(numberVariable) * Double.valueOf(numberVariable));
            numberVariable = trimmer(numberVariable);
        }
        if (e.getSource() == buttonSquareRoot) {
            if (equals != "") {
                numberVariable = equals;
                numberMain = "";
            }
            numberVariable = String.valueOf(Math.sqrt(Double.valueOf(numberVariable)));
            numberVariable = trimmer(numberVariable);
        }
        if (e.getSource() == buttonDot) {
            if (!isFloat) {
                numberVariable = numberVariable + ".";
            }
        }
        if (e.getSource() == buttonPercent) {
            if (numberMain == "") {
                numberVariable = "0";
            } else {
                numberVariable = String.valueOf(Double.valueOf(numberVariable) * 0.01);
            }
        }
        if (e.getSource() == buttonDivide) {
            if (numberVariable == "0" && numberMain != "") {
                System.out.println("CANNOT DIVIDE BY 0");

            } else if (equals != "") {
                numberMain = equals;
                character = '/';
                equals = "";
            } else if (numberMain == "") {
                numberMain = numberVariable;
                character = '/';
                numberVariable = "";
            } else if (numberVariable != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) / Double.valueOf(numberVariable));
                numberMain = trimmer(numberMain);
                numberVariable = "";
            }
        }
        if (e.getSource() == buttonX) {
            if (equals != "") {
                numberMain = equals;
                character = 'x';
                equals = "";
            } else if (numberMain == "") {
                numberMain = numberVariable;
                character = 'x';
                numberVariable = "";
            } else if (numberVariable != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) * Double.valueOf(numberVariable));
                numberMain = trimmer(numberMain);
                numberVariable = "";
            }
        }
        if (e.getSource() == buttonPlus) {
            if (equals != "") {
                numberMain = equals;
                character = '+';
                equals = "";
            } else if (numberMain == "") {
                numberMain = numberVariable;
                character = '+';
                numberVariable = "";
            } else if (numberVariable != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) + Double.valueOf(numberVariable));

                numberMain = trimmer(numberMain);

                numberVariable = "";
            }
        }
        if (e.getSource() == buttonMinus) {
            if (equals != "") {
                numberMain = equals;
                character = '-';
                equals = "";
            } else if (numberMain == "") {
                numberMain = numberVariable;
                character = '-';
                numberVariable = "";
            } else if (numberVariable != "") {
                numberMain = String.valueOf(Double.valueOf(numberMain) - Double.valueOf(numberVariable));
                numberMain = trimmer(numberMain);
                numberVariable = "";
            }
        }
        for (int i = 0; i < numberVariable.length(); i++) {
            if (numberVariable.charAt(i) == '.') {
                isFloat = true;
                break;

            } else {
                isFloat = false;
            }
        }
        if (e.getSource() != buttonEquals) {
            temp1 = "";
            temp2 = "";
            System.out.println(" ");
            System.out.print(numberMain);
            if (character != 'e') {
                System.out.print(" " + character + " ");
                label.setText(numberMain + " " + character + " " + numberVariable);
            } else {
                if (numberVariable == "") {
                    label.setText("0");
                } else label.setText(numberVariable);
            }
            System.out.print(numberVariable);

        } else {
            if (temp1 == "" && temp2 == "") {
                temp1 = numberMain;
                temp2 = numberVariable;
            }
            switch (character) {
                case '+':
                    equals = String.valueOf(Double.valueOf(temp1) + Double.valueOf(temp2));
                    break;
                case '-':
                    equals = String.valueOf(Double.valueOf(temp1) - Double.valueOf(temp2));
                    break;
                case 'x':
                    equals = String.valueOf(Double.valueOf(temp1) * Double.valueOf(temp2));
                    break;
                case '/':
                    equals = String.valueOf(Double.valueOf(temp1) / Double.valueOf(temp2));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + character);
            }
            equals = trimmer(equals);
            label.setText(temp1 + " " + character + " " + temp2 + " = " + equals);
            temp1 = equals;
            numberVariable = "0";
            numberMain = "";
        }

    }
}

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}