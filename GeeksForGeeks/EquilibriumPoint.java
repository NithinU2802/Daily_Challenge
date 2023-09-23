/******************************************************************************

    Given an array A of n positive numbers. The task is to find the first equilibrium
    point in an array. Equilibrium point in an array is a position such that the sum
    of elements before it is equal to the sum of elements after it.

Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists. 

Example 1:

Input: 
n = 5 
A[] = {1,3,5,2,2} 
Output: 
3 
Explanation:  
equilibrium point is at position 3 as sum of elements before it (1+3) = sum of elements after it (2+2). 
Example 2:

Input:
n = 1
A[] = {1}
Output: 
1
Explanation:
Since there's only element hence its only the equilibrium point.
Your Task:
The task is to complete the function equilibriumPoint() which takes the array and 
n as input parameters and returns the point of equilibrium. 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 105
1 <= A[i] <= 109



*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static int equilibriumPoint(long[] arr,int n){
        long s=0,c=0,t=0,l=0;
        for(int i=0;i<arr.length;i++)
            s+=arr[i];
        for(int i=0;i<arr.length;i++){
            if(l==s-l-arr[i])
                return i+1;
            l+=arr[i];
        }
        return -1;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	long[] a=new long[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	System.out.println(equilibriumPoint(a,n));
	}
}
