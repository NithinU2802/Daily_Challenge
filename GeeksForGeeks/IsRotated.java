/******************************************************************************

Given two strings a and b. The task is to find if the string 'b' can be obtained 
by rotating (in any direction) string 'a' by exactly 2 places.

Example 1:

Input:
a = amazon
b = azonam
Output: 
1
Explanation: 
amazon can be rotated anti-clockwise by two places, which will make it as azonam.
Example 2:

Input:
a = geeksforgeeks
b = geeksgeeksfor
Output: 
0
Explanation: 
If we rotate geeksforgeeks by two place in any direction, we won't get geeksgeeksfor.
Your Task:
The task is to complete the function isRotated() which takes two strings as input 
parameters and checks if given strings can be formed by rotations. The function 
returns true if string 1 can be obtained by rotating string 2 by two places, else 
it returns false.

Expected Time Complexity: O(N).
Expected Auxilary Complexity: O(N).
Challenge: Try doing it in O(1) space complexity.

Constraints:
1 ≤ length of a, b ≤ 105



*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static boolean isRotated(String str1,String str2){
        int n=str1.length();
        if(str1.length()!=str2.length())
            return false;
        if(str1.charAt(0)==str2.charAt(n-2) && str1.charAt(1)==str2.charAt(n-1)){
            int f=0;
            for(int i=2;i<n-2;i++)
                if(str1.charAt(i)!=str2.charAt(i-2)){
                    f=1;
                    break;
                }
            if(f==0)
                return true;
        }
        if(str2.charAt(0)==str1.charAt(n-2) && str2.charAt(1)==str2.charAt(n-1)){
            for(int i=2;i<n-2;i++)
                if(str2.charAt(i)!=str1.charAt(i-2))
                    return false;
            return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
	    Scanner x=new Scanner(System.in);
	    String s=x.nextLine(),a=x.nextLine();
	    if(isRotated(s,a))
	        System.out.print("1");
	    else 
	        System.out.print("0");
	}
}
