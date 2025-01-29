package GFG;

import java.util.Stack;

public class Redundant_Brackets_Check {
 public static int checkRedundancy(String str) {
        // code here
        Stack<Character> stack=new Stack<>();
        
        
        for(char ch:str.toCharArray())
        {
            if(ch!=')')
            {
                stack.push(ch);
            }
            else{
                int count=0;
                while(!stack.isEmpty() && stack.peek()!='(')
                {
                    stack.pop();
                    count+=1;
                }
                if(!stack.isEmpty() )
                 {
                     stack.pop();
                 }
                  if(count<=1)
                {
                    return 1;
                }
            }
        }
        return 0;
    }
}
