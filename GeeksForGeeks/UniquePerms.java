/******************************************************************************

Given an array arr[] of length n. Find all possible unique permutations of the 
array in sorted order. A sequence A is greater than sequence B if there is an index
i for which Aj = Bj for all j<i and Ai > Bi.

Example 1:

Input: 
n = 3
arr[] = {1, 2, 1}
Output: 
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.
Example 2:

Input: 
n = 2
arr[] = {4, 5}
Output: 
Only possible 2 unique permutations are
4 5
5 4
Your Task:
You don't need to read input or print anything. You only need to complete the 
function uniquePerms() that takes an integer n, and an array arr of size n as 
input and returns a sorted list of lists containing all unique permutations of the array.

Expected Time Complexity:  O(n*n!)
Expected Auxilliary Space: O(n*n!)

Constraints:
1 ≤ n ≤ 9
1 ≤ arri ≤ 10

*******************************************************************************/
import java.util.*;

public class UniquePerms
{
    
    static void permute(HashSet<ArrayList<Integer>> res,ArrayList<Integer> arr,int f,int l){
        if(f==l+1){
            if(!res.contains(new ArrayList<>(arr)))
                res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=f;i<=l;i++){ 
            Collections.swap(arr,i,f);
            permute(res,arr,f+1,l);
            Collections.swap(arr,i,f);
        }
    }
    
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        permute(set,arr,0,n-1);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(set);
        Collections.sort(res,(a,b)->{
            int s = a.size();
            for(int i=0;i<s;i++){
                if(a.get(i)!=b.get(i))
                    return Integer.compare(a.get(i),b.get(i));
            }
            return Integer.compare(a.get(0),b.get(0));
            
        });
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		    list.add(x.nextInt());
		for(ArrayList<Integer> lst: uniquePerms(list,n)){
		    for(int i:lst)
		        System.out.print(i+" ");
		    System.out.println();
	    }
	}
}
