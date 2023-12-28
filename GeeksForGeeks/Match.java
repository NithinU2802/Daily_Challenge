/******************************************************************************

Given two strings wild and pattern. Determine if the given two strings can be matched
given that, wild string may contain * and ? but string pattern will not. * and ? can 
be converted to another character according to the following rules:

* --> This character in string wild can be replaced by any sequence of characters, it
* can also be replaced by an empty string.
? --> This character in string wild can be replaced by any one character.
Example 1:

Input: 
wild = ge*ks
pattern = geeks
Output: Yes
Explanation: Replace the '*' in wild string 
with 'e' to obtain pattern "geeks".
Example 2:

Input: 
wild = ge?ks*
pattern = geeksforgeeks
Output: Yes
Explanation: Replace '?' and '*' in wild string with
'e' and 'forgeeks' respectively to obtain pattern 
"geeksforgeeks"
Your Task:
You don't need to read input or print anything. Your task is to complete the function
match() which takes the string wild and pattern as input parameters and returns true 
if the string wild can be made equal to the string pattern, otherwise, returns false.

Expected Time Complexity: O(length of wild string * length of pattern string)
Expected Auxiliary Space: O(length of wild string * length of pattern string)

Constraints:
1 <= length of the two string <= 10^3 

*******************************************************************************/
import java.util.*;

public class Main
{
    static boolean match(String wild, String pattern) {
        int m=wild.length(),n=pattern.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<m+1;i++)
            if(wild.charAt(i-1)=='*')
                dp[i][0]=dp[i-1][0];
        for(int i=1;i<m+1;i++)
            for(int j=1;j<n+1;j++)
                if(wild.charAt(i-1)==pattern.charAt(j-1) || wild.charAt(i-1)=='?')
                    dp[i][j]=dp[i-1][j-1];
                else if(wild.charAt(i-1)=='*')
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
        return dp[m][n];
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine(),r=x.nextLine();
		if(match(s,r))
		    System.out.println("YES");
		else 
		    System.out.println("NO");
	}
}
