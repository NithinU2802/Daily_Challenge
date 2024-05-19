/******************************************************************************

Given a sorted array arr[] of positive integers. The task is to find the closest 
value in the array to the given number k. The array may contain duplicate values.

Note: If the difference with k is the same for two values in the array return the 
greater value.

Example 1:

Input: 
n = 4
k = 4
arr[] = {1, 3, 6, 7}
Output: 
3
Explanation:
We have array arr={1, 3, 6, 7} and target is 4. If we look at the absolute difference
of target with every element of the array we will get { |1-4|, |3-4|, |6-4|, |7-4| } 
= {3, 1, 2, 3}. So, the closest number is 3.
Example 2:

Input:
n = 7
k = 4
arr[] = {1, 2, 3, 5, 6, 8, 9}
Output:
5
Explanation:
The absolute difference of 4 is 1 from both 3 and 5. According to the question, we have
to return greater value, which is 5.
Your Task:
This is a function problem. The input is already taken care of by the driver code. You
only need to complete the function findClosest() that takes integers n and k and sorted 
array arr[] of size n as input parameters and return the closest number in the array to k. 

Expected Time Complexity: O(log(n)).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ n ≤ 106
1 ≤ k ≤ 109
1 ≤ arr[i] ≤ 109



*******************************************************************************/
import java.util.*;

public class FindClosest
{
    
    public static int findClosest(int n, int k, int[] arr) {
        int i=0;
        while(i<n && arr[i]<k)
            i++;
        int d=Integer.MAX_VALUE,res=k;
        if(i-1>=0 && Math.abs(arr[i-1]-k)<d){
            d=Math.abs(arr[i-1]-k);
            res=arr[i-1];
        }
        if(i<n && arr[i]==k)
            return k;
        if(i<n && Math.abs(arr[i]-k)<=d){
            d=Math.abs(arr[i]-k);
            res=arr[i];
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int k=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(findClosest(n,k,a));
	}
}
