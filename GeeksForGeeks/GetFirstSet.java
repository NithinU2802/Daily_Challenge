/******************************************************************************

Given an integer N. The task is to return the position of first set bit found from
the right side in the binary representation of the number.
Note: If there is no set bit in the integer N, then return 0 from the function.  

Input: 
N = 18
Output: 
2

Explanation: 
Binary representation of 18 is 010010,the first set bit from the right side is at position 2.


Input: 
N = 12 
Output: 
3 

Explanation: 
Binary representation of  12 is 1100, the first set bit from the right side is at position 3.
Your Task:
The task is to complete the function getFirstSetBit() that takes an integer n as a
parameter and returns the position of first set bit.


Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
0 <= N <= 108


*******************************************************************************/
import java.util.*;

public class GetFirstSet{
    
    public static int getFirstSetBit(int n){
        int c=1;
        while(n>0){
            if((n%2)==1)
                break;
            c++;
            n/=2;
        }
        return c;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	System.out.println(getFirstSetBit(n));
	}
}
