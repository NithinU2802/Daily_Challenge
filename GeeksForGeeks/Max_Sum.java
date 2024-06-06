/******************************************************************************

Given an integer array(0-based indexing) a of size n. Your task is to return the
maximum value of the sum of i*a[i] for all 0<= i <=n-1, where a[i] is the element
at index i in the array. The only operation allowed is to rotate(clockwise or 
counterclockwise) the array any number of times.

Example 1:

Input: n = 4, a[] = {8, 3, 1, 2}
Output: 29
Explanation: All the configurations possible by rotating the elements are:
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11, so the maximum sum will be 29.
Example 2:

Input: n = 3, a[] = {1, 2, 3}
Output: 8
Explanation: All the configurations possible by rotating the elements are:
1 2 3 here sum is 1*0+2*1+3*2 = 8
3 1 2 here sum is 3*0+1*1+2*2 = 5
2 3 1 here sum is 2*0+3*1+1*2 = 5, so the maximum sum will be 8.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1<=n<=105
1<=a[]<=106

*******************************************************************************/
import java.util.*;

public class Max_Sum
{
    
    static long max_sum(int a[], int n) {
        long max=0,prev=0,sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            prev+=((long)a[i]*i);
        }
        max=prev;
        sum-=a[0];
        long leftOver=0;
        for(int i=1;i<=n;i++){
            long d=prev-sum+(((long)a[i-1])*(n-1))-leftOver;
            if(d>max)
                max=d;
            leftOver+=a[i-1];
            if(i+1<n)
                sum-=a[i];
            else
                sum=0;
            prev=d;
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(max_sum(a,n));
	}
}
