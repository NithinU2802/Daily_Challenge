/******************************************************************************

Given a string s check if it is "Panagram" or not.

A "Panagram" is a sentence containing every letter in the English Alphabet.

Example 1:

Input:
s = "Bawds jog, flick quartz, vex nymph"
Output: 
1
Explanation: 
In the given input, there
are all the letters of the English
alphabet. Hence, the output is 1.
Example 2:

Input:
s = "sdfs"
Output: 
0
Explanation: 
In the given input, there
aren't all the letters present in the
English alphabet. Hence, the output
is 0.
Your Task:
You do not have to take any input or print anything. You need to complete the function 
checkPangram() that takes a string as a parameter and returns true if the string is a
Panagram, or else it returns false.

Expected Time Complexity: O( |s| )
Expected Auxiliary Space: O(1)
|s| denotes the length of the input string.

Constraints:
1 ≤ |s| ≤ 104
Both Uppercase & Lowercase are considerable

*******************************************************************************/
import java.util.*;

public class CheckPangram
{
    
    public static boolean checkPangram  (String s) {
        HashSet<Character> set=new HashSet<>();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++)
            if(Character.isAlphabetic(s.charAt(i)))
                set.add(s.charAt(i));
        return set.size()==26;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		if(checkPangram(s))
		    System.out.println("1");
		else
		    System.out.println("0");
	}
}
