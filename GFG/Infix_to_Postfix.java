package GFG;

import java.util.Stack;

public class Infix_to_Postfix {
public static String infixToPostfix(String s) {
        // Your code here
         Stack<String> postfix=new Stack<>();
        Stack<Character> operator=new Stack<>();
      
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                operator.push(ch);
            }
          
            else if(ch==')')
            {
                while(!operator.isEmpty() && operator.peek()!='(')
                {
                    Process(operator,postfix);
                }
                if (!operator.isEmpty()) {
                    operator.pop();  // Pop '('
                }
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^')
            {
                while(!operator.isEmpty() && Precedence(ch) <= Precedence(operator.peek()))
                {
                    Process(operator,postfix);
                }
              operator.push(ch);
            }
            else if( Character.isLetterOrDigit(ch) ){
                StringBuilder operand = new StringBuilder();
                while (i < s.length() && Character.isLetterOrDigit(s.charAt(i))) {
                    operand.append(s.charAt(i));
                    i++;
                }
                i--; 
                postfix.push(operand.toString());
                // postfix.push(ch+"");
            }
        }
        //Agar kuch bacha hua ho toh
        while(!operator.isEmpty())
        {
             Process(operator,postfix);
        }
       return postfix.pop();

    }
    private static int Precedence(char ch)
    {
        if(ch=='+' || ch=='-')
        {
            return 1;
        }
        else if(ch=='*' || ch=='/')
        {
            return 2;
        }
        else if (ch == '^') return 3;
        return -1;
    }
    private static void Process( Stack<Character> operator, Stack<String> postfix)
    {
        char ch=operator.pop();
       
        String a2=postfix.pop();
        String a1=postfix.pop();
       
        String res2=a1+a2+ch;
        postfix.push(res2);
    
    }
}
