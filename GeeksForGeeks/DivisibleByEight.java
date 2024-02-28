/******************************************************************************

Given a string representation of a decimal number s, check whether it is divisible by 8.

Example 1:

Input:
s = "16"
Output:
1
Explanation:
The given number is divisible by 8,
so the driver code prints 1 as the output.
Example 2:

Input:
s = "54141111648421214584416464555"
Output:
-1
Explanation:
Given Number is not divisible by 8, 
so the driver code prints -1 as the output.
Your Task:
You don't need to read input or print anything.Your task is to complete the function 
divisibleByEight() which takes a string s as the input and returns 1 if the number is
divisible by 8, else it returns -1.

Expected Time Complexity: O(1).
Expected Auxillary Space: O(1).

Constraints:
1 <= Number represented by the string s < 106

*******************************************************************************/
import java.util.*;

public class DivisibleByEight
{
    public static int divisibleByEight(String s){
        int i=s.length()-1,c=3;
        String r="";
        while(i>=0 && c>0){
            r=s.charAt(i)+r;
            i--;
            c--;
        }
        if(Integer.parseInt(r)%8==0)
            return 1;
        return -1;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		System.out.println(divisibleByEight(s));
	}
}
