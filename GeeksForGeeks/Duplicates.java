/******************************************************************************

Given an array a of size N which contains elements from 0 to N-1, you need to find 
all the elements occurring more than once in the given array. Return the answer in 
ascending order. If no such element is found, return list containing [-1]. 

Note: The extra space is only for the array to be returned. Try and perform all 
operations within the provided array. 

Example 1:

Input:
N = 4
a[] = {0,3,1,2}
Output: 
-1
Explanation: 
There is no repeating element in the array. Therefore output is -1.
Example 2:

Input:
N = 5
a[] = {2,3,1,2,3}
Output: 
2 3 
Explanation: 
2 and 3 occur more than once in the given array.
Your Task:
Complete the function duplicates() which takes array a[] and n as input as parameters
and returns a list of elements that occur more than once in the given array in a sorted manner. 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= N <= 105
0 <= A[i] <= N-1, for each valid i

*******************************************************************************/
import java.util.*;


public class Main
{
    
    public static ArrayList<Integer> duplicates(int[] arr,int n){
        ArrayList<Integer> r=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int j=i+1,f=0;
            while(j<n && arr[i]==arr[j]){
                i++;
                f=1;
                j++;
            }
            if(f==1)
                r.add(arr[i]);
        }
        if(r.size()==1)
            r.add(-1);
        return r;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	for(int i:duplicates(a,n))
	    System.out.print(i+" ");
	}
}
