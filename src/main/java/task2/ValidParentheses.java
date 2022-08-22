package task2;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        String test = "()((";
        System.out.println(Valid(test));
    }

    public static boolean Valid(String s) {
        Map<String, String> directory = new HashMap<>();
        directory.put("(", ")");
        directory.put("[", "]");
        directory.put("{", "}");

        Stack<String> check_valid = new Stack<>();

        for (String item : s.split("")) {
            if (directory.containsKey(item)) {
                check_valid.push(item);
                continue;
            }
            if (directory.containsValue(item) && check_valid.empty()){
                return false;
            }
            if(directory.get(check_valid.peek()).equals(item)){
                String remove = check_valid.pop();
            }
            else{
                return false;
            }
        }
        return check_valid.empty();
    }
}
