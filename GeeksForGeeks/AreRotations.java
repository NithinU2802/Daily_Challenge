/******************************************************************************

You are given two strings of equal lengths, s1 and s2. The task is to check if s2
is a rotated version of the string s1.

Note: The characters in the strings are in lowercase.

Example 1:

Input:
geeksforgeeks
forgeeksgeeks
Output: 
1
Explanation: s1 is geeksforgeeks, s2 is
forgeeksgeeks. Clearly, s2 is a rotated
version of s1 as s2 can be obtained by
left-rotating s1 by 5 units.
Example 2:

Input:
mightandmagic
andmagicmigth
Output: 
0
Explanation: Here with any amount of
rotation s2 can't be obtained by s1.
Your Task:
You don't have to read or print anything. The task is to complete the function 
areRotations() which takes two strings, s1 and s2 as inputs and checks if the two
strings are rotations of each other. The function returns true if s1 can be obtained
by rotating s2, else it returns false.

Expected Time Complexity: O( |s1| ).
Expected Space Complexity: O( |s1| ).

Constraints:
1 <= |s1|, |s2| <= 105

*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static boolean areRotations(String a,String b){
        int n=a.length(),m=b.length();
        if(n!=m)
            return false;
        if(a.equals(b))
            return true;
        for(int i=1;i<n;i++)
            if(a.charAt(i)==b.charAt(0) && a.charAt(i-1)==b.charAt(n-1) && check(a,b,i))
                return true;
        return false;
    }
    
    public static boolean check(String a,String b,int k){
        int j=k,n=a.length();
        for(int i=0;i<n;i++){
            if(b.charAt(i)!=a.charAt(j++))
                return false;
            if(j==n)
                j=0;
        }
        return true;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String a=x.nextLine(),b=x.nextLine();
	if(areRotations(a,b))
	    System.out.println("1");
	else 
	    System.out.println("0");
	}
}
