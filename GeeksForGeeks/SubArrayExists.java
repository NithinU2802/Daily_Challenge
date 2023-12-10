/******************************************************************************

Given an array of integers. Find if there is a subarray (of size at-least one) with
0 sum. You just need to return true/false depending upon whether there is a subarray
present with 0-sum or not. Printing will be taken care by the driver code.

Example 1:

Input:
n = 5
arr = {4,2,-3,1,6}
Output: 
Yes
Explanation: 
2, -3, 1 is the subarray with sum 0.
Example 2:

Input:
n = 5
arr = {4,2,0,1,6}
Output: 
Yes
Explanation: 
0 is one of the element in the array so there exist a subarray with sum 0.
Your Task:
You only need to complete the function subArrayExists() that takes array and n as 
parameters and returns true or false.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 104
-105 <= a[i] <= 105

*******************************************************************************/
import java.util.*;

public class SubArrayExists
{
    public static boolean subArrayExists(int[] arr,int n){
        for(int i=0;i<n;i++){
            int s=0;
            for(int j=i;j<n;j++){
                s+=arr[j];
                if(s==0)
                    return true;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		    arr[i]=x.nextInt();
		if(subArrayExists(arr,n))
		    System.out.println("Yes");
		else
		    System.out.println("No");
	}
}
