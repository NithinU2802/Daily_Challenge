/******************************************************************************

Given an array of strings arr[] of length n representing non-negative integers, 
arrange them in a manner, such that, after concatanating them in order, it results
in the largest possible number. Since the result may be very large, return it as a string.

Example 1:

Input: 
n = 5
arr[] =  {"3", "30", "34", "5", "9"}
Output: "9534330"
Explanation: 
Given numbers are  {"3", "30", "34", "5", "9"}, 
the arrangement "9534330" gives the largest value.
Example 2:

Input: 
n = 4
arr[] =  {"54", "546", "548", "60"}
Output: "6054854654"
Explanation: 
Given numbers are {"54", "546", "548", "60"}, the 
arrangement "6054854654" gives the largest value.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function 
printLargest() which takes the array of strings arr[] as a parameter and returns a 
string denoting the answer.

Expected Time Complexity: O(n*log(n) ).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ n ≤ 105
0 ≤ arr[i] ≤ 1018
Sum of all the elements of the array is greater than 0.

*******************************************************************************/
import java.util.*;

public class PrintLargest
{
    
    static String printLargest(int n, String[] a) {
        mergeSort(a, 0, a.length - 1);
        StringBuilder result = new StringBuilder();
        for (String s : a) {
            result.append(s);
        }
        return result.toString();
    }
    
    static void mergeSort(String[] a, int low, int high) {
        if (low < high) {
            int mid = (low+high)/ 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    
    static void merge(String[] a, int low, int mid, int high) {
        String[] temp = new String[a.length];

        for (int i = low; i <= high; i++) 
            temp[i] = a[i]; 
            
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high)
            if (compare(temp[i],temp[j])> 0)
                a[k++] = temp[i++];
            else
                a[k++] = temp[j++];
        while (i <= mid)
            a[k++] = temp[i++];
    }
    
    static int compare(String str1, String str2) {
        String a = str1 + str2;
        String b = str2 + str1;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i))
                return 1;
            else if (a.charAt(i) < b.charAt(i))
                return -1;
        }
        return 0;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		x.nextLine();
		String[] a=new String[n];
		for(int i=0;i<n;i++)
		    a[i]=x.next();
	    System.out.println(printLargest(n,a));
	}
}
