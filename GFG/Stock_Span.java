package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class Stock_Span {
  public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
         int n=arr.length;
          ArrayList<Integer> pge=new ArrayList<Integer>();
            Stack<int[] > stack=new Stack<>();
            //stack.push(new int[]{value ,index});
            stack.push(new int[]{arr[0],0});
           pge.add(1);
            for(int i=1;i<n;i++){
    
                while(!stack.isEmpty() && stack.peek()[0]<=arr[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty()){
                      pge.add(i+1);
                }
                else
                   pge.add(i-stack.peek()[1]);
    
                stack.push(new int[] {arr[i] , i});
            }
    
            return pge;
    }
}
