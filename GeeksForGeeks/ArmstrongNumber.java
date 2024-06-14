/******************************************************************************

You are given a 3-digit number n, Find whether it is an Armstrong number or not.

    An Armstrong number of three digits is a number such that the sum of the cubes of its
digits is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371. 

Note: Return "true" if it is an Armstrong number else return "false".

Examples

Input: n = 153
Output: true
Explanation: 153 is an Armstrong number since 13 + 53 + 33 = 153. Hence answer is "true".
Input: n = 372
Output: false
Explanation: 372 is not an Armstrong number since 33 + 73 + 23 = 378. Hence answer is "false".
Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1) 

Constraints:
100 ≤ n <1000 

*******************************************************************************/
import java.util.*;

public class ArmstrongNumber
{
    
    static String armstrongNumber(int n) {
        int s=0,t=n;
        while(t>0){
            s+=(t%10)*(t%10)*(t%10);
            t/=10;
        }
        if(n==s)
            return "true";
        return "false";
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		System.out.println(armstrongNumber(n));
	}
}
