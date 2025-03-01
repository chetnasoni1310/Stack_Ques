public class Decode_the_String {
    static void decodeString_REcursive_MushKil_Hai(String s) {
         
    }
   
   
   // static String decodeString_Iterative_2_Stacks(String s) {
   static String decodeString(String s) {
       // code here
       /* Key Observations 
       1. Take 2 stacks for better handling of numbers and strings 
          Because we cannot store the reperatCount and repeatedString simultaneously in 
          1 stack
          
       2. After this iterate over the string s 
       3. If ch is a digit push it in the number stack
       4. If ch is a letter then append it to the current StringBuilder
       5. If ch is [ starting bracket then 
       we are going to start a new chapter 
       so store the prev memories 
       so store the current Substring we have build so far 
       then clear the data for future generation of string in current Substring 
       
       6. If ch is ] closing bracket then 
       pop the string = new start 
       pop the number = repeat Count
       
       then repeat the CURRENT STRING repeat count times 
       after this add the new start OR append the above result to new start
       */
       
       
       int n=s.length();
       Stack<Integer> number = new Stack<>();
       Stack<StringBuilder> str = new Stack<>();
       
       StringBuilder currString= new StringBuilder();
       
       for(int i=0 ; i< n;i++)
       {
           char ch=s.charAt(i);
           
           if(Character.isDigit(ch))
           {  
               int num = ch -'0';
               i++;
               while(i<n && Character.isDigit(s.charAt(i)) )
               {
                   num= num*10 + ( s.charAt(i) - '0' );
                   i++;
               }
               i--;
               number.push(num);
           }
           
           
           else if( ch == '[')
           {   
               //Nayi shuruwat kr rhe h purane ko store krlete hai 
               str.push(new StringBuilder(currString));
               
               currString.setLength(0);
           }
           
           else if( ch == ']')
           {
               //Chalo naye rishto ko khtm krte hai aur naye rishto ke liye
               StringBuilder newStart = str.pop();
               int repeatCount = number.pop();
               String temp = currString.toString();
               
                 currString.setLength(0);
               for(int j=0;j < repeatCount ;j++)
               {
                   currString.append( temp );
               }
               
               currString.insert(0 , newStart ) ;
               // str.push(newStart);
               
           }
           
           else  //IF it is a letter
           {
               currString.append(ch);
           }
       }
       
       return currString.toString();
       
   }
}
