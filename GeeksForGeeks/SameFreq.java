/******************************************************************************

Given a string s which contains only lower alphabetic characters, check if it is
possible to remove at most one character from this string in such a way that frequency
of each distinct character becomes same in the string. Return true if it is possible
to do else return false.

Note: The driver code print 1 if the value returned is true, otherwise 0.

Example 1:

Input:
s = "xyyz"
Output: 
1 
Explanation: 
Removing one 'y' will make frequency of each character to be 1.
Example 2:

Input:
s = "xxxxyyzz"
Output: 
0
Explanation: 
Frequency can not be made same by removing at most one character.
Your Task:  
You dont need to read input or print anything. Complete the function sameFreq() 
which takes a string as input parameter and returns a boolean value denoting if 
same frequency is possible or not.

Expected Time Complexity: O(|s|) 
Expected Auxiliary Space: O(1)

Constraints:
1 <= |s| <= 105



*******************************************************************************/
import java.util.*;

public class SameFreq
{
    
    static boolean sameFreq(String s) {
        int[] fq=new int[26];
        for(int i=0;i<s.length();i++)
            fq[s.charAt(i)-'a']++;
        int m=-1,df=0;
        m=fq[s.charAt(0)-'a'];
        for(int i=0;i<26;i++){
            if(fq[i]==0)
                continue;
            if(fq[i]!=m)
                df+=Math.abs(m-fq[i]);
            if(df>1)
                return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int s=x.nextLine();
		System.out.print(sameFreq(s));
	}
}
