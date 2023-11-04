/******************************************************************************

Given a sorted array containing only 0s and 1s, find the transition point, i.e., the
first index where 1 was observed, and before that, only 0 was observed.

Example 1:

Input:
N = 5
arr[] = {0,0,0,1,1}
Output: 3
Explanation: index 3 is the transition 
point where 1 begins.
Example 2:

Input:
N = 4
arr[] = {0,0,0,0}
Output: -1
Explanation: Since, there is no "1",
the answer is -1.
Your Task:
You don't need to read input or print anything. The task is to complete the function
transitionPoint() that takes array arr and N as input parameters and returns the 0-based
index of the position where 0 ends and 1 begins. If array does not have any 1, return -1.
If array does not have any 0, return 0.

Expected Time Complexity: O(Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
0 ≤ arr[i] ≤ 1

*******************************************************************************/ 
import java.util.*;

public class TransitionPoint
{
    
    public static int transitionPoint(int[] a,int n){
        int i=0;
        while(i<n && a[i]==0)
            i++;
        if(i==n)
            return -1;
        return i;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	 System.out.println(transitionPoint(a,n));
	}
}
