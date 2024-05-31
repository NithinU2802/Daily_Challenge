/******************************************************************************

Given a number n, Your task is to swap the two nibbles and find the resulting number. 

A nibble is a four-bit aggregation, or half an octet. There are two nibbles in a byte.
For example, the decimal number 150 is represented as 10010110 in an 8-bit byte. This 
byte can be divided into two nibbles: 1001 and 0110.

Example 1:

Input: n = 100
Output: 70
Explanation: 100 in binary is 01100100, two nibbles are (0110) and (0100). If we swap 
the two nibbles, we get 01000110 which is 70 in decimal.
Example 2:

Input: n = 129
Output: 24
Explanation: 129 in binary is 10000001, two nibbles are (1000) and (0001). If we swap 
the two nibbles, we get 00011000 which is 24 in decimal.
Your Task:
You don't need to read input or print anything. Your task is to complete the function 
swapNibbles() which takes an integer n as input parameter and returns an integer after
swapping nibbles in the binary representation of n.

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)

Constraints:
0 ≤ n ≤ 255

*******************************************************************************/
import java.util.*;

public class SwapNibbles
{
    
    static int swapNibbles(int n) {
        String r="";
        int t=n,b=1,res=0;
        while(t>0){
            if(t%2==1)
                r+='1';
            else
                r+='0';
            t/=2;
        }
        while(r.length()<8)
            r+='0';
        int h=r.length()/2;
        for(int i=h;i<8;i++){
            if(r.charAt(i)=='1')
                res+=b;
            b*=2;
        }
        for(int i=0;i<h;i++){
            if(r.charAt(i)=='1')
                res+=b;
            b*=2;
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		System.out.println(swapNibbles(n));
	}
}
