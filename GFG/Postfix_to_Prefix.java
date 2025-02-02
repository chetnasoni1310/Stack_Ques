package GFG;

import java.util.Stack;

public class Postfix_to_Prefix {
  static String postToPre(String s) {
        // code here
          Stack<String> prefix=new Stack<>();
      
        int len=s.length();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                prefix.push(Character.toString(ch));
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                String a=prefix.pop();
                String b=prefix.pop();
                String res=ch+b+a;
                prefix.push(res);
            }
        }
     return (prefix.pop());
    }
}
