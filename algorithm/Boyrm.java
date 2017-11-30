package algorithm;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 

public class Boyrm
{
    //function findPattern
    public void findPattern(String a, String b)
    {
        char[] text = a.toCharArray();
        char[] pattern = b.toCharArray();       
        int pos = indexing(text, pattern);   // pass strings form indexing
        if (pos == -1){
            System.out.println("No Match Found");
        }
        else
            System.out.println("Match Found From:"+ pos);
    }
    public int indexing(char[] text, char[] pattern) 
    {
        if (pattern.length == 0) 
            return 0;
        
        int charTable[] = makeCharTable(pattern);// handling miss-match
        int offsetTable[] = makeOffsetTable(pattern);  //bad character issue  
        for (int i = pattern.length - 1, j; i < text.length;) 
        {
            for (j = pattern.length - 1; pattern[j] == text[i]; --i, --j)
            	    
                     if (j == 0) 
                        return i;
            // naive method        
              i += Math.max(offsetTable[pattern.length - 1 - j], charTable[text[i]]);
        }      
        return -1;
      }
      
    //Makes the jump table based on the mismatched(bad char) character information   
      private int[] makeCharTable(char[] pattern) 
      {
        final int A_SIZE = 256;       
        int[] table = new int[A_SIZE];
        for (int i = 0; i < table.length; ++i) 
               table[i] = pattern.length;
        for (int i = 0; i < pattern.length - 1; ++i) 
               table[pattern[i]] = pattern.length - 1 - i;
        return table;
      }
       
    // function to check prefix of pattern
    private static boolean isPrefix(char[] pattern, int p) 
    {
        for (int i = p, j = 0; i < pattern.length; ++i, ++j) {
            if (pattern[i] != pattern[j]) {
                  return false;
            }
        }
        return true;
    }
 
    //function to returns the maximum length of the substring ends at p and is a suffix 
  
    private static int suffixLength(char[] pattern, int p) 
    {
       	int len = 0;    
        for (int i = p, j = pattern.length - 1; i >= 0 
        	&& pattern[i] == pattern[j]; --i, --j)     	
               len += 1;
               return len;
    }
    
    //jump table scan  which bad char occurs
    
    private static int[] makeOffsetTable(char[] pattern)   
    {
      int[] table = new int[pattern.length];
      int lastPrefixPosition = pattern.length;
      for (int i = pattern.length - 1; i >= 0; --i) 
      {
          if (isPrefix(pattern, i + 1)) 
                 lastPrefixPosition = i + 1;
                 table[pattern.length - 1 - i] = lastPrefixPosition - i + pattern.length - 1;
      }
      for (int i = 0; i < pattern.length - 1; ++i) 
      {
            int slen = suffixLength(pattern, i);
            table[slen] = pattern.length - 1 - i + slen;
      }
      return table;
  }
   
    // Main Function
    
    public static void main(String[] args) throws IOException
    {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        System.out.println("Enter Text");
        String text = br.readLine();       
        System.out.println("Enter Pattern");
        String pattern = br.readLine();      
        Boyrm stringMatchingPosition = new Boyrm(); 
        stringMatchingPosition.findPattern(text, pattern);     
    }
}