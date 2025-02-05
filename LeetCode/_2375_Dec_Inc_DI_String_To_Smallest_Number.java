import java.util.Stack;

public class _2375_Dec_Inc_DI_String_To_Smallest_Number {
 public String smallestNumber(String pattern) {
        StringBuffer result=new StringBuffer();
        int n=pattern.length();

        int num=1;
        
        Stack<Integer> stack=new Stack<>();
       
        for (int i = 0; i <= n; i++) {
            stack.push(num++);
            
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }
}
