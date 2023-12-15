/******************************************************************************

There are N points on the road, you can step ahead by 1 or 2 . If you start from
a point 0, and can only move from point i to point i+1 after taking a step of length
one, find the number of ways you can reach at point N. 

Example 1:

Input: 
N = 4
Output: 
5
Explanation: Three ways to reach at 4th
point. They are {1, 1, 1, 1}, {1, 1, 2},
{1, 2, 1} {2, 1, 1}, {2, 2}.

Example 2:

Input: N = 5
Output: 8
Explanation: Three ways to reach at 5th
point. They are {1, 1, 1, 1, 1},
{1, 1, 1, 2}, {1, 1, 2, 1}, {1, 2, 1, 1},
{2, 1, 1, 1}{1, 2, 2}, {2, 1, 2}, {2, 2, 1}
Your Task:
You don't need to read or print anyhting. Your task is to complete the function 
nthPoint() which takes N as input parameter and returns the total number of ways 
modulo 109 + 7 to reach at Nth point.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
1 ≤ N ≤ 105



*******************************************************************************/
import java.util.*;

public class NthPoint
{
    
    static int mod=100000007;
    
    public static int nthPoint(int n){
        if(n==1 || n==2)
            return n;
        int a=1,b=2,c=3;
        n-=2;
        while(n>0){
            c=a+b;
            a=b;
            b=c;
            n--;
        }
        return c;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		System.out.print(nthPoint(n));
	}
}
