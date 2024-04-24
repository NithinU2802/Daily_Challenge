/******************************************************************************

 You are standing on a point (x, y) and you want to go to the origin (0, 0) by taking 
 steps either left or down i.e. from each point you are allowed to move either in (x-1, y)
 or (x, y-1). Find the number of paths from point to origin.

Example 1:

Input:
x = 3, y = 0 
Output: 
1
Explanation: Path used was -  (3,0)  --> ( 2,0) --> (1,0) --> (0,0).We can see that there 
is no other path than this, so we return 1.
Example 2:

Input:
x = 3, y = 6
Output: 
84 
Explanation:
There are total 84 possible paths.
Your Task:
Since this is a function problem. You don't need to take any input, as it is already 
accomplished by the driver code. You just need to complete the function ways() that 
takes integer x and y as parameters and returns the total number of paths from point(x,y) 
to the origin(0,0) % 1000000007.

Expected Time Complexity: O(x*y).
Expected Auxiliary Space: O(x*y).

Constraints:
0 ≤ x, y ≤ 500



*******************************************************************************/
import java.util.*;

public class Ways
{
    public static int check(int n,int m,int[][] memo){
        if(n==0 && m==0)
            return 1;
        if(n<0 || m<0)
            return 0;
        if(memo[n][m]!=0)
            return memo[n][m];
        int res=0;
        if(n-1>=0)
            res=(res+check(n-1,m,memo))%1000000007;
        if(m-1>=0)
            res=(res+check(n,m-1,memo))%1000000007;
        memo[n][m]=res;
        return memo[n][m];
    }
    
    public static int ways(int n, int m)
    {
        int[][] memo=new int[n+1][m+1];
        return check(n,m,memo);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),m=x.nextInt();
		System.out.println(ways(n,m));
	}
}
