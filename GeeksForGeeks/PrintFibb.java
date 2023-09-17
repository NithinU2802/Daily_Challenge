/******************************************************************************

Given a number N, find the first N Fibonacci numbers. The first two number of the
series are 1 and 1.

Example 1:

Input:
N = 5
Output: 1 1 2 3 5
Example 2:

Input:
N = 7
Output: 1 1 2 3 5 8 13
Your Task:
Your task is to complete printFibb() which takes single argument N and returns a 
list of first N Fibonacci numbers.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
Note: This space is used to store and return the answer for printing purpose.

Constraints:
1<= N <=84



*******************************************************************************/
import java.util.*;

class PrintFibb
{
    public static long[] printFibb(int n) 
    {
        if(n==0)
            return new long[n];
        long[] a=new long[n];
        a[0]=1;
        if(n==1)
            return a;
        a[1]=1;
        if(n==2)
            return a;
        int i=2;
        while(i<n){
            a[i]=a[i-1]+a[i-2];
            i++;
        }
        return a;
    }
    
    public static void main(String[] arg){
    Scanner x=new Scanner(System.in);
    int n=x.nextInt();
    for(long i:printFibb(n))
        System.out.print(i+" ");
    }
}
