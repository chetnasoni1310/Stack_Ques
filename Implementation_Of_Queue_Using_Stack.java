import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class Implementation_Of_Queue_Using_Stack{
    private Stack<Integer> first;
   private Stack<Integer> second;

    public Implementation_Of_Queue_Using_Stack() {
         first = new Stack<>();
        second = new Stack<>();
    }
    public void push(int n)
    {
          first.push(n);
    }
    public int pop() {
        while(!first.isEmpty())
        {
            second.push(first.pop());
        }
        int removed=second.pop();
        while(!second.isEmpty())
        {
            first.push(second.pop());
        }
        return removed;
    }
    public int peek(){
        while(!first.isEmpty())
        {
            second.push(first.pop());
        }
        int peeked=second.peek();
        while(!second.isEmpty())
        {
            first.push(second.pop());
        }
        return peeked;
    }
    public boolean empty()
    {
        return first.isEmpty() && second.isEmpty();
    }
}
