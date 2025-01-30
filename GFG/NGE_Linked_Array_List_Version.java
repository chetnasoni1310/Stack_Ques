package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class NGE_Linked_Array_List_Version {
  public ArrayList<Integer> nextLargerElement(int[] nums2) {
        // code here
        /*
     *********************************************************
     Don't forgot to put lastelement into the stack
     before starting operationss
     CRUCIAL STEP

     **********************************************************
    ArrayList version 
    AND
    LinkedList version
    
    ***********************************************************
    */
 
         Stack<Integer> stack=new Stack<>();
        int n2=nums2.length;

       ArrayList<Integer> result=new ArrayList<Integer>();
         stack.push(nums2[n2-1]);
           result.add(0,-1); 
       
         for(int i=n2-2;i>=0;i--)
         {
            while(!stack.isEmpty() && nums2[i]>=stack.peek())
            {
                stack.pop();  // - pop
            } 
            if(stack.isEmpty())
            {
                result.add(0,-1);   // ans
            }
            else{
               result.add(0,stack.peek()) ;  // ans
            }
            stack.push(nums2[i]);            // + push
         }
       
        return result;
    }
    
    // ************************************************************
    
        public LinkedList<Integer> nextLargerElement_II(int[] nums2)
        {
             Stack<Integer> stack=new Stack<>();
        int n2=nums2.length;

       LinkedList<Integer> result=new LinkedList<Integer>();
         stack.push(nums2[n2-1]);
           result.addFirst(-1); 
       
         for(int i=n2-2;i>=0;i--)
         {
            while(!stack.isEmpty() && nums2[i]>=stack.peek())
            {
                stack.pop();  // - pop
            } 
            if(stack.isEmpty())
            {
                result.addFirst(-1);   // ans
            }
            else{
               result.addFirst(stack.peek()) ;  // ans
            }
            stack.push(nums2[i]);            // + push
         }
       
        return result;
    }
}
