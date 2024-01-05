/******************************************************************************

There is a road passing through a city with N plots on both sides of the road. Plots
are arranged in a straight line on either side of the road. Determine the total number
of ways to construct buildings in these plots, ensuring that no two buildings are 
adjacent to each other. Specifically, buildings on opposite sides of the road cannot be adjacent.

Using * to represent a plot and || for the road, the arrangement for N = 3 can be
visualized as follows: * * * || * * *.

Note: As the answer can be very large, print it mod 109+7.

Example 1:

Input: N = 1
Output: 4
Explanation: 
Possible ways for the arrangement are B||*, *||B, B||B, *||*
where B represents a building.
Example 2:

Input: N = 3
Output: 25
Explanation: 
Possible ways for one side are BSS, BSB, SSS, SBS,
SSB where B represents a building and S
represents an empty space. Pairing up with 
possibilities on the other side of the road,
total possible ways are 25.
Your Task:
You don't need to read or print anything. Your task is to complete the function 
TotalWays() which takes N as input parameter and returns the total possible ways
modulo 109 + 7.
 

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)
 

Constraints:
1 <= N <= 100000



*******************************************************************************/
import java.util.*;

public class TotalWays
{
    static int mod=1000000007;
    public static int TotalWays(int N)
    {
        long lst=0,l=0,c=0;
        for(int i=N-1;i>=0;i--){
            c=(1+lst+l)%mod;
            lst=l;
            l=c;
        }
        return (int)(((c+1)*(c+1))%mod);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		System.out.println(TotalWays(n));
	}
}
