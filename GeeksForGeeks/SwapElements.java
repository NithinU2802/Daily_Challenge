/******************************************************************************

Given an array arr of n positive integers. The task is to swap every ith element 
of the array with (i+2)th element.

Example 1:

Input:
n = 3
arr[] = 1 2 3
Output:
3 2 1
Explanation:
Swapping 1 and 3, makes the array 3 2 1. There is only one swap possible in this array.
Example 2:

Input:
n = 5
arr[] = 1 2 3 4 5
Output:
3 4 5 2 1
Explanation:
Swapping 1 and 3, makes the array 3 2 1 4 5.
Now, swapping 2 and 4, makes the array 3 4 1 2 5. 
Again,swapping 1 and 5, makes the array 3 4 5 2 1.
Your Task:
Your task is to complete the function swapElements(), which should swap each ith
element with (i+2)th element.

Expected Time Complexity: O(n)
Expected Auxilary Space: O(1)

Constraints:
1 <= n <= 106
0 <= arri <= 109

*******************************************************************************/
import java.util.*;

public class SwapElements
{
    
    public static void swapElements(int[] arr, int n)
    {
        for(int i=0;i<n-2;i++){
            arr[i]^=arr[i+2];
            arr[i+2]^=arr[i];
            arr[i]^=arr[i+2];
        }
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		swapElements(a,n);
		for(int i:a)
		    System.out.print(i+" ");
	}
}
