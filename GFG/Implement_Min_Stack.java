import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Implement_Min_Stack {

   /*This is not the optimal approach 
    These are : 



    1. USe a normal stack for push , pop , peek 
    2, maintain a int minElement for getmin
    
    
    
    1. Use 2 stacks  one for normal , second for keeping minElement always on top
    
    
    
    1. Use 1 stack with int[] to keep element and minElement together 
    
    */
    List<Integer> list;
    PriorityQueue<Integer> pq;
    public Implement_Min_Stack() {
        list=new ArrayList<>();
        pq=new PriorityQueue<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        list.add(x);
        pq.offer(x);
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if(!list.isEmpty())
      {  
          int value = list.get(list.size() -1) ;
        list.remove(list.size() -1);
        pq.remove(value);
          
      }
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        return list.isEmpty() ? -1 : list.get(list.size() -1) ;
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
      return list.isEmpty() ? -1 : pq.peek();
    }
}
