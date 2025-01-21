package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.FALSE;
import static java.sql.Types.NULL;

class Calculator implements ActionListener {
    String x1 = "0", x2 = "", equals ="", temp1="", temp2="";
    JLabel label;
    boolean isMinus = false, isFloat = false;
    char character = 'e';
    GridBagConstraints c = new GridBagConstraints();
    JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPercent, buttonCE, buttonC, buttonBackSpace,button1x, buttonX2, buttonSquareRoot, buttonDivide, buttonX, buttonMinus, buttonPlus, buttonSwitch, buttonEquals, buttonDot;
    public static String removeLast(String original) {
        return original.substring(0,original.length()-1);
    }
    public static String trimmer(String x) {
        boolean isFloat = false;
        for(int i =0; i < x.length(); i++) {
            if(x.charAt(i) == '.') {
                isFloat = true;
            }
        }
        if(isFloat) {
            while(x.charAt(x.length()-1) == '0' || x.charAt(x.length()-1) == '.') {
                if(x.charAt(x.length()-1) == '.') {
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
        buttonPercent= new JButton("%");
        buttonPercent.addActionListener(this);
        buttonCE= new JButton("CE");
        buttonCE.addActionListener(this);
        buttonC= new JButton("C");
        buttonC.addActionListener(this);
        buttonBackSpace= new JButton("backspace");
        buttonBackSpace.addActionListener(this);
        button1x= new JButton("1/x");
        button1x.addActionListener(this);
        buttonX2= new JButton("Squared");
        buttonX2.addActionListener(this);
        buttonSquareRoot= new JButton("Root");
        buttonSquareRoot.addActionListener(this);
        buttonDivide= new JButton("/");
        buttonDivide.addActionListener(this);
        button1= new JButton("1");
        button1.addActionListener(this);
        button2= new JButton("2");
        button2.addActionListener(this);
        button3= new JButton("3");
        button3.addActionListener(this);
        buttonX= new JButton("x");
        buttonX.addActionListener(this);
        button4= new JButton("4");
        button4.addActionListener(this);
        button5= new JButton("5");
        button5.addActionListener(this);
        button6= new JButton("6");
        button6.addActionListener(this);
        buttonMinus= new JButton("-");
        buttonMinus.addActionListener(this);
        button7= new JButton("7");
        button7.addActionListener(this);
        button8= new JButton("8");
        button8.addActionListener(this);
        button9= new JButton("9");
        button9.addActionListener(this);
        buttonPlus= new JButton("+");
        buttonPlus.addActionListener(this);
        buttonSwitch= new JButton("+/-");
        buttonSwitch.addActionListener(this);
        button0= new JButton("0");
        button0.addActionListener(this);
        buttonDot= new JButton(".");
        buttonDot.addActionListener(this);
        buttonEquals= new JButton("=");
        buttonEquals.addActionListener(this);
        frame.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
        label = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 50));
        label.setText("0");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.gridwidth = 4;
        c.gridx =0;
        c.gridy = 0;
        frame.add(label,c);
        c.gridwidth = 1;
        c.gridx =0;
        c.gridy =1;
        frame.add(buttonPercent,c);
        c.gridx =1;
        c.gridy =1;
        frame.add(buttonCE,c);
        c.gridx =2;
        c.gridy =1;
        frame.add(buttonC,c);
        c.gridx =3;
        c.gridy =1;
        frame.add(buttonBackSpace,c);
        c.gridx =0;
        c.gridy =2;
        frame.add(button1x,c);
        c.gridx =1;
        c.gridy =2;
        frame.add(buttonX2,c);
        c.gridx =2;
        c.gridy =2;
        frame.add(buttonSquareRoot,c);
        c.gridx =3;
        c.gridy =2;
        frame.add(buttonDivide,c);
        c.gridx =0;
        c.gridy =3;
        frame.add(button7,c);
        c.gridx =1;
        c.gridy =3;
        frame.add(button8,c);
        c.gridx =2;
        c.gridy =3;
        frame.add(button9,c);
        c.gridx =3;
        c.gridy =3;
        frame.add(buttonX,c);
        c.gridx =0;
        c.gridy =4;
        frame.add(button4,c);
        c.gridx =1;
        c.gridy =4;
        frame.add(button5,c);
        c.gridx =2;
        c.gridy =4;
        frame.add(button6,c);
        c.gridx =3;
        c.gridy =4;
        frame.add(buttonMinus,c);
        c.gridx =0;
        c.gridy =5;
        frame.add(button1,c);
        c.gridx =1;
        c.gridy =5;
        frame.add(button2,c);
        c.gridx =2;
        c.gridy =5;
        frame.add(button3,c);
        c.gridx =3;
        c.gridy =5;
        frame.add(buttonPlus,c);
        c.gridx =0;
        c.gridy =6;
        frame.add(buttonSwitch,c);
        c.gridx =1;
        c.gridy =6;
        frame.add(button0,c);
        c.gridx =2;
        c.gridy =6;
        frame.add(buttonDot,c);
        c.gridx =3;
        c.gridy =6;
        frame.add(buttonEquals,c);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x1 != "") {
            if(x1.charAt(0) == '-') {
                isMinus = true;
            }
        }

        if(e.getSource() == button0) {
            if(x1=="" || x1 == "0") x1="0";
            else {
                x1 = x1+0;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button1) {
            if(x1=="" || x1 =="0") x1="1";
            else {
                x1 = x1+1;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button2) {
            if(x1=="" || x1 =="0") x1="2";
            else {
                x1 = x1+2;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button3) {
            if(x1=="" || x1 =="0") x1="3";
            else {
                x1 = x1+3;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button4) {
            if(x1=="" || x1 =="0") x1="4";
            else {
                x1 = x1+4;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button5) {
            if(x1=="" || x1 =="0") x1="5";
            else {
                x1 = x1+5;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button6) {
            if(x1=="" || x1 =="0") x1="6";
            else {
                x1 = x1+6;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button7) {
            if(x1=="" || x1 =="0") x1="7";
            else {
                x1 = x1+7;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button8) {
            if(x1=="" || x1 =="0") x1="8";
            else {
                x1 = x1+8;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button9) {
            if(x1=="" || x1 =="0") x1="9";
            else {
                x1 = x1+9;
            }
            if(equals != "") {
                character = 'e';
                equals = "";
            }
        }
        if(e.getSource() == button1x) {
            if(x1 == "0") System.out.println("CANNOT DIVIDE BY 0");
            else {
                x1 = String.valueOf(1 / Double.valueOf(x1));
            }
        }
        if(e.getSource() == buttonCE) {
            if(x1 == "") {
                x2 = "";
                character = 'e';
                x1 = "0";
            }
            else {
                x1 = "0";
            }
        }
        if(e.getSource() == buttonC) {
            x1 = "0";
            x2= "";
            character = 'e';
        }
        if(e.getSource() == buttonSwitch) {
            if(x1 != "0" && !isMinus) {
                isMinus = true;
                x1 = "-" + x1;
            }
            else if (isMinus) {
                x1 = x1.replace("-", "");
                isMinus = false;
            }
        }
        if(e.getSource() == buttonBackSpace) {
            if(x1 != "0" && x1.length() != 1) {
                x1 = removeLast(x1);
                if(x1.charAt(0) == '-' && x1.length() == 1) {
                    x1 = "0";
                }
            }
            else x1 = "0";
        }
        if(e.getSource() == buttonX2) {
            if(equals != "") {
                x1 = equals;
                x2 = "";
            }
            x1 = String.valueOf(Double.valueOf(x1) * Double.valueOf(x1));
            x1 = trimmer(x1);
        }
        if(e.getSource() == buttonSquareRoot) {
            if(equals != "") {
                x1 = equals;
                x2 = "";
            }
            x1 = String.valueOf(Math.sqrt(Double.valueOf(x1)));
            x1 = trimmer(x1);
        }
        if(e.getSource() == buttonDot) {
            if(!isFloat) {
                x1 = x1 + ".";
            }
        }
        if(e.getSource() == buttonPercent) {
            if(x2 == "") {
                x1 = "0";
            }
            else {
                x1 =String.valueOf(Double.valueOf(x1)*0.01);
            }
        }
        if(e.getSource() == buttonDivide) {
            if(x1 == "0" && x2 != "") {
                System.out.println("CANNOT DIVIDE BY 0");

            }
            else if (equals!= "") {
                x2 = equals;
                character = '/';
                equals = "";
            }
            else if(x2 == "") {
                x2 = x1;
                character = '/';
                x1 = "";
            } else if (x1 != "") {
                x2 = String.valueOf(Double.valueOf(x2)/Double.valueOf(x1));
                x2 = trimmer(x2);
                x1 = "";
            }
        }
        if(e.getSource() == buttonX) {
            if (equals!= "") {
                x2 = equals;
                character = 'x';
                equals = "";
            }
            else if(x2 == "") {
                x2 = x1;
                character = 'x';
                x1 = "";
            } else if (x1 != "") {
                x2 = String.valueOf(Double.valueOf(x2)*Double.valueOf(x1));
                x2 = trimmer(x2);
                x1 = "";
            }
        }
        if(e.getSource() == buttonPlus) {
            if (equals!= "") {
                x2 = equals;
                character = '+';
                equals = "";
            }
            else if(x2 == "") {
                x2 = x1;
                character = '+';
                x1 = "";
            } else if (x1 != "") {
                x2 = String.valueOf(Double.valueOf(x2)+Double.valueOf(x1));

                x2 = trimmer(x2);

                x1 = "";
            }
        }
        if(e.getSource() == buttonMinus) {
            if (equals!= "") {
                x2 = equals;
                character = '-';
                equals = "";
            }
            else if(x2 == "") {
                x2 = x1;
                character = '-';
                x1 = "";
            } else if (x1 != "") {
                x2 = String.valueOf(Double.valueOf(x2)-Double.valueOf(x1));
                        x2 = trimmer(x2);
                x1 = "";
            }
        }
        for(int i =0; i < x1.length(); i++) {
            if(x1.charAt(i) == '.') {
                isFloat =true;
                break;

            }
            else {
                isFloat = false;
            }
        }
        if(e.getSource() != buttonEquals) {
            temp1 = "";
            temp2 = "";
            System.out.println(" ");
            System.out.print(x2);
            if(character !='e') {
                System.out.print(" " +character + " ");
                label.setText(x2 +" "+character + " " + x1);
            }
            else {
                if(x1 == "") {
                    label.setText("0");
                }
                else label.setText(x1);
            }
            System.out.print(x1);

        }
        else{
            if(temp1 == "" && temp2 ==""){
                temp1 = x2;
                temp2 = x1;
            }
            switch (character){
                case '+':
                    equals = String.valueOf(Double.valueOf(temp1)+Double.valueOf(temp2));
                    break;
                case '-':
                    equals = String.valueOf(Double.valueOf(temp1)-Double.valueOf(temp2));
                    break;
                case 'x':
                    equals = String.valueOf(Double.valueOf(temp1)*Double.valueOf(temp2));
                    break;
                case '/':
                    equals = String.valueOf(Double.valueOf(temp1)/Double.valueOf(temp2));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + character);
            }
                   equals = trimmer(equals);
            label.setText(temp1 + " " + character + " " + temp2 + " = " + equals);
            temp1 = equals;
            x1 = "0";
            x2 = "";
        }

    }
}
public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}