import java.util.Stack;

public class Celebrity_Problem {
    public int celebrity_Brute_Force(int mat[][]) {
        // code here
        int n=mat.length;
        int[] countPersonKnowsMe=new int[n];
        int[] countI_knowPerson =new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==1)
                {
                    countPersonKnowsMe[j]+=1;
                    countI_knowPerson[i]+=1;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(countI_knowPerson[i]==0)
            {
                if(countPersonKnowsMe[i]==n-1)
                {
                    return i;
                }
            }
        }
        return -1;
    }
    public int celebrity(int mat[][]) {
     Stack<Integer> st=new Stack<>();
    int n=mat.length;
    if(n==1)
    {
        return 0;
    }
    for(int i=0;i<n;i++)
    {
        st.push(i);
    }
    while(st.size()>1)
    {
        int a=st.pop();
        int b=st.pop();
        if(mat[a][b]!=1)
        {
           st.push(a);
        }
        else
        {
            st.push(b);
        }
    }
   int potentialCelebrity= st.pop();
    for(int i=0;i<n;i++)
    {
        if(i!=potentialCelebrity)
        {
            if(mat[i][potentialCelebrity]==0 || mat[potentialCelebrity][i]==1)
            {
                return -1;
            }
        }
    }
    return potentialCelebrity;
}
}
