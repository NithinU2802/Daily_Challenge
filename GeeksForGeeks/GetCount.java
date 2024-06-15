/******************************************************************************

    There is a standard numeric keypad on a mobile phone. You can only press the current
button or buttons that are directly up, left, right, or down from it (for ex if you 
press 5, then pressing 2, 4, 6 & 8 are allowed). Diagonal movements and pressing the
bottom row corner buttons (* and #) are prohibited.



Given a number n, find the number of possible unique sequences of length n that you can 
create by pressing buttons. You can start from any digit.

Examples

Input: n = 1
Output: 10
Explanation: Number of possible numbers are 10 (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)  

Input: n = 2
Output: 36
Explanation: Possible numbers: 00, 08, 11, 12, 14, 22, 21, 23, 25 and so on. If we start
with 0, valid numbers will be 00, 08 (count: 2). If we start with 1, valid numbers will 
be 11, 12, 14 (count: 3). If we start with 2, valid numbers  will be 22, 21, 23,25 (count: 4).
If we start with 3, valid numbers will be 33, 32, 36 (count: 3). If we start with 4, valid
numbers will be 44,41,45,47 (count: 4). If we start with 5, valid numbers will be 55,54,52,
56,58 (count: 5) and so on.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 25



*******************************************************************************/
import java.util.*;

public class GetCount
{
    
    public static long getCount(int n) {
        long res=0;
        int[][] moves={{0,8},{1,2,4},{2,1,3,5},{3,2,6},
            {4,1,5,7},{5,2,4,6,8},{6,3,5,9},
            {7,4,8},{8,5,0,7,9},{6,8,9}
        };
        long[][] dp=new long[n+1][10];
        Arrays.fill(dp[1],1);
        for(int i=2;i<=n;i++)
            for(int j=0;j<10;j++)
                for(int k:moves[j])
                    dp[i][j]+=dp[i-1][k];
        for(long i:dp[n])
            res+=i;
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		System.out.println(getCount(n));
	}
}
