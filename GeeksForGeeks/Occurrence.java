/******************************************************************************

Given a sorted array arr containing n elements with possibly duplicate is to find
indexes of first elements, the task is to find the first and last occurrences of 
an element x in the given array.
Note: If the number x is not found in the array then return both the indices as -1.


Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  
2 5
Explanation: 
First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5. 
Example 2:

Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  
6 6
Explanation: 
First and last occurrence of 7 is at index 6.
Your Task:
Since, this is a function problem. You don't need to take any input, as it is 
already accomplished by the driver code. You just need to complete the function
find() that takes array arr, integer n and integer x as parameters and returns 
the required answer.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 106
1 ≤ arr[i],x ≤ 109

*******************************************************************************/
import java.util.*;

class Main
{
    static ArrayList<Integer> find(int arr[], int n, int x)
    {
    ArrayList<Integer> res=new ArrayList<Integer>();
    for(int i=0;i<arr.length;i++)
        if(x==arr[i]){
            res.add(i);
            break;
        }
    for(int i=arr.length-1;i>=0;i--)
        if(x==arr[i]){
            res.add(i);
            break;
        }
    while(res.size()<2)
        res.add(-1);
    return res;
    }
    
    public static void main(String[] arg){
    Scanner x=new Scanner(System.in);
    int n=x.nextInt(),k=x.nextInt();
    int[] a=new int[n];
    for(int i=0;i<n;i++)
        a[i]=x.nextInt();
    for(int i:find(a,n,k))
        System.out.print(i+" ");
    }
}
