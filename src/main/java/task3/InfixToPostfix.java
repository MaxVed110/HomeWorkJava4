package task3;
//Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "((2+3)*(4+5))*2";
        String postfix = infixToPostfix(infix);
        System.out.println(postfixCalculation(postfix));

    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfixResult = new StringBuilder("");
        Stack<String> buf = new Stack<>();
        for (String item : infix.split("")) {
            if (isNumeric(item)) {
                postfixResult.append(item);
            } else {
                if ("+-".contains(item)) {
                    while (!buf.empty() && !buf.peek().equals("(")) {
                        postfixResult.append(buf.pop());
                    }
                    buf.push(item);
                }
                if ("*/(".contains(item)) {
                    buf.push(item);
                }
                if (item.equals(")")) {
                    while (!buf.peek().equals("(")) {
                        postfixResult.append(buf.pop());
                    }
                    String rem = buf.pop();
                }
            }
        }
        while (!buf.empty()) {
            postfixResult.append(buf.pop());
        }
        return postfixResult.toString();
    }

    public static boolean isNumeric(String s) {
        try {
            int value = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double postfixCalculation(String postfix) {
        Stack<String> buf = new Stack<>();
        double result = 0;
        double a = 0;
        double b = 0;

        for (String item : postfix.split("")) {
            if (isNumeric(item)) {
                buf.push(item);
            } else {
                if (item.equals("+")) {
                    result = Double.parseDouble(buf.pop()) + Double.parseDouble(buf.pop());
                    buf.push(Double.toString(result));
                }
                if (item.equals("-")) {
                    a = Double.parseDouble(buf.pop());
                    b = Double.parseDouble(buf.pop());
                    result = b - a;
                    buf.push(Double.toString(result));
                }
                if (item.equals("*")) {
                    result = Double.parseDouble(buf.pop()) * Double.parseDouble(buf.pop());
                    buf.push(Double.toString(result));
                }
                if (item.equals("/")) {
                    a = Double.parseDouble(buf.pop());
                    b = Double.parseDouble(buf.pop());
                    result = b / a;
                    buf.push(Double.toString(result));
                }
            }
        }
        result = Double.parseDouble(buf.pop());
        return result;
    }
}
