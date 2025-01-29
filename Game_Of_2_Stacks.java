import java.util.List;

public class Game_Of_2_Stacks {
    //Pehle iterative
    //Phir Recursive
     public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    // Write your code here
      int i=0;
      int j=0;
      int currentSum=0;
      int numberPopped=0;
      while(currentSum<maxSum && i<a.size() )
      {
         if(currentSum+a.get(i)<=maxSum)
            {   
                currentSum+=a.get(i);
                numberPopped+=1;
            }
       i++;
      }
      int MaxTillNow=numberPopped;
      while( j<b.size() )
      {
         currentSum+=b.get(j);
         j++;
         while(currentSum>maxSum && i>0)
         {
            i--;
            currentSum-=a.get(i);
         }
         if(currentSum<=maxSum)
         {
            MaxTillNow = Math.max(MaxTillNow, i + j);
         }
      }
      return numberPopped;
    }

    public static int twoStacks_Using_Recursion(int maxSum, List<Integer> a, List<Integer> b) {
        return twoStacks_Using_Recursion_Helper(maxSum ,a,b,0,0);
            }
        
    private static int twoStacks_Using_Recursion_Helper(int maxSum, List<Integer> a, 
    List<Integer> b, int currentSum, int count) {
      if(currentSum>maxSum)
      {
        return count;
      }
      if(a.size()==0 || b.size()==0)
      {
        return count;
      }

      int ans1=twoStacks_Using_Recursion_Helper(maxSum,Collection.copyOfRange())

    }
}
