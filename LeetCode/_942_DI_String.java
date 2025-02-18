import java.util.Stack;

public class _942_DI_String {

    public int[] diStringMatch_2Pointer(String s)
    {
       /*Key observations:
       1. Take 2 pointer starting with o and n resp then 
       2. whenever you see I use smallNo. and if see D then use largeNo.
       3. At the end just have the remaining number put it there*/

       int smallNumber=0;
       int largeNumber=s.length();

       int[]result=new int[s.length() +1 ];
       int index=0;

       for(int i=0;i<result.length;i++)
       {  
           
          if(i==result.length-1 || s.charAt(i)=='I')
          {
            result[index++]=smallNumber;
            smallNumber++;
          }
          else
         { result[index++]=largeNumber;
          largeNumber--;}
       }
       return result;
    }

    public int[] diStringMatch_STACK(String s) {
        
        int n=s.length();
        Stack<Integer> stack=new Stack<>();
        int[]result=new int[n+1];

       
        int number=0;
     
        int index=0;
        for(int i=0;i<result.length;i++)
        {  
           stack.push(number++);

           if(i==result.length-1 || s.charAt(i)=='I')
           {
           while(i<=n && !stack.isEmpty() )
             {
                result[index++]=stack.pop();
             }            
           }      
        }
        return result;
    }
}
