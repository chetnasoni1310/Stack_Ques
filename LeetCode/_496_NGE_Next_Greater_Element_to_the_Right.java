import java.util.HashMap;
import java.util.Stack;

public class _496_NGE_Next_Greater_Element_to_the_Right
{ 
    /*
     *********************************************************
     Don't forgot to put lastelement into the stack
     before starting operationss
     CRUCIAL STEP

     **********************************************************

     
    We will perform three operations with stack
    for every integer in the nums2
    1. - pop
    2. ans
    3. + push 
    i.e. firstly pop from the stack jab tak aap uss integer se
        bade integer tk nahi pocho
        jab tk chote h usse tab tk pop krwao
        agar aapne stack khali krdia mtlb koi bada h hi nhi 
        -1 bhar do 

    then agar stack m kuch hai toh jo peek pe hai usko answer
     m bhardo     

     then jo integer hum traverse kr rhe h usko push krdo
    */
   public int[] nextGreaterElement_FromLast(int[] nums1, int[] nums2)
   {
         HashMap<Integer,Integer> map=new HashMap<>();
         Stack<Integer> stack=new Stack<>();
         int n1=nums1.length;
        int n2=nums2.length;

         map.put(nums2[n2-1] , -1);
         stack.push(nums2[n2-1]);
         for(int i=n2-2;i>=0;i--)
         {
            while(!stack.isEmpty() && nums2[i]>=stack.peek())
            {
                stack.pop();  // - pop
            } 
            if(stack.isEmpty())
            {
                map.put(nums2[i],-1);   // ans
            }
            else{
                map.put(nums2[i],stack.peek()) ;  // ans
            }
            stack.push(nums2[i]);            // + push
         }
         int[]result=new int[n1];
        for(int i=0;i<n1;i++)
        {
            result[i]=map.get(nums1[i]);
        } 
        return result;
   }

   public int[] nextGreaterElement_FromFirst(int[] nums1, int[] nums2)
   {
    HashMap<Integer,Integer> map=new HashMap<>();
    Stack<Integer> stack=new Stack<>();
    int n1=nums1.length;
   int n2=nums2.length;
   int[]result=new int[n1];

       stack.push(nums2[0]);
       for(int i=1;i<n2;i++)
       {
           while(!stack.isEmpty() && stack.peek()<nums2[i] )
           {
              map.put(stack.peek(),nums2[i]);
              stack.pop();
           }
           stack.push(nums2[i]);
       }
       while(!stack.isEmpty())
       {
        map.put(stack.peek(),-1);
        stack.pop();
       }
       for(int i=0;i<n1;i++)
        {
            result[i]=map.get(nums1[i]);
        } 
        return result;
   }
}