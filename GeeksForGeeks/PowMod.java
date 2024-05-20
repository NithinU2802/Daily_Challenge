/******************************************************************************

Implement pow(x, n) % M.
In other words, for a given value of x, n, and M, find  (xn) % M.
 

Example 1:

Input:
x = 3, n = 2, m = 4
Output:
1
Explanation:
32 = 9. 9 % 4 = 1.
Example 2:

Input:
x = 2, n = 6, m = 10
Output:
4
Explanation:
26 = 64. 64 % 10 = 4.

Your Task:
You don't need to read or print anything. Your task is to complete the function 
PowMod() which takes integers x, n, and M as input parameters and returns xn % M.
 

Expected Time Complexity: O(log(n))
Expected Space Complexity: O(1)
 

Constraints:
1 ≤ x, n, M ≤ 109

*******************************************************************************/
import java.util.*;

public class PowMod
{
    
    public static long PowMod(long x, long n, long m)
    {
        if(n==0)
            return 0;
        if(n==1)
            return x%m;
        if(n%2==0)
            return PowMod((x*x)%m,n/2,m);
        return (x*PowMod(x,n-1,m))%m;
    }
    
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long x=sc.nextLong(),n=sc.nextLong(),m=sc.nextLong();
		System.out.print(PowMod(x,n,m));
	}
}
