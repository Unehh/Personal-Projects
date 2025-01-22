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
    JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPercent, buttonCE, buttonC, buttonBackSpace, button1x, buttonnumberMain, buttonSquareRoot, buttonDivide, buttonX, buttonMinus, buttonPlus, buttonSwitch, buttonEquals, buttonDot;

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
        buttonPercent = new JButton("%");
        buttonPercent.addActionListener(this);
        buttonCE = new JButton("CE");
        buttonCE.addActionListener(this);
        buttonC = new JButton("C");
        buttonC.addActionListener(this);
        buttonBackSpace = new JButton("backspace");
        buttonBackSpace.addActionListener(this);
        button1x = new JButton("1/x");
        button1x.addActionListener(this);
        buttonnumberMain = new JButton("Squared");
        buttonnumberMain.addActionListener(this);
        buttonSquareRoot = new JButton("Root");
        buttonSquareRoot.addActionListener(this);
        buttonDivide = new JButton("/");
        buttonDivide.addActionListener(this);
        button1 = new JButton("1");
        button1.addActionListener(this);
        button2 = new JButton("2");
        button2.addActionListener(this);
        button3 = new JButton("3");
        button3.addActionListener(this);
        buttonX = new JButton("x");
        buttonX.addActionListener(this);
        button4 = new JButton("4");
        button4.addActionListener(this);
        button5 = new JButton("5");
        button5.addActionListener(this);
        button6 = new JButton("6");
        button6.addActionListener(this);
        buttonMinus = new JButton("-");
        buttonMinus.addActionListener(this);
        button7 = new JButton("7");
        button7.addActionListener(this);
        button8 = new JButton("8");
        button8.addActionListener(this);
        button9 = new JButton("9");
        button9.addActionListener(this);
        buttonPlus = new JButton("+");
        buttonPlus.addActionListener(this);
        buttonSwitch = new JButton("+/-");
        buttonSwitch.addActionListener(this);
        button0 = new JButton("0");
        button0.addActionListener(this);
        buttonDot = new JButton(".");
        buttonDot.addActionListener(this);
        buttonEquals = new JButton("=");
        buttonEquals.addActionListener(this);
        gridConstraint.gridwidth = 1;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        frame.add(buttonPercent, gridConstraint);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        frame.add(buttonCE, gridConstraint);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        frame.add(buttonC, gridConstraint);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 1;
        frame.add(buttonBackSpace, gridConstraint);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        frame.add(button1x, gridConstraint);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        frame.add(buttonnumberMain, gridConstraint);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        frame.add(buttonSquareRoot, gridConstraint);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 2;
        frame.add(buttonDivide, gridConstraint);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        frame.add(button7, gridConstraint);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 3;
        frame.add(button8, gridConstraint);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 3;
        frame.add(button9, gridConstraint);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 3;
        frame.add(buttonX, gridConstraint);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 4;
        frame.add(button4, gridConstraint);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 4;
        frame.add(button5, gridConstraint);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 4;
        frame.add(button6, gridConstraint);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 4;
        frame.add(buttonMinus, gridConstraint);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 5;
        frame.add(button1, gridConstraint);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 5;
        frame.add(button2, gridConstraint);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 5;
        frame.add(button3, gridConstraint);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 5;
        frame.add(buttonPlus, gridConstraint);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 6;
        frame.add(buttonSwitch, gridConstraint);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 6;
        frame.add(button0, gridConstraint);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 6;
        frame.add(buttonDot, gridConstraint);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 6;
        frame.add(buttonEquals, gridConstraint);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) e.getSource()).getText());
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
        if (e.getSource() == buttonnumberMain) {
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