/******************************************************************************

Given an array arr[] of size n. Calculate the sum of Bitwise ANDs ie: calculate sum
of arr[i] & arr[j] for all the pairs in the given array arr[] where i < j.

Example 1:

Input:
n = 3
arr = {5, 10, 15}
Output:
15
Explanation:
The bitwise Ands of all pairs where i<j are (5&10) = 0, (5&15) = 5 and (10&15) = 10.
Therefore, the total sum = (0+5+10) = 15.
Example 2:

Input:
n = 4
arr = {10, 20, 30, 40}
Output:
46
Explanation:
The sum of bitwise Ands 
of all pairs = (0+10+8+20+0+8) = 46.
Your Task:
You don't need to read input or print anything.Your Task is to complete the function
pairAndSum() which takes an Integer n and an array arr[]  of size n as input parameters
and returns the sum of bitwise Ands of all pairs.

Expected Time Complexity:O(n)
Expected Auxillary Space:O(1)

Constraints:
1 <= n <= 105
1 <= arr[i] <= 108



*******************************************************************************/
import java.util.*;

public class PairAndSum
{
    
    static long pairAndSum(int n, long arr[]) {
        long res=0,p=1,c=0;
        for(int i=0;i<32;i++){
            c=0;
            for(int j=0;j<arr.length;j++)
                if((arr[j]&(1<<i))>0)
                    c++;
            res+=Math.pow(2,i)*(c*(c-1)/2);
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		long[] arr=new long[n];
		for(int i=0;i<n;i++)
		    arr[i]=x.nextLong();
		System.out.println(pairAndSum(n,arr));
	}
}
