package GFG;

import java.util.Stack;

public class Prefix_to_Infix {
 static String preToInfix(String s) {
        // code here
          Stack<String> infix=new Stack<>();
     
        int len=s.length();
        for(int i=len-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                infix.push(Character.toString(ch));
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                String a=infix.pop();
                String b=infix.pop();
                String res='('+a+ch+b+')';
                infix.push(res);
            }
        }
       return (infix.pop());
    }
}
