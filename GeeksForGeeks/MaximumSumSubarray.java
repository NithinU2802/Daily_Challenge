/******************************************************************************

Given an array of integers Arr of size N and a number K. Return the maximum sum 
of a subarray of size K.

NOTE*: A subarray is a contiguous part of any given array.

Example 1:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.
Example 2:

Input:
N = 4, K = 4
Arr = [100, 200, 300, 400]
Output:
1000
Explanation:
Arr1 + Arr2 + Arr3 + Arr4 =1000,
which is maximum.
Your Task:

You don't need to read input or print anything. Your task is to complete the function
maximumSumSubarray() which takes the integer K, vector Arr with size N, containing the
elements of the array and returns the maximum sum of a subarray of size K.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= Arri <= 105
1 <= K <= N

*******************************************************************************/
import java.util.*;

public class MaximumSumSubarray
{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        long m=0;
        for(int i=0;i<N && i<K;i++)
            m+=Arr.get(i);
        long s=m;
        int j=K;
        for(int i=0;j<N;i++){
            s+=Arr.get(j++);
            s-=Arr.get(i);
            if(s>m)
                m=s;
        }
        return m;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),k=x.nextInt();
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		    a.add(x.nextInt());
		System.out.println(maximumSumSubarray(k,a,n));
	}
}
