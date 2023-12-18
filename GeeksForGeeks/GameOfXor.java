/******************************************************************************

Given an array A of size N. The value of an array is denoted by the bit-wise XOR 
of all elements it contains. Find the bit-wise XOR of the values of all subarrays of A.

Example 1:

Input: 
N = 3 
A = [1,2,3] 
Output: 
2
Explanation:
xor[1] = 1
xor[1, 2] = 3
xor[2, 3] = 1
xor[1, 2, 3] = 0
xor[2] = 2
xor[3] = 3
Result : 1 ^ 3 ^ 1 ^ 0 ^ 2 ^ 3 = 2
Example 2:

Input: 
N = 2
A = [1,2]
Output: 
0
Explanation:
xor[1] = 1
xor[1, 2] = 3
xor[2] = 2
Result : 1 ^ 3 ^ 2 = 0
Your Task:
You don't need to read input or print anything. Your task is to complete the function
gameOfXor() which takes an integer N and array A[] as input parameters and returns the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
0 <= A[i] <= 109

*******************************************************************************/
import java.util.*;

public class GameOfXor
{
    
    static int gameOfXor(int N , int[] A) {
        if(N==1)
            return A[0];
        int r=-1;
        if(N%2==0)
            return 0;
        for(int i=0;i<N;i++)
            if(i%2==0){
                if(r==-1)
                    r=A[i];
                else
                    r^=A[i];
            }
        return r;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(gameOfXor(n,a));
	}
}
