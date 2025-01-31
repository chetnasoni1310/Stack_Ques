import java.util.Stack;


    public class _901_Online_Stock_Span {
               Stack<int[] > stack;
        public _901_Online_Stock_Span() {
           new Stack<>();
        }
        public int next(int price) {
            int span=1;
            while(!stack.isEmpty() && stack.peek()[0]<=price)
            {   
                span=span+ stack.peek()[1];
                stack.pop();
            }
             stack.push(new int[]{price , span});
             return span ;
        }
     
        /* This ******************** --->>>>>>>>>
         
         */
        public static int[]  PGE_Previous_Greater_Element(int[]arr) {
            int n=arr.length;
            int[]pge=new int[n];
            Stack<int[] > stack=new Stack<>();
            //stack.push(new int[]{value ,index});
            stack.push(new int[]{arr[0],0});
            pge[0]=1;
            for(int i=1;i<n;i++){
    
                while(!stack.isEmpty() && stack.peek()[0]<=arr[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty()){
                      pge[i]=i+1;
                }
                else
                    pge[i]=i-stack.peek()[1];
    
                stack.push(new int[] {arr[i] , i});
            }
    
            return pge;
        }

      public static void main(String[] args) {
        int[]nums={2,3,10,2,7,3,4,5,13,11};
        int[] stockSpan=PGE_Previous_Greater_Element(nums);
         
        for(int i:stockSpan)
        {
            System.out.print(i+" ");
        }
      }
    }

