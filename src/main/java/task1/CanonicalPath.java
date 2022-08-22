package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CanonicalPath {
    public static void main(String[] args) {
        String path = "/home//gs/gh/..//hdd//";
        String[] buf = path.split("/");
        System.out.println(Arrays.toString(buf));
        String ss = canonicalPath(path);
        System.out.println(ss);
    }

    public static String canonicalPath(String path) {
        String[] buf = path.split("/");
        StringBuilder buf_string = new StringBuilder("");
        Stack<String> stack_path = new Stack<>();
        for (String word : buf) {
            if (!word.equals("") && !word.equals(" ") && !word.equals(".")) {
                if (word.equals("...")) {
                    if (!stack_path.empty()) {
                        stack_path.push(word);
                        break;
                    } else {
                        return "/...";
                    }
                }
                if (word.equals("..")) {
                    if (!stack_path.empty()) {
                        String rem = stack_path.pop();
                    }
                    continue;
                }
                stack_path.push(word);
            }
        }
        if (stack_path.empty()) {
            return "/";
        }
        while (!stack_path.empty()) {
            buf_string.insert(0, stack_path.pop());
            buf_string.insert(0,"/");
        }
        return buf_string.toString();
    }
}
