/******************************************************************************

Given two sorted arrays of size n and m respectively, find their union. The Union
of two arrays can be defined as the common and distinct elements in the two arrays. 

Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 5, arr2 [] = {1, 2, 3, 6, 7}
Output: 
1 2 3 4 5 6 7
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Example 2:

Input: 
n = 5, arr1[] = {2, 2, 3, 4, 5}  
m = 5, arr2[] = {1, 1, 2, 3, 4}
Output: 
1 2 3 4 5
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5.
Example 3:

Input:
n = 5, arr1[] = {1, 1, 1, 1, 1}
m = 5, arr2[] = {2, 2, 2, 2, 2}
Output: 
1 2
Explanation: 
Distinct elements including both the arrays are: 1 2.
Your Task: 
You do not need to read input or print anything. Complete the function findUnion() 
that takes two arrays arr1[], arr2[], and their size n and m as input parameters and
returns a list containing the union of the two arrays.

Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).

Constraints:
1 <= n, m <= 105
-109 <= arr1[i], arr2[i] <= 109

*******************************************************************************/
import java.util.*;

public class FindUnion
{
    
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> res=new ArrayList<>();
        int i=0,j=0,in;
        while(i<n && j<m){
            in=res.size()-1;
            if(arr1[i]<=arr2[j]){
                if(res.size()==0 || res.get(in)!=arr1[i])
                    res.add(arr1[i]);
                i++;
            }else{
                if(res.size()==0 || res.get(in)!=arr2[j])
                    res.add(arr2[j]);
                j++;
            }
        }
        while(i<n){
            if(res.get(res.size()-1)!=arr1[i])
                res.add(arr1[i]);
            i++;
        }
        while(j<m){
            if(res.get(res.size()-1)!=arr2[j])
                res.add(arr2[j]);
            j++;
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),m=x.nextInt();
		int[] arr1=new int[n];
		int[] arr2=new int[m];
		for(int i=0;i<n;i++)
		    arr1[i]=x.nextInt();
		for(int i=0;i<m;i++)
		    arr2[i]=x.nextInt();
		for(int i:findUnion(arr1,arr2,n,m))
		    System.out.print(i+" ");
	}
}
