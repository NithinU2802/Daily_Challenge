/******************************************************************************

Given an array of n integers. Find the minimum non-negative number to be inserted 
in array, so that sum of all elements of array becomes prime.

Example 1:

Input:
N=5
arr = {2, 4, 6, 8, 12}
Output:  
5
Explanation: 
The sum of the array is 32 ,we can add 5 to this to make it 37 which is a prime number.
Example 2:

Input:
N=3
arr = {1, 5, 7}
Output:  
0 
Explanation: 
The sum of the array is 13 which is already prime. 
Your Task:
You don't need to read input or print anything. Your task is to complete the function 
minNumber() that takes array arr and integer N as input parameters and returns the minimum 
positive number to be inserted in the array so as to make it's sum a prime number.

Expected Time Complexity: O(N log(log N))
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105
1 ≤ sum of all elements ≤ 106



*******************************************************************************/
import java.util.*;

public class MinNumber
{
    
    public static boolean isPrime(int a){
        for(int i=2;i<a/2;i++)
            if(a%i==0)
                return false;
        return true;
    }
    
    public static int minNumber(int[] a,int n){
        int s=0,res=0;
        for(int i: a)
            s+=i;
        if(s==1)
            return s;
        if(s%2==0){
            s++;
            res++;
        }
        while(!isPrime(s)){
            res+=2;
            s+=2;
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(minNumber(a,n));
	}
}
