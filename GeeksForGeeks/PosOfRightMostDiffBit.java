/******************************************************************************

    Given two numbers M and N. The task is to find the position of the rightmost 
different bit in the binary representation of numbers. If both M and N are the same 
then return -1 in this case.

Example 1: 

Input: 
M = 11, N = 9
Output: 
2
Explanation: 
Binary representation of the given numbers are: 1011 and 1001, 2nd bit from right 
is different.
Example 2:

Input: 
M = 52, N = 4
Output: 
5
Explanation: 
Binary representation of the given numbers are: 110100 and 0100, 5th-bit from right 
is different.
User Task:
The task is to complete the function posOfRightMostDiffBit() which takes two arguments
M and N and returns the position of first different bits in M and N from right. If both
m and n are the same then return -1 in this case.

Expected Time Complexity: O(max(log M, log N)).
Expected Auxiliary Space: O(1).

Constraints:
0 <= M, N <= 109

*******************************************************************************/
import java.util.*;

public class PosOfRightMostDiffBit
{
    
    public static String bin(int a){
        String s="";
        while(a>0){
            if(a%2==0)
                s='0'+s;
            else
                s='1'+s;
            a/=2;
        }
        return s;
    }
    
    public static int posOfRightMostDiffBit(int m, int n)
    {
            
        String a=bin(m),b=bin(n);    
        int i=a.length()-1,j=b.length()-1,c=0;
        while(i<j){
            a='0'+a;
            i++;
        }
        while(j<i){
            b='0'+b;
            j++;
        }
        while(i>=0 && j>=0){
            if(a.charAt(i)!=b.charAt(j))
                return c+1;
            c++;
            i--;
            j--;
        }
        return -1;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int a=x.nextInt(),b=x.nextInt();
		System.out.println(posOfRightMostDiffBit(a,b));
	}
}
