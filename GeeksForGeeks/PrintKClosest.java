/******************************************************************************

Given a sorted array of unique elements in increasing order, arr[] of n integers,
and a value x. Find the K closest elements to x in arr[].
Keep the following points in mind:

If x is present in the array, then it need not be considered.
If two elements have the same difference as x, the greater element is prioritized.
If sufficient elements are not present on the right side, take elements from the 
left and vice versa.
 
Example 1:

Input:
n = 13
arr[] = {12, 16, 22, 30, 35, 39, 42, 
         45, 48, 50, 53, 55, 56}
k = 4, x = 35
Output: 39 30 42 45
Explanation: 
First closest element to 35 is 39.
Second closest element to 35 is 30.
Third closest element to 35 is 42.
And fourth closest element to 35 is 45.

Example 2:

Input:
n = 5
arr[] = {1, 2, 3, 6, 10}
k = 3, x = 4
Output: 3 6 2
Explanation: 
First closest element is 3.
There are two elements 2 and 6 for which 
the difference with 4 is same i.e. 2.
So first take greatest number 6 
then the lower number 2.

Your Task:
You don't need to read input or print anything. Complete the function printKClosest()
which takes arr[], n, k, and x as input parameters and returns an array of integers 
containing the K closest elements to x in arr[].


Expected Time Complexity: O(log n + k)
Expected Auxiliary Space: O(k)


Constraints:
1 ≤ n ≤ 105
1 ≤ k ≤ n
1 ≤ x ≤ 106
1 ≤ arr[i] ≤ 106

*******************************************************************************/
import java.util.*;

public class PrintKClosest
{
    
    public static int[] printKClosest(int[] arr, int n, int k, int x) {
        int in=-1;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(arr[i]==x){
                in=i;
                break;
            }else if(arr[i]>x){
                in=i;
                break;
            }
        int s=in-1,e=in+1;
        if(in==-1){
            e=n-1;
            s=n-2;
        }else if(arr[in]!=x){
            s=in-1;
            e=in;
        }
        while(s>=0 && e<n && k>0){
            int l=x-arr[s],r=arr[e]-x;
            if(l<r){
                res.add(arr[s]);
                s--;
            }else if(r>l){ 
                res.add(arr[e]);
                e++;
            }else{
                if(arr[s]>arr[e]){
                    res.add(arr[s]);
                    s--;
                }else{
                    res.add(arr[e]);
                    e++;
                }
            }
            k--;
        }
        while(s>=0 && k>0){
            res.add(arr[s]);
            s--;
            k--;
        }
        while(e<n && k>0){
            res.add(arr[e]);
            e++;
            k--;
        }
        int[] r=new int[res.size()];
        for(int i=0;i<res.size();i++)
            r[i]=res.get(i);
        return r;
    }
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		int k=sc.nextInt(),x=sc.nextInt();
		for(int i:printKClosest(arr,n,k,x))
		    System.out.print(i+" ");
	}
}
