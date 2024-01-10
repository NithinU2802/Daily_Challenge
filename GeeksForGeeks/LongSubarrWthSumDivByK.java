/******************************************************************************

Given an array arr containing N integers and a positive integer K, find the length 
of the longest sub array with sum of the elements divisible by the given value K.

Example 1:

Input:
N = 6, K = 3
arr[] = {2, 7, 6, 1, 4, 5}
Output: 
4
Explanation:
The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
Example 2:

Input:
N = 7, K = 3
arr[] = {-2, 2, -5, 12, -11, -1, 7}
Output: 
5
Explanation:
The subarray is {2,-5,12,-11,-1} with sum -3, which is divisible by 3.
Your Task:
The input is already taken care of by the driver code. You only need to complete 
the function longSubarrWthSumDivByK() that takes an array arr, sizeOfArray n and a
positive integer K, and returns the length of the longest subarray which has sum divisible by K. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= K <= 109
-109 <= A[i] <= 109 

*******************************************************************************/
import java.util.*;

public class Main
{
    static int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        int res=-1,r=0;
        for(int i=0;i<n;i++)
            r+=a[i];
        for(int i=0;i<n;i++){
            int s=r,c=n-i;
            for(int j=n-1;j>=i;j--){
                if(s%k==0 && res<c){
                    res=c;
                    break;
                }else if(res!=-1 && res>c)
                    break;
                c--;
                s-=a[j];
            }
            r-=a[i];
        }
        return res==-1?0:res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),k=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(longSubarrWthSumDivByK(a,n,k));
	}
}
