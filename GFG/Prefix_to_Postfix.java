package GFG;

import java.util.Stack;

public class Prefix_to_Postfix {
 static String preToPost(String s) {
        // code here
          Stack<String> postfix = new Stack<>();
    
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                postfix.push(Character.toString(ch));
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String a = postfix.pop();
                String b = postfix.pop();
                String res = a + b +ch;
                postfix.push(res);
            }
        }
        return (postfix.pop());
    }
}
