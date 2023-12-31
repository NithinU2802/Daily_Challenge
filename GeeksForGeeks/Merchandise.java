/******************************************************************************

As the clock struck midnight on New Year's Eve, Geek bid farewell to the wasted moments
of 2023, realizing the untapped potential of GFG's Problem of the Day.

His 2024 resolution: Solve POTD every day.

Eager to earn coins for GFG Merchandise, Geek faces new rules:

Earning Coin: Geek can accumulate coins[i] by solving the POTD on the ith day, where 
1 <= coins[i] <= 2024 and the sum of coins <= 2024.
Merchandise Eligibility: To purchase merchandise, the coins earned must be divisible 
by 20 or 24, or precisely equal to 2024.
Geek's resolutions often fades over time. Realistically, he can only commit to active 
participation for N (where N ≤ 366) days. Given the value of N and number of coins associated
with each POTD, can Geek strategically solve some (or all) POTDs to become eligible for 
redeeming merchandise?

Example 1:

Input:
N = 8
coins = [5, 8, 9, 10, 14, 2, 3, 5]

Output: 1

Explanation:
Geek can fulfill the criteria in many ways.
One such way is to solve POTD on 4th and 5th day.
Another way is to solve POTD on 1st, 4th and 8th day.
Example 2:

Input:
N = 5
coins = [1, 2, 3, 4, 5]

Output: 0

Explanation: There is no way Geek can become eligible.
Your Task: 
You don't need to read input or print anything. Complete the function isPossible() which takes n and coins[ ] as input parameters and returns a boolean value.

Expected Time Complexity: O(N*(Sum of coins))
Expected Auxiliary Space: O(N*(Sum of coins))

Constraints:
1 <= N <= 366
1 <= coins[i] <= 2024
1 <= Sum of coins <=  2024

*******************************************************************************/
import java.util.*;

public class Merchandise
{
    
    public static boolean recursion(int in,int[] coins,int a){
        if(a!=0 && (a%24==0 || a%20==0 || a%2024==0))
            return true;
        if(in==coins.length)
            return false;
        if(recursion(in+1,coins,a+coins[in]))
            return true;
        if(recursion(in+1,coins,a))
            return true;
        return false;
    }
    
    public static boolean isPossible(int N, int[] coins) {
       return recursion(0,coins,0);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(isPossible(n,a)?1:0);
	}
}
