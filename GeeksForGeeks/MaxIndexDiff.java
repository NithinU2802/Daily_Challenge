/******************************************************************************

Given an array a of n positive integers. The task is to find the maximum of j - i
subjected to the constraint of a[i] < a[j] and i < j.

Example 1:

Input:
n = 2
a[] = {1, 10}
Output:
1
Explanation:
a[0] < a[1] so (j-i) is 1-0 = 1.
Example 2:

Input:
n = 9
a[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array a[1] < a[7] satisfying the required condition(a[i] < a[j]) thus 
giving the maximum difference of j - i which is 6(7-1).
Your Task:
The task is to complete the function maxIndexDiff() which finds and returns maximum
index difference. Printing the output will be handled by driver code. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ n ≤ 106
0 ≤ a[i] ≤ 109

*******************************************************************************/
import java.util.*;

public class MaxIndexDiff
{
    static int maxIndexDiff(int a[], int n) { 
        Stack<Integer> s=new Stack<>();
        s.add(n-1);
        for(int i=n-2;i>=0;i--)
            if(a[i]>a[s.peek()])
                s.push(i);
        int i=0,res=0;
        while(!s.isEmpty() && i<n){
            if(a[s.peek()]>=a[i])
                res=Math.max(res,s.pop()-i);
            else
                i++;
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(maxIndexDiff(a,n));
	}
}
