/******************************************************************************

Given a non-empty array nums[] of integers of length N, find the top k elements which
have the highest frequency in the array. If two numbers have same frequencies, then the
larger number should be given more preference.

Example 1:

Input:
N = 6
nums = {1,1,1,2,2,3}
k = 2
Output: {1, 2}
Example 2:

Input:
N = 8
nums = {1,1,2,2,3,3,3,4}
k = 2
Output: {3, 2}
Explanation: Elements 1 and 2 have the
same frequency ie. 2. Therefore, in this
case, the answer includes the element 2
as 2 > 1.
User Task:
You don't have to read or print anything. You will have to complete the function topK()
that takes an array nums[] and integer k as input and returns a list of top k most frequent
elements. If any two elements have same frequencies, then give more preference to the larger elemet.

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space : O(N)

Constraints:
1 <= N <= 105
1<= nums[i] <=105
1 <= k <= N



*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static int[] topK(int[] a,int k){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int[] r=new int[k];
        int index=0;
        int[] arr=new int[k];
        for(int i=0;i<a.length;i++)
            if(!map.containsKey(a[i]))
                map.put(a[i],1);
            else
                map.put(a[i],map.get(a[i])+1);
        List<Map.Entry<Integer,Integer>> list=new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,(l1,l2)->{
        int i=l2.getValue().compareTo(l1.getValue()); return i==0?l2.getKey().compareTo(l1.getKey()):i; });
        for(Map.Entry<Integer,Integer> i:list){ 
            r[index++]=i.getKey();
            if(index==k)
                break;
        }
        return r;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	int k=x.nextInt();
	for(int i:topK(a,k))
	    System.out.print(i+" ");
	}
}
