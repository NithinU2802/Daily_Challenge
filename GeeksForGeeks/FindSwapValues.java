/******************************************************************************

Given two arrays of integers a[] and b[] of size n and m, the task is to check if 
a pair of values (one value from each array) exists such that swapping the elements
of the pair will make the sum of two arrays equal.

Note: Return 1 if there exists any such pair otherwise return -1.

Example 1:

Input: n = 6, m = 4, a[] = {4, 1, 2, 1, 1, 2}, b[] = (3, 6, 3, 3)
Output: 1
Explanation: Sum of elements in a[] = 11, Sum of elements in b[] = 15, To get same 
sum from both arrays, we can swap following values: 1 from a[] and 3 from b[]
Example 2:

Input: n = 4, m = 4, a[] = {5, 7, 4, 6}, b[] = {1, 2, 3, 8}
Output: 1
Explanation: We can swap 6 from array a[] and 2 from array b[]
Expected Time Complexity: O(mlogm+nlogn).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ n, m ≤ 106
0 <= a[i], b[i] <= 105


*******************************************************************************/
import java.util.*;

public class FindSwapValues
{
    
    static boolean check(long x,long[] b,int s,int e){
        if(s<e){
            int m=(s+e)/2;
            if(x==b[m])
                return true;
            if(b[m]<x)
                return check(x,b,m+1,e);
            if(b[m]>x)
                return check(x,b,s,m-1);
        }
        return false;
    }
    
    static long findSwapValues(long a[], int n, long b[], int m) {
        long sa=0,sb=0;
        for(long i:a)
            sa+=i;
        for(long i:b)
            sb+=i;
        long d=sa-sb;
        if(d%2!=0)
            return -1;
        d/=2;
        Arrays.sort(a);
        Arrays.sort(b);
        for(long i:a)
            if(i-d<0)
                break;
            else if(check(i-d,b,0,b.length-1))
                return 1;
        return -1;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),m=x.nextInt();
		long[] a=new long[n];
		long[] b=new long[m];
		for(int i=0;i<n;i++)
		    a[i]=x.nextLong();
		for(int i=0;i<m;i++)
		    b[i]=x.nextLong();
		System.out.println(findSwapValues(a,n,b,m));
	}
}
