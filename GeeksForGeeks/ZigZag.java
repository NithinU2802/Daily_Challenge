/******************************************************************************

Given an array arr of distinct elements of size n, the task is to rearrange the elements
of the array in a zig-zag fashion so that the converted array should be in the below form: 

arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n]. 

Note: Modify the given arr[] only, If your transformation is correct, the output will be
1 else the output will be 0. 

Examples
Input: n = 7, arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: 1
Explanation:  After modification the array will look like 3 < 7 > 4 < 8 > 2 < 6 > 1, the
checker in the driver code will produce 1.

Input: n = 5, arr[] = {4, 7, 3, 8, 2}
Output: 1
Explanation: After modification the array will look like 4 < 7 > 3 < 8 > 2 hence output
will be 1.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 106
0 <= arri <= 109



*******************************************************************************/

import java.util.*;

public class ZigZag
{
    
    public static void zigZag(int n, int[] arr) {
        Arrays.sort(arr);
        if(n==2)
            return;
        int[] res=new int[n];
        int i=n/2,j=n-1;
        if(n%2==0)
            i--;
        int k=0,t=i;
        while(k<n){
            if(i-1>=0)
             res[k++]=arr[i-1];
            if(k<n && j-1>=0)
                res[k++]=arr[j-1];
            if(k<n)
                res[k++]=arr[i];
            if(k<n)
                res[k++]=arr[j];
            i++;
            j--;
        }
        for(i=0;i<n;i++)
            arr[i]=res[i];
    }
    
    public static boolean isZigZag(int[] a){
        for(int i=1,f=0;i<a.length-1;i++,f^=1)
            if(f==0 && a[i-1]>=a[i])
                return false;
            else if(f==1 && a[i-1]<a[i])
                return false;
        return true;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		zigZag(n,a);
		if(isZigZag(a))
		    System.out.print("1");
		else 
		    System.out.print("0");
	}
}
