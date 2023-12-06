/******************************************************************************

Given two integers L, R, and digit X. Find the number of occurrences of X in all 
the numbers in the range (L, R) excluding L and R.

Example 1:

Input:
L=10, R=19, X=1
Output:
9
Explanation:
There are 9 1s (11, 12, 13, 14, 15, 16, 17, 18) in the numbers in the range (10,19).
Example 2:

Input:
L=18, R=81, X=9
Output:
7
Explanation:
There are 7 occurrences of the digit 9 in the numbers in the range (18,81).
Your Task:
You don't need to read input or print anything. Your task is to complete the function
countX() which takes three integers L, R, and X as input parameters and returns the 
number of occurrences of X in the numbers in the range(L, R).

Expected Time Complexity:O(RLogR)
Expected Auxillary Space:O(1)

Constraints:
1 <= L< R <= 105
0 <= X <= 9 

*******************************************************************************/
import java.util.*;

public class CountX
{
    
    public static int countX(int L,int R,int X){
        int res=0;
        for(int i=L+1;i<R;i++){
            int t=i;
            while(t>0){
                if(t%10==X)
                    res++;
                t/=10;
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int L=x.nextInt(),R=x.nextInt(),X=x.nextInt();
		System.out.println(countX(L,R,X));
	}
}
