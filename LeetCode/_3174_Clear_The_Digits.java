import java.util.Stack;

public class _3174_Clear_The_Digits {
 public String clearDigits_Using_Strings(String s) {
        int i=0;
        StringBuilder sb=new StringBuilder(s);
        while(i>=0 && i<sb.length())
        {
             if(i!=sb.length()-1 && Character.isDigit(sb.charAt(i+1)))
                {   
                    // sb.delete(startIndex, endIndex);
                    sb.delete(i , i+2);
                    if(i!=0)
                    i--;
                }
                else
                i++;
        }
        return sb.toString();
     }
    public String clearDigits_Using_Stack(String s) {
    
        Stack<Character> chr=new Stack<>();

    for(int i=0;i<s.length();i++)
    {
        if(Character.isDigit(s.charAt(i)))
        {
            chr.pop();
        }
        else{
            chr.push(s.charAt(i));
        }
    }
    if(chr.isEmpty())
    {
        return "";
    }
    StringBuffer result= new StringBuffer();
    while(!chr.isEmpty())
    {
         result.insert(0 , chr.pop());
    }
    return result.toString() ;
    }
}
