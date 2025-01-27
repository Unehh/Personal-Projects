package org.example;

public class MathematicsOperations {
    public double calculate(double first, double second, char operator) {
        return switch (operator) {
            case '+' -> first + second;
            case '-' -> first - second;
            case 'x' -> first * second;
            case '/' -> second != 0 ? first / second : Double.NaN;
            default -> throw new IllegalArgumentException("Unsupported operator: " + operator);
        };
    }

    public double square(double number) {
        return Math.pow(number, 2);
    }

    public double squareRoot(double number) {
        return Math.sqrt(number);
    }

    public double turnDecimal(double number) {
        if (number == 0) throw new ArithmeticException("Division by zero");
        return 1 / number;
    }

    public double percent(double number) {
        return number / 100;
    }
}
