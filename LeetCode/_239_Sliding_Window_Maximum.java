import java.util.Stack;
import java.util.Arrays;

public class _239_Sliding_Window_Maximum {
     /**
    Yaaahooooooooooooo kar dikhayaaaaaaaaaaaaaaaaa 
    pehle toh voh approach hai jisse time limit exceed hoti hai 
    kyunki vhi dimaag mai aaya tha mere toh 
    
    fir maine sumeet sir ko dekha ki unhonne kaise kia hai '
    toh fir maine bhi vaise kia hai
    aur mera sahi ho gya h 
    */
     public static int[] maxSlidingWindow_2D_array(int[] nums, int k) {
        int n=nums.length;
        //edge-case
        if(n==1)
        {
            return nums;
        }
        int[] msw=new int[n-k+1]; //calculate krke dekhi maine 2-3 cases ke liye 
     
        int[][]nge=NGE(nums, n);
        int i=0;
        int j=0;
       
        for(i=0; i<msw.length; i++)
        {
            j=i;
            while(nge[j][1]>=i && nge[j][1]<i+k)
            {
                j=nge[j][1];
                if(j==i+k-1)
                {
                    break;
                }
            }
            msw[i]=nums[j];

        }
       return msw;
    }
    public static int[][] NGE(int[]nums , int n)
    {
         Stack<int[]> stack=new Stack<>();

         //nge element + uska index 
        int[][]nge=new int[n][2];


        nge[n-1][0]=n;
        nge[n-1][1]=n;


        stack.push(new int[]
        {
            nums[n-1] , n-1
        });
        for(int i=n-2;i>=0;i--)
        {
            while(!stack.isEmpty() && stack.peek()[0]<=nums[i])
            {   
                stack.pop();
            }
            if(!stack.isEmpty())
            {
                nge[i][0]=stack.peek()[0];
                nge[i][1]=stack.peek()[1];
            }
            else{
                nge[i][0]=n;
                nge[i][1]=i;
            }
            stack.push(new int[]
            {
                nums[i] ,i
            });
        }
        return nge;
    }


     public static int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        //edge-case
        if(n==1)
        {
            return nums;
        }
        int[] msw=new int[n-k+1]; //calculate krke dekhi maine 2-3 cases ke liye 
     
        int[]nge=ngeIndex(nums, n);
        int i=0;
        int j=0;
       
        for(i=0; i<msw.length; i++)
        {  

            if(j<i)
            {
                j=i;
            }
            while(nge[j]<i+k)
            {
                j=nge[j];
            }
            msw[i]=nums[j];
        }
       return msw;
    }
    public static int[] ngeIndex(int[]nums, int n)
    {
         
        int[]nge=new int[n];
        Stack<Integer> stack=new Stack<>();
        stack.push(n-1);
        nge[n-1]=n;
        
        for(int i=n-2;i>=0;i--)
        {
            while(!stack.isEmpty() && nums[i]>=nums[stack.peek()])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                nge[i]=n;
            }
            else{
                nge[i]=stack.peek();
            }

            stack.push(i);
        }

       return nge;

    }
   
    public static void main(String[] args) {
        int[]nums={4,-2,3,4,76,54,2,8};


        int[][]nge=new int[nums.length][2];
        nge=NGE(nums, nums.length);
        for(int[] arr:nge)
        {
            System.out.print(Arrays.toString(arr) + " ");
        }
   
        System.out.println();
        System.out.println();

        int[]msw=maxSlidingWindow_2D_array(nums,7);
        System.out.print(Arrays.toString(msw) + " ");


        System.out.println();
        System.out.println();


        int[]ngeIndex=ngeIndex(nums,nums.length);
        System.out.println(Arrays.toString(ngeIndex));

        
        System.out.println();
        System.out.println();

        int[]mswIndex=maxSlidingWindow_2D_array(nums,7);
        System.out.print(Arrays.toString(mswIndex) + " ");
    }
}
