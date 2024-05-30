/******************************************************************************

Given two strings, s1 and s2, count the number of subsequences of string s1 equal to
string s2.

Return the total count modulo 1e9+7.

Example 1:

Input: s1 = geeksforgeeks, s2 = gks
Output: 4
Explaination: We can pick characters from s1 as a subsequence from indices {0,3,4},
{0,3,12}, {0,11,12} and {8,11,12}.So total 4 subsequences of s1 that are equal to s2.
Example 2:

Input: s1 = problemoftheday, s2 = geek
Output: 0
Explaination: No subsequence of string s1 is equal to string s2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function 
countWays() which takes the string s1 and s2 as input parameters and returns the number 
of subsequences of s1 equal to s2.

Expected Time Complexity: O(n*m)  [n and m are lengths of the strings s1 and s2]
Expected Auxiliary Space: O(n*m)     [n and m are lengths of the strings s1 and s2]

Constraints:
1 ≤ n, m ≤ 500  [n and m are lengths of the strings s1 and s2]

*******************************************************************************/
import java.util.*;

public class countWays
{
    
    static long[][] dp;
    static long mod=1000000007L;
    
    public static long recurse(String s,String a,int n,int m){
        if(m==0)
            return 1;
        if(n==0)
            return 0;
        if(dp[n][m]!=-1)
            return dp[n][m];
        if(s.charAt(n-1)==a.charAt(m-1))
            dp[n][m]=((recurse(s,a,n-1,m-1)%mod)+(recurse(s,a,n-1,m))%mod)%mod;
        else
            dp[n][m]=recurse(s,a,n-1,m)%mod;
        return dp[n][m]%mod;
    }
    
    public static int countWays(String s1, String s2) {
        dp=new long[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++)
            Arrays.fill(dp[i],-1);
        recurse(s1,s2,s1.length(),s2.length());
        return (int)dp[s1.length()][s2.length()];
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s1=x.nextLine(),s2=x.nextLine();
		System.out.println(countWays(s1,s2));
	}
}
