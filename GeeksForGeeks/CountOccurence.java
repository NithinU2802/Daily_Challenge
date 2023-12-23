/******************************************************************************

Given an array arr of size N and an element k. The task is to find the count of elements 
in the array that appear more than n/k times.

Example 1:

Input:
N = 8
arr = [3,1,2,2,1,2,3,3]
k = 4
Output: 
2
Explanation: 
In the given array, 3 and 2 are the only elements that appears more than n/k times.
Example 2:

Input:
N = 4
arr = [2,3,3,2]
k = 3
Output: 
2
Explanation: In the given array, 3 and 2 are the only elements that appears more
than n/k times. So the count of elements are 2.
Your Task:
The task is to complete the function countOccurence() which returns count of elements
with more than n/k times appearance.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= a[i] <= 109
1 <= k <= N



*******************************************************************************/
import java.util.*;

public class CountOccurence
{
    
    static int countOccurence(int[] arr, int n, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        int res=0;
        for(Map.Entry<Integer,Integer> i:map.entrySet())
            if(i.getValue()>n/k)
                res++;
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		int k=x.nextInt();
		System.out.println(countOccurence(a,n,k));
	}
}
