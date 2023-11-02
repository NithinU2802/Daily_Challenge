/******************************************************************************

You are given an array a, of n elements. Find the minimum index based distance between
two distinct elements of the array, x and y. Return -1, if either x or y does not exist in the array.

Example 1:

Input:
N = 4
A[] = {1,2,3,2}
x = 1, y = 2
Output: 1
Explanation: x = 1 and y = 2. There are
two distances between x and y, which are
1 and 3 out of which the least is 1.
Example 2:

Input:
N = 7
A[] = {86,39,90,67,84,66,62}
x = 42, y = 12
Output: -1
Explanation: x = 42 and y = 12. We return
-1 as x and y don't exist in the array.
Your Task:
Complete the function minDist() which takes the array a, and 3 integers n, x and y
as input parameters and returns the minimum distance between x and y in the array.
Return -1, if either x or y does not exist in the array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 105
0 <= a[i], x, y <= 105
x != y



*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static int minDist(int[] a,int n,int x,int y){
        int b=-1,c=-1,m=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]==x)
                b=i;
            if(a[i]==y)
                c=i;
            if(c!=-1 && b!=-1)
                m=Math.min(m,Math.abs(b-c));
        }
        if(m==Integer.MAX_VALUE)
            return -1;
        return m;
    }
    
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=sc.nextInt();
	int x=sc.nextInt(),y=sc.nextInt();
	System.out.println(minDist(a,n,x,y));
	}
}
