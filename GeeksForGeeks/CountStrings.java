/******************************************************************************

Given a positive integer N, count all possible distinct binary strings of length N
such that there are no consecutive 1’s. Output your answer modulo 109 + 7.

Example 1:

Input:
N = 3
Output: 5
Explanation:
5 strings are (000,
001, 010, 100, 101).
Example 2:

Input:
N = 2
Output: 3
Explanation: 
3 strings are (00,01,10).
Your Task:
You don't have to print answer or take inputs. Complete the function countStrings() 
which takes single integer n, as input parameters and returns an integer denoting the answer. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105



*******************************************************************************/
import java.util.*;

public class CountStrings
{
    static int mod=1000000007;
    public static int countStrings(int n){
        int[] a=new int[n+1];
        a[0]=1;
        a[1]=2;
        for(int i=2;i<=n;i++)
            a[i]=(a[i-1]+a[i-2])%mod;
        return a[n];
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		System.out.println(countStrings(n));
	}
}
