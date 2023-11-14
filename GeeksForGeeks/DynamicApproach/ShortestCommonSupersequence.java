/******************************************************************************

Given two strings X and Y of lengths m and n respectively, find the length of the
smallest string which has both, X and Y as its sub-sequences.
Note: X and Y can have both uppercase and lowercase letters.

Example 1
Input:
X = abcd, Y = xycd
Output: 6
Explanation: Shortest Common Supersequence
would be abxycd which is of length 6 and
has both the strings as its subsequences.


Example 2
Input:
X = efgh, Y = jghi
Output: 6
Explanation: Shortest Common Supersequence
would be ejfghi which is of length 6 and
has both the strings as its subsequences.

Your Task:
You don't have to take any input or print anything. Your task is to complete 
shortestCommonSupersequence() function that takes X, Y, m, and n as arguments and
returns the length of the required string.

Expected Time Complexity: O(Length(X) * Length(Y)).
Expected Auxiliary Space: O(Length(X) * Length(Y)).

Constraints:
1<= |X|, |Y| <= 100

*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++)
                if(X.charAt(i-1)==Y.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else 
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
        return m+n-dp[m][n];
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine(),a=x.nextLine();
	System.out.println(shortestCommonSupersequence(s,a,s.length(),a.length()));
	}
}
