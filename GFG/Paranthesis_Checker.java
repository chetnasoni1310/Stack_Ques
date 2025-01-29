package GFG;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Paranthesis_Checker {
  static boolean isParenthesisBalanced(String str) {
        // code here
        Stack<Character> stack=new Stack<>();
        
        //Allowed Charachters define ::
        Set<Character> allowedCharacters =new HashSet<>();
        for(char ch : ("({[]})").toCharArray())
        {
            allowedCharacters.add(ch);
        }
        
        for(char ch : str.toCharArray())
        {
            if(! allowedCharacters.contains(ch))
            {
                continue;
            }
            if(ch=='(' || ch=='{' || ch=='[')
            {
                stack.push(ch);
            }
            else{
                if(stack.isEmpty())
                {
                    return false;
                }
                
                char topElement=stack.pop();
                if(ch==')' && topElement!='(' ||
                   ch=='}' && topElement!='{' ||
                   ch==']' && topElement!='[' )
                {
                    return false;
                }
             }
           
           
        } 
        return stack.isEmpty();
    }
}
