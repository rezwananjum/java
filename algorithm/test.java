package algorithm;

import java.util.Scanner;

public class test {
	
    public int recEditDistance(char[]  str1, char str2[], int len1,int len2){
        
        if(len1 == str1.length){
        	//System.out.println(len1+""+ str1.length);
            return str2.length - len2;
        }
        if(len2 == str2.length){
            return str1.length - len1;
            
        }
        
        //setting the matrix
        
        return min(recEditDistance(str1, str2, len1 + 1, len2 + 1) + 
        		str1[len1] == str2[len2] ? 0 : 1,
        		recEditDistance(str1, str2, len1, len2 + 1) + 1, 
        		recEditDistance(str1, str2, len1 + 1, len2) + 1
        		);
    }
    
  
    public int dynamicEditDistance(char[] str1, char[] str2){
        int temp[][] = new int[str1.length+1][str2.length+1];
        
        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i; 
            		
        }
        
        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
          
        }
        
        for(int i=1;i <=str1.length; i++){
        	
            for(int j=1; j <= str2.length; j++){
            	//traceback
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1]; //diagonal value//trace
                }else{
                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
                    //min of 3 side value/trace
                }
            }
        }
        printActualEdits(temp, str1, str2);
       // System.out.println(temp[str1.length][str2.length]);
        return temp[str1.length][str2.length];
        
    }

  
    
    
    
    public void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;   
        int j = T[0].length - 1;
        int step =0;
        
       // System.out.println(j); 
        while(true) {
            if (i == 0 || j == 0) {
                break;
                
            }
            if (str1[i-1] == str2[j-1]) {
                i = i-1; 
                j = j-1; //tracing back 
              //  System.out.println(j); 
               
                
            } else if (T[i][j] == T[i-1][j-1] + 1){
            	System.out.println("Step no:"+ step);
            	System.out.println(str1);           
                System.out.println(str2);
               // System.out.println("Edit " + str2[j-1] + " in string2 to " + str1[i-1] + " in string1");
                i = i-1;
                j = j-1;
                step++;
                System.out.println("Step no:"+ step);
                str2[j]=str1[i];
                System.out.println(str1);           
                System.out.println(str2);
                step++;
                
            } else if (T[i][j] == T[i-1][j] + 1) {
            	
                i = i-1;
              //  System.out.println("!"+i); 
                System.out.println("Step no:"+ step);
            	System.out.println(str1);           
                System.out.println(str2);
                
               
                
            } else if (T[i][j] == T[i][j-1] + 1){
                j = j -1;
                str2[j]=0;
                System.out.println("Step no:"+ step);
            	System.out.println(str1);           
                System.out.println(str2);
                
                step++;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }

    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public static void main(String args[]){
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter Your string:");
    	String baseString = scanner.nextLine();
    	
    	System.out.println("Enter Your Test String:");
        String testString =scanner.nextLine(); 
        System.out.println("Your Base String:"+baseString);           
        System.out.println("Your Test String"+testString);
        
        test editDistance = new test();
        int result = editDistance.dynamicEditDistance(baseString.toCharArray(), testString.toCharArray());
        System.out.print("Character Modified Number in the String:"+result);
    }

}