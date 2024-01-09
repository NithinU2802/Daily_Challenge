/******************************************************************************

Given two strings, one is a text string, txt and other is a pattern string, pat. The
task is to print the indexes of all the occurences of pattern string in the text string.
Use one-based indexing while returing the indices. 
Note: Return an empty list incase of no occurences of pattern. Driver will print -1 in 
this case.

Example 1:

Input:
txt = "geeksforgeeks"
pat = "geek"
Output: 
1 9
Explanation: 
The string "geek" occurs twice in txt, one starts are index 1 and the other at index 9. 
Example 2:

Input: 
txt = "abesdu"
pat = "edu"
Output: 
-1
Explanation: 
There's not substring "edu" present in txt.
Your Task:
You don't need to read input or print anything. Your task is to complete the function 
search() which takes the string txt and the string pat as inputs and returns an array 
denoting the start indices (1-based) of substring pat in the string txt. 

Expected Time Complexity: O(|txt|).
Expected Auxiliary Space: O(|txt|).

Constraints:
1 ≤ |txt| ≤ 105
1 ≤ |pat| < |S|
Both the strings consists of lowercase English alphabets.

*******************************************************************************/
import java.util.*;

public class SearchPattern
{
    static ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<txt.length();i++)
            if(txt.charAt(i)==pat.charAt(0)){
                int k=i,f=0,j=0;
                for(j=0;k<txt.length() && j<pat.length();j++)
                    if(pat.charAt(j)!=txt.charAt(k++)){
                        f=1;
                        break;
                    }
                if(j<pat.length())
                    f=1;
                if(f==0)
                    res.add(i+1);
            }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String txt=x.nextLine(),pat=x.nextLine();
		ArrayList<Integer> a;
		for(int i:((a=search(txt,pat)).size()==0)?new ArrayList<Integer>(-1):a)
		    System.out.print(i+" ");
	}
}
