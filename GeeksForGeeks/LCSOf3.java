/******************************************************************************

Given 3 strings A, B and C, the task is to find the length of the longest sub-sequence 
that is common in all the three given strings.

Example 1:

Input:
A = "geeks"
B = "geeksfor", 
C = "geeksforgeeks"
Output: 5
Explanation: 
"geeks"is the longest common
subsequence with length 5.
Example 2:

Input: 
A = "abcd"
B = "efgh"
C = "ijkl"
Output: 0
Explanation: 
There's no subsequence common
in all the three strings.
Your Task:
You don't need to read input or print anything. Your task is to complete the function
LCSof3() which takes the strings A, B, C and their lengths n1, n2, n3 as input and 
returns the length of the longest common subsequence in all the 3 strings.

Expected Time Complexity: O(n1*n2*n3).
Expected Auxiliary Space: O(n1*n2*n3).

Constraints:
1 <= n1, n2, n3 <= 20
Elements of the strings consitutes only of the lower case english alphabets.



*******************************************************************************/
import java.util.*;

public class LCSOf3
{
    
    private static int LCSof3(String A, String B, String C, int n1, int n2, int n3) { 
        int res=0;
        int[][][] dp=new int[n1+1][n2+1][n3+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                    for(int k=1;k<=n3;k++){
                        if(A.charAt(i-1)==C.charAt(k-1) && B.charAt(j-1)==C.charAt(k-1))
                            dp[i][j][k]=1+dp[i-1][j-1][k-1];
                        else
                            dp[i][j][k]=Math.max(Math.max(dp[i-1][j][k],dp[i][j-1][k]),dp[i][j][k-1]);
                    }
            }
        }
        return dp[n1][n2][n3];
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String a=x.nextLine(),b=x.nextLine(),c=x.nextLine();
		System.out.println(LCSof3(a,b,c,a.length(),b.length(),c.length()));
	}
}
