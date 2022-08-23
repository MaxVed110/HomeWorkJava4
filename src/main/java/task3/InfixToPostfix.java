package task3;
//Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "((2+3)*(4+5))*2";
        System.out.println(infixToPostfix(infix));
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
}
