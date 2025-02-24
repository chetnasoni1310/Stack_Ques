import java.util.Stack;

public class Parenthesis_Checker {
  static boolean isBalanced(String s) {
        // code here
        /*
        Key obs:
        1. if stack is not empty at last when string is fully travered then return false
        */
        
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {  
            char ch=s.charAt(i);
            if(ch=='{' || ch== '(' || ch== '[')
            {
                stack.push(ch);
            }
            else
            {
                if(ch==')')
                {   
                    if(!stack.isEmpty())
                    {
                        if(stack.peek() != '(')
                        {
                          return false;
                        }
                        stack.pop();
                    }
                    else
                    stack.push(ch);
                   
                }
                else if(ch=='}')
                {    
                    if(!stack.isEmpty())
                    {
                        if(stack.peek() != '{')
                        {
                          return false;
                        }
                        stack.pop();
                    }
                    else
                    stack.push(ch);
                   
                }
                else
                {    
                    if(!stack.isEmpty())
                    {
                        if(stack.peek() != '[')
                        {
                          return false;
                        }
                        stack.pop();
                    }
                    else
                    stack.push(ch);
                   
                }
            }
            
            
        }
        if(stack.isEmpty())
        return true;
        else
        return false;
    }
}
