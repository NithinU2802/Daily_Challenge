/******************************************************************************

Given a number x, reverse its binary form and return the answer in decimal.

Example 1:

Input:
x = 1
Output:
2147483648 
Explanation:
Binary of 1 in 32 bits representation-
00000000000000000000000000000001
Reversing the binary form we get, 
10000000000000000000000000000000,
whose decimal value is 2147483648.
Example 2:

Input:
x = 5
Output:
2684354560 
Explanation:
Binary of 5 in 32 bits representation-
00000000000000000000000000000101
Reversing the binary form we get, 
10100000000000000000000000000000,
whose decimal value is 2684354560.
Your Task:
You don't need to read input or print anything. Your task is to complete the function 
reversedBits() which takes an Integer x as input and returns the reverse binary form 
of x in decimal form.

Expected Time Complexity: O(log (x))
Expected Auxiliary Space: O(1)

Constraints:
0  <=  x  <  232



*******************************************************************************/
import java.util.*;

public class ReverseBits
{
    
    static Long reversedBits(Long x) {
       Long res=0L,b=2147483648L;
       String r="";
       while(x>0){
           if(x%2!=0)
                r+='1';
            else
                r+='0';
            x/=2;
       }
       for(int i=0;i<r.length();i++){
           if(r.charAt(i)=='1')
                res+=b;
            b/=2;
       }
       return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		Long n=x.nextLong();
		System.out.println(reversedBits(n));
	}
}
