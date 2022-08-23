package task1;

import java.util.Stack;

public class CanonicalPath {
    public static void main(String[] args) {
        String path = "/home//gs/gh/..//hdd//";
        String ss = canonicalPath(path);
        System.out.println(ss);
    }

    public static String canonicalPath(String path) {
        String[] buf = path.split("/");
        StringBuilder bufString = new StringBuilder("");
        Stack<String> stackPath = new Stack<>();
        for (String word : buf) {
            if (!word.equals("") && !word.equals(" ") && !word.equals(".")) {
                if (word.equals("...")) {
                    if (!stackPath.empty()) {
                        stackPath.push(word);
                        break;
                    } else {
                        return "/...";
                    }
                }
                if (word.equals("..")) {
                    if (!stackPath.empty()) {
                        String rem = stackPath.pop();
                    }
                    continue;
                }
                stackPath.push(word);
            }
        }
        if (stackPath.empty()) {
            return "/";
        }
        while (!stackPath.empty()) {
            bufString.insert(0, stackPath.pop());
            bufString.insert(0, "/");
        }
        return bufString.toString();
    }
}
