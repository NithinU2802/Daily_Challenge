/******************************************************************************

Given a binary representation in the form of a string(s) of a number n, the task is
to find a binary representation of n+1.

Note: Output binary string should not contain leading zeros.

Example 1:

Input: s = "10"
Output: 11
Explanation: "10" is the binary representation of 2 and binary representation of 3 
is "11"
Example 2:

Input: s = "111"
Output: 1000
Explanation: "111" is the binary representation of 7 and binary representation of 8 is 
"1000"
Your Task:  
You don't need to read input or print anything. Complete the function binaryNextNumber()
which takes s as input parameter and returns the string.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n) to store resultant string  

Constraints:
1 <= n <= 105

*******************************************************************************/
import java.util.*;

public class Main
{
    
    static String binaryNextNumber(String s) {
        int d=0;
        while(d<s.length() && s.charAt(d)=='0')
            d++;
        if(d==s.length())
            return "1";
        if(s.charAt(s.length()-1)=='0')
            return s.substring(d,s.length()-1)+"1";
        int r=s.length()-1;
        char[] a=s.toCharArray();
        while(r>=d && s.charAt(r)=='1')
            a[r--]='0';
        if(r>=d)
            a[r]='1';
        else
            return '1'+String.valueOf(a).substring(d);
        return String.valueOf(a).substring(d);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		String s=x.nextLine();
		System.out.println(binaryNextNumber(s));
	}
}
