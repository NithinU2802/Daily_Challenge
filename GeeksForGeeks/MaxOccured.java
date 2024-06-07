/******************************************************************************

Given n integer ranges, the task is to return the maximum occurring integer in the
given ranges. If more than one such integer exists, return the smallest one.
The ranges are in two arrays l[] and r[].  l[i] consists of the starting point of 
the range and r[i] consists of the corresponding endpoint of the range & a maxx which
is the maximum value of r[].

For example, consider the following ranges.
l[] = {2, 1, 3}, r[] = {5, 3, 9)
Ranges represented by the above arrays are.
[2, 5] = {2, 3, 4, 5}
[1, 3] = {1, 2, 3}
[3, 9] = {3, 4, 5, 6, 7, 8, 9}
The maximum occurred integer in these ranges is 3.

Examples :

Input: n = 4, l[] = {1,4,3,1}, r[] = {15,8,5,4}, maxx = 15
Output: 4
Explanation: The given ranges are [1,15] [4, 8] [3, 5] [1, 4]. The smallest number
that is most common or appears most times in the ranges is 4.
Input: n = 5, l[] = {1,5,9,13,21}, r[] = {15,8,12,20,30}, maxx = 30
Output: 5
Explanation: The given ranges are [1, 15] [5, 8] [9, 12] [13, 20] [21, 30]. The 
smallest number that is most common or appears most times in the ranges is 5.
Expected Time Complexity: O(n+maxx).
Expected Auxiliary Space: O(maxx), maxx is maximum element in r[]

Constraints:
1 ≤ n ≤ 106
0 ≤ l[i], r[i] ≤ 106

*******************************************************************************/
import java.util.*;

public class MaxOccured
{
    
    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] fq=new int[maxx+1];
        for(int i=0;i<n;i++){
            for(int j=l[i];j<=r[i];j++)
                fq[j]++;
        }
        int res=-1,max=0;
        for(int i=0;i<=maxx;i++)
            if(max<fq[i]){
                res=i;
                max=fq[i];
            }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] l=new int[n];
		int[] r=new int[n];
		for(int i=0;i<n;i++)
		    l[i]=x.nextInt();
		for(int j=0;j<n;j++)
		    r[j]=x.nextInt();
		int maxx=x.nextInt();
		System.out.print(maxOccured(n,l,r,maxx));
	}
}
