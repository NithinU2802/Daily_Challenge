/******************************************************************************

Given an array arr of n integers, count all pairs (arr[i], arr[j]) in it such that
i*arr[i] > j*arr[j] and 0 ≤ i < j < n.

Note: 0-based Indexing is followed.

Example 1:

Input :
n = 4
arr[] = {8, 4, 2, 1}
Output :
2
Explanation:
If we see the array after operations
[0*8, 1*4, 2*2, 3*1] => [0, 4, 4, 3]
Pairs which hold the condition i*arr[i] > j*arr[j] are (4,1) and (2,1), so in total 
2 pairs are available.
Example 2:

Input :
n = 7
arr[] = {5, 0, 10, 2, 4, 1, 6}
Output:
5
Explanation :
Pairs which hold the condition i*arr[i] > j*arr[j] are (10,2), (10,4), (10,1), (2,1) 
and (4,1), so in total 5 pairs are there.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function 
countPairs() which takes the array arr[] and its size n as inputs and returns the required result.

Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(n*log(n))

Constraints:
1 ≤ n ≤ 104
0 ≤ arr[i] ≤ 104

*******************************************************************************/
import java.util.*;

public class CountPairsIndex
{
    
    public static int merge(int[] arr,int s,int m,int e){
        int[] left=Arrays.copyOfRange(arr,s,m+1);
        int[] right=Arrays.copyOfRange(arr,m+1,e+1);
        int i=0,j=0,k=s,res=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j])
                arr[k++]=left[i++];
            else{
                arr[k++]=right[j++];
                res+=(m+1)-(s+i);
            }
        }
        while(i<left.length)
            arr[k++]=left[i++];
        while(j<right.length)
            arr[k++]=right[j++];
        return res;
    }
    
    static int mergeSort(int[] arr,int s,int e){
        int res=0;
        if(s<e){
            int m=(s+e)/2;
            res+=mergeSort(arr,s,m);
            res+=mergeSort(arr,m+1,e);
            res+=merge(arr,s,m,e);
        }
        return res;
    }
    
    static int countPairs(int arr[], int n) 
    {
        for(int i=0;i<n;i++)
            arr[i]*=i;
        return mergeSort(arr,0,n-1);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		    arr[i]=x.nextInt();
		System.out.println(countPairs(arr,n));
	}
}
