/******************************************************************************

Given an array of integers arr, the length of the array n, and an integer k, find all 
the unique combinations in arr where the sum of the combination is equal to k. Each 
number can only be used once in a combination.
Return the combinations in the lexicographically sorted order, where each combination 
is in non-decreasing order.

Example 1:

Input: 
n = 5, k = 7
arr[] = { 1, 2, 3, 3, 5 }
Output:
{ { 1, 3, 3 }, { 2, 5 } }
Explanation:
1 + 3 + 3 = 7
2 + 5 = 7
Example 2:

Input:
n = 6, k = 30
arr[] = { 5, 10, 15, 20, 25, 30 }
Output:
{ { 5, 10, 15 }, { 5, 25 }, { 10, 20 }, { 30 } }
Explanation:
5 + 10 + 15 = 30
5 + 25 = 30
10 + 20 = 30
Your Task:
You don't need to read input or print anything. Your task is to complete the function 
CombinationSum2() which takes arr[],n, and k as input parameters and returns all the 
unique combinations.
 

Constraints:
1 <= n <= 100
1 <= arr[i] <= 50
1 <= k <= 30

let p = number of elements, at maximum, can sum up to the given value k.

Expected Time Complexity: O(2min(n,p))
Expected Auxiliary Space: O(n)

*******************************************************************************/
import java.util.*;

public class CombinationSum
{
    
    public static void check(int in,int[] arr,int sum,List<List<Integer>> res,List<Integer> a){
        if(sum==0){
            res.add(new ArrayList<>(a));
            return;
        }
        if(sum<0)
            return;
        for(int i=in;i<arr.length;i++){
            if(i!=in && arr[i]==arr[i-1])
                continue;
            a.add(arr[i]);
            check(i+1,arr,sum-arr[i],res,a);
            a.remove(a.size()-1);
        }
    }
    
    public static List<List<Integer>> CombinationSum2(int[] arr,int k){
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        check(0,arr,k,res,new ArrayList<>());
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),k=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		for(List<Integer> list:CombinationSum2(a,k)){
		    for(int i:list)
		        System.out.print(i+" ");
		    System.out.println();
		}
	}
}
