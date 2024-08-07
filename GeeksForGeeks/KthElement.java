/******************************************************************************

    Given two sorted arrays arr1 and arr2 and an element k. The task is to find the 
element that would be at the kth position of the combined sorted array.

Examples :

Input: k = 5, arr1[] = [2, 3, 6, 7, 9], arr2[] = [1, 4, 8, 10]
Output: 6
Explanation: The final combined sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10. The
5th element of this array is 6.

Input: k = 7, arr1[] = [100, 112, 256, 349, 770], arr2[] = [72, 86, 113, 119, 265, 445, 892]
Output: 256
Explanation: Combined sorted array is - 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 
770, 892. 7th element of this array is 256.

Expected Time Complexity: O(log(n) + log(m))
Expected Auxiliary Space: O(log (n))

Constraints:
1 <= k<= arr1.size()+arr2.size()
1 <= arr1.size(), arr2.size() <= 106
0 <= arr1[i], arr2[i] < 108

*******************************************************************************/
import java.util.*;

public class KthElement
{
    
    public static long kthElement(int k, int arr1[], int arr2[]) {
        int i=0,j=0,c=0;
        while(c<k-1){
            if(i>=arr1.length)
                j++;
            else if(j>=arr2.length)
                i++;
            else if(arr1[i]<=arr2[j])
                i++;
            else
                j++;
            c++;
        }
        if(i>=arr1.length)
            return arr2[j];
        if(j>=arr2.length)
            return arr1[i];
        return Math.min(arr1[i],arr2[j]);
    }
    
	public static void main(String[] args) {
	    int k=5;
	    int[] arr1={2, 3, 6, 7, 9};
	    int[] arr2={1, 4, 8, 10};
		System.out.println(kthElement(k,arr1,arr2));
	}
}
