package GFG;

import java.util.Stack;

public class Postfix_to_Infix {
     static String postToInfix(String s) {
        // code here
          Stack<String> infix=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                infix.push(Character.toString(ch));
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                String s2=infix.pop();
                String s1=infix.pop();
                String res= '('+s1+ch+s2+')';
                infix.push(res);
            }
        }
       return infix.pop();
    }
}
