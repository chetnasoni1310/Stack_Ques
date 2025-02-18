import java.util.Stack;

public class _942_DI_String {
    public int[] diStringMatch(String s) {
        
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
