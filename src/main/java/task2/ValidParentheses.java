package task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.jetbrains.annotations.NotNull;

public class ValidParentheses {
    public static void main(String[] args) {
        String test = "()((";
        System.out.println(valid(test));
    }

    public static boolean valid(@NotNull String s) {
        Map<String, String> directory = new HashMap<>();
        directory.put("(", ")");
        directory.put("[", "]");
        directory.put("{", "}");

        Stack<String> checkValid = new Stack<>();

        for (String item : s.split("")) {
            if (directory.containsKey(item)) {
                checkValid.push(item);
                continue;
            }
            if (directory.containsValue(item) && checkValid.empty()) {
                return false;
            }
            if (directory.get(checkValid.peek()).equals(item)) {
                String remove = checkValid.pop();
            } else {
                return false;
            }
        }
        return checkValid.empty();
    }
}
