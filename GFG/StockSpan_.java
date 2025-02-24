public class StockSpan_
{
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
      
       /*
       Key Observations:
       1. We will create a stack in that stack we will store an array whenever we pop out something
          we will add the curr stock span to the newly added once
          */
          
         Stack<int[]> stack=new Stack<>();
         ArrayList<Integer> result=new ArrayList<>();
         
         //Add 1st element to the list and stack
         stack.push(new int[] {arr[0] , 1});
         result.add(stack.peek()[1]);
         
         for(int i=1;i<arr.length;i++)
         {
             int element=arr[i];
             int stockValue=1;
             while(!stack.isEmpty() && stack.peek()[0]<=element)
             {
                 stockValue+=stack.pop()[1];
             }
             
             stack.push(new int[] {arr[i] , stockValue});
             result.add(stockValue);
             
         }
         return result;
    }
}