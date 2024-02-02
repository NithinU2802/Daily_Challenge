/******************************************************************************

Given a string, s, the objective is to convert it into integer format without utilizing
any built-in functions. If the conversion is not feasible, the function should return -1.

Note: Conversion is feasible only if all characters in the string are numeric or if its
first character is '-' and rest are numeric.

Example 1:

Input:
s = "-123"
Output: 
-123
Explanation:
It is possible to convert -123 into an integer 
and is so returned in the form of an integer
Example 2:

Input:
s = "21a"
Output: 
-1
Explanation: 
The output is -1 as, due to the inclusion of 'a',
the given string cannot be converted to an integer.
Your Task:
You do not have to take any input or print anything. Complete the function atoi()
which takes a string s as an input parameter and returns an integer value representing
the given string. If the conversion is not feasible, the function should return -1.

|s| = length of string str.
Expected Time Complexity: O( |s| ), 
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |s| ≤ 10

*******************************************************************************/
import java.util.*;

public class Atoi
{
    static int atoi(String s) {
        int f=0;
	    if(s.charAt(0)=='-'){
	        f=1;
	        s=s.substring(1,s.length());
	    }
	    for(int i=0;i<s.length();i++)
	        if(!Character.isDigit(s.charAt(i)))
	            return -1;
	    int res=Integer.parseInt(s);
	    if(f==1)
	        return res*-1;
	    return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		System.out.println(atoi(s));
	}
}
