package org.example;

import static org.example.Calculator.trimmer;

public class CalculatorState {
    private String currentNumber = "";
    private String savedNumber = "";
    private char currentOperator = '\0';
    private char lastOperator = '\0';
    private String lastNumber = "";
    private boolean isReset = false;

    public String getCurrentNumber() {
        return currentNumber.isEmpty() ? "0" : currentNumber;
    }

    public void setCurrentNumber(String input) {
        this.currentNumber = trimmer(input);
    }

    public String getSavedNumber() {
        return savedNumber;
    }

    public void setSavedNumber(String input) {
        this.savedNumber = trimmer(input);
    }

    public char getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(char operator) {
        this.currentOperator = operator;
    }

    public char getLastOperator() {
        return lastOperator;
    }

    public void setLastOperator(char operator) {
        lastOperator = operator;
    }

    public String getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(String number) {
        lastNumber = number;
    }

    public boolean isReset() {
        return isReset;
    }

    public void setReset(boolean reset) {
        isReset = reset;
    }


    public void reset() {
        currentNumber = "";
        savedNumber = "";
        currentOperator = '\0';
        lastOperator = '\0';
        lastNumber = "";
        isReset = false;
    }
}
