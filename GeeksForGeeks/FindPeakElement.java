/******************************************************************************

Given an integer array a[] of size n, find the highest element of the array. The
array will either be strictly increasing or strictly increasing and then strictly
decreasing.

Note: a[i] != a[i+1] 

Example 1:

Input:
11
1 2 3 4 5 6 5 4 3 2 1
Output: 
6
Explanation: 
Highest element of array a[] is 6.
Example 2:

Input:
5
1 2 3 4 5
Output:
5
Explanation: 
Highest element of array a[] is 5.
Your Task:
You don't need to read or print anything. Your task is to complete the function
findPeakElement() which takes integer n, and the array a[] as the input parameters
and returns the highest element of the array.

Expected Time Complexity: O(log(n))
Expected Space Complexity: O(1)

Constraints:
2 <= n <= 106
1 <= a[i] <= 106



*******************************************************************************/
import java.util.*;

public class FindPeakElement
{
    
    public static int findPeakElement(List<Integer> a) {
        int max=0;
        int l=0,r=a.size()-1;
        while(l<r){
            int m=(l+r)/2;
            if(m-1>=0 && m+1<a.size() && a.get(m)>a.get(m-1) && a.get(m)>a.get(m+1))
                return a.get(m);
            else if(a.get(m)<a.get(m+1))
                l=m+1;
            else
                r=m-1;
        }
        return a.get(r);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		List<Integer> a=new ArrayList<>();
		for(int i=0;i<n;i++)
		    a.add(x.nextInt());
		System.out.println(findPeakElement(a));
	}
}
