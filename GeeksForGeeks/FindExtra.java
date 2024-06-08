/******************************************************************************

    You have given two sorted arrays arr1[] & arr2[] of distinct elements. The first 
array has one element extra added in between. Return the index of the extra element.

Note: 0-based indexing is followed.

Examples

Input: n = 7, arr1[] = {2,4,6,8,9,10,12}, arr2[] = {2,4,6,8,10,12}
Output: 4
Explanation: In the first array, 9 is extra added and it's index is 4.
Input: n = 6, arr1[] = {3,5,7,8,11,13}, arr2[] = {3,5,7,11,13}
Output: 3
Explanation: In the first array, 8 is extra and it's index is 3.
Expected Time Complexity: O(log n).
Expected Auxiliary Space: O(1).

Constraints:
1<=n<=105
1<=arr1[i],arr2[i]<=106

*******************************************************************************/
import java.util.*;

public class FindExtra
{
    
    public static int findExtra(int n, int arr1[], int arr2[]) {
        int i=0,j=0;
        while(i<n && j<arr2.length && arr1[i]==arr2[j]){
            i++;
            j++;
        }
        return i;
    }
    
	public static void main(String[] args) {
	    Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		int[] b=new int[n-1];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		for(int i=0;i<n-1;i++)
		    b[i]=x.nextInt();
		System.out.println(findExtra(n,a,b));
	}
}
