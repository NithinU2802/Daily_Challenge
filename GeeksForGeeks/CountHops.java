/******************************************************************************

A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it 
reach the top of Nth step. As the answer will be large find the answer modulo 1000000007.

Example 1:

Input:
N = 1
Output: 1
Example 2:

Input:
N = 4
Output: 7
Explanation:Below are the 7 ways to reach
4
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step
Your Task:
Your task is to complete the function countWays() which takes 1 argument(N) and returns the answer%(10^9 + 7).

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105

*******************************************************************************/
import java.util.*;

public class CountHops
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	if(n<=2){
	    System.out.println(n);
	    return;
	}
	int[] a=new int[n+1];
	a[1]=1;
	a[2]=2;
	a[3]=4;
	for(int i=4;i<=n;i++)
	    a[i]=a[i-1]+a[i-2]+a[i-3];
	System.out.println(a[n]);
	}
}
