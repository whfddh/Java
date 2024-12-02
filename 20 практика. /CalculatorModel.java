import java.util.Stack;

public class CalculatorModel {
    public double RPN(String[] tokens) {
        Stack<Double> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Ошибка" + token);
                }
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                double result = performOperation(operand2, operand1, token);
                stack.push(result);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Ошибка в введении");
        }

        return stack.pop();
    }

    public boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на нуль");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Некорректный оператор: " + operator);
        }
    }
}
