package algorithm;

import java.util.Scanner;
public class inex {
	 
    public static String[] alignment(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int[][] costs = new int[a.length()+1][b.length()+1];
        
        for (int j = 0; j <= b.length(); j++)
            costs[0][j] = j;
        
        for (int i = 1; i <= a.length(); i++) {
            costs[i][0] = i;
            
            
            for (int j = 1; j <= b.length(); j++) {
                costs[i][j] = Math.min(1 + Math.min(costs[i-1][j], 
                costs[i][j-1]), a.charAt(i - 1) == b.charAt(j - 1) ? costs[i-1][j-1] : costs[i-1][j-1] + 1);
            }
        }
 
	StringBuilder aPathRev = new StringBuilder();
	
	StringBuilder bPathRev = new StringBuilder();
	
	for (int i = a.length(), j = b.length(); i != 0 && j != 0; ) 
	
	{
	    if (costs[i][j] == (a.charAt(i - 1) == b.charAt(j - 1) ? 
	    	costs[i-1][j-1] : costs[i-1][j-1]+1)) {
		aPathRev.append(a.charAt(--i));
		bPathRev.append(b.charAt(--j));
	    } else if (costs[i][j] == 1 + costs[i-1][j]) {
		aPathRev.append(a.charAt(--i));
		bPathRev.append('-');
	    } else if (costs[i][j] == 1 + costs[i][j-1]) {
		aPathRev.append('-');
		bPathRev.append(b.charAt(--j));
	    }
	}
        return new String[]{aPathRev.reverse().toString(), bPathRev.reverse().toString()};
    }
 
    public static void main(String[] args) {
    System.out.println("Enter Your String:");
    Scanner scanner = new Scanner(System.in);
    String patternString = scanner.nextLine();
    
    System.out.println("Enter your test String:");
    String testString = scanner.nextLine();
    
	String[] result = alignment(patternString,testString);
	System.out.println(result[0]);
	System.out.println(result[1]);
    }
}
