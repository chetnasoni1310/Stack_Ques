import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class _56_Merge_Overlapping_Intervals {

     /**
    1.Using LinkedList --iss wale mai maine kaafi optimisation kiye
                        hai.Learn from them.
    2.Using Stack 
    Botha re equal in complexities 
     */
      public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n=intervals.length;
        if(n==1)
        {
            return intervals;
        }
        LinkedList<int[]> list=new LinkedList<>();
        for(int[]interval : intervals)
        {
            if(list.isEmpty() || list.getLast()[1]<interval[0])
            {
                list.add(interval);
            }
            else{
              list.getLast()[1]=Math.max(list.getLast()[1] ,interval[1]);
            }
        }

        return list.toArray(new int[list.size()][2]);
      }






 public static int[][] merge_Using_Stack(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n=intervals.length;
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{intervals[0][0] , intervals[0][1]});

        for(int i=1;i<n;i++)
        {
            while(i<n && !stack.isEmpty() && intervals[i][0]<=stack.peek()[1])
            {   
                int start=stack.peek()[0];
                int end=stack.peek()[1];
                stack.pop();
                int interValEnd=Math.max(end ,intervals[i][1]);
                stack.push(new int []{ start ,interValEnd});
                i++;
            }
            if(i<n && intervals[i][0]>stack.peek()[1])
            {
                stack.push(new int []{intervals[i][0] , intervals[i][1]});
            }
        }

        int[][]res=new int[stack.size()][2];
        int i=stack.size() -1 ;
        while(i>=0 && !stack.isEmpty())
        {
            res[i][0]=stack.peek()[0];
            res[i][1]=stack.peek()[1];
            stack.pop();
            i--;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] intervals={
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };


        int[][]res=merge_Using_Stack(intervals);
        for(int[] arr:res){
            System.out.println(Arrays.toString(arr));
        }


    }
}
