import java.util.Stack;

public class _503_NGE_II_Next_GE {
     /*
    We will take hypothetically doubled array
    [1,2,3,4,5][1,2,3,4,5]
     0 1 2 3 4  5 6 7 8 9    <-- indexes 
     
     pehle (2n-1)%n  wale ko push krdena

     fir (2n-2) se ulta loop chalana

     vhii same kaam kro with modulo in mind 
     fir tab tk pop krwao jab tk peek pe usse badi value naa aajaye
     mtlb saare choto ko pop krwa do 

     fir agar jo index i chl rha hai voh i<n ho jaae
     tab nge array mai put krdena value 

     vrna kaam chlne do 
     */
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[]nge=new int [n];
        Stack<Integer> stack =new Stack<>();

        stack.push(nums[n-1]);
        for(int i=2*n-2 ; i>=0 ;i--)
        {
            while(!stack.isEmpty() && nums[i%n]>=stack.peek())
            {
                stack.pop();
            }

            if(i<n)
            {    
                if(!stack.isEmpty())
                nge[i]=stack.peek();
                else
                nge[i]=-1;
            }
            stack.push(nums[i%n]);
        }
        return nge;
    }
}
