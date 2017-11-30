package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BoyerMoore{
    
    protected char[] pattern;
    protected char[] text;

    public void preProcess(char[] pattern){
        this.pattern = pattern;
    }
    public int search(char[] text){
        this.text = text;
        return -1;
    }
    
    public static final void main(String[] args){
    	
        System.out.println("Please input the pattern");
        Scanner scanner = new Scanner(System.in);
        String patternString = scanner.nextLine();
        char[] pattern = patternString.toCharArray();
        
        System.out.println("Please input the text");
        String textString = scanner.nextLine();
        char[] text = textString.toCharArray();
        
        BoyerMoore bm = new BMStringSearchBadChar();
        bm.preProcess(pattern);
        int res = bm.search(text);
        
        System.out.println("The pattern starts in the index: " + res);
        
        return;       
    }
}

//bad char
class BMStringSearchBadChar extends BoyerMoore{
    
    private final int RADIX = 256;
    private int[][] table;

    private void construct2DTable(int patternLength){
        table = new int[RADIX][patternLength];
        for(int i = 0; i < RADIX; i ++)
            Arrays.fill(table[i], -1);

        //fill the actual value
        //record all chars, not particular one!
        for(int i = 0; i < patternLength; i ++){
            //search for previoud appearance
            for(int j = i -1; j >= 0; j --){
                int cIndex = (int)pattern[j];     
                if( j > table[cIndex][i])
                    table[cIndex][i] = j;
            }
        }
        //not found, still -1
        return;
    }

    public void preProcess(char[] pattern){
        super.preProcess(pattern);
        int patternLength = pattern.length;
        construct2DTable(patternLength);
    }

    
    
    public int search(char[] text){
        super.search(text);
        if(text.length < pattern.length || pattern.length == 0 || text.length == 0)
            return -1;
        
        //search here
        //start from the nth character
        int patternTraverser = pattern.length -1;
        int textTraverser = pattern.length - 1;
        int end = pattern.length - 1;
        
        //the position of the start of pattern in the text
        while(end <= text.length - 1){
            if(text[textTraverser] == pattern[patternTraverser]){
                patternTraverser --;
                if(patternTraverser == -1)
                    return textTraverser;
                textTraverser --; 
            }
            //mismatch happens
            else{
                int cIndex =(int) text[textTraverser];
                int position = patternTraverser;
                //find the occurance of cIndex before position
                int nextMatchIndex = table[cIndex][position];
                if(nextMatchIndex == -1){
                    //there is no occurance found, shift P past the point of
                    //mismatch
                    end += patternTraverser + 1; // because if the nextMatchIndex == 0, it will move patternTraverser blocks
                    textTraverser = end;
                    patternTraverser = pattern.length - 1;
                }
                if(nextMatchIndex >= 0){
                    end += patternTraverser - nextMatchIndex;
                    textTraverser = end;
                    patternTraverser = pattern.length - 1;
                }

            }
        }

        return -1;
    }

}

class BMStringSearchGoodSuf extends BoyerMoore{
    
    public void preProcess(char[] pattern){
        super.preProcess(pattern);

    }
    
    
    public int search(char[] text){
        
        super.search(text);
        return -1;
    }


}