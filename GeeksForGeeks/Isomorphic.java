/******************************************************************************

Given two strings 'str1' and 'str2', check if these two strings are isomorphic to
each other.

If the characters in str1 can be changed to get str2, then two strings, str1 and
str2, are isomorphic. A character must be completely swapped out for another character
while maintaining the order of the characters. A character may map to itself, but no 
two characters may map to the same character.

Example 1:

Input:
str1 = aab
str2 = xxy
Output: 
1
Explanation: 
There are two different characters in aab and xxy, i.e a and b with frequency 2 and
1 respectively.
Example 2:

Input:
str1 = aab
str2 = xyz
Output: 
0
Explanation: 
There are two different characters in aab but there are three different charactersin
xyz. So there won't be one to one mapping between str1 and str2.
Your Task:
You don't need to read input or print anything.Your task is to complete the function
areIsomorphic() which takes the string str1 and string str2 as input parameter and  
check if two strings are isomorphic. The function returns true if strings are isomorphic
else it returns false.

Expected Time Complexity: O(|str1|+|str2|).
Expected Auxiliary Space: O(Number of different characters).
Note: |s| represents the length of string s.

Constraints:
1 <= |str1|, |str2| <= 105
*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static boolean isomorphic(String a,String s){
        char[] map=new char[130];
        Arrays.fill(map,'-');
        boolean[] visit=new boolean[130];
        if(s.length()!=a.length())
            return false;
        for(int i=0;i<a.length();i++){
            if(map[a.charAt(i)]=='-'){
                map[a.charAt(i)]=s.charAt(i);
                visit[s.charAt(i)]=true;
            }else if(map[a.charAt(i)]!=s.charAt(i))
                return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine(),a=x.nextLine();
	if(isomorphic(s,a))
	    System.out.println("1");
	else 
	    System.out.println("0");
	}
}
