/******************************************************************************

Given a string A and a dictionary of n words B, find out if A can be segmented 
into a space-separated sequence of dictionary words. Return 1 if it is possible 
to break A into sequence of dictionary words, else return 0. 

Note: From the dictionary B each word can be taken any number of times and in any
order.

Example 1:

Input:
n = 6
B = { "i", "like", "sam", "sung", "samsung", "mobile"}
A = "ilike"
Output:
1
Explanation:
The string can be segmented as "i like".
Example 2:

Input:
n = 6
B = { "i", "like", "sam", "sung", "samsung", "mobile"}
A = "ilikesamsung"
Output:
1
Explanation:
The string can be segmented as 
"i like samsung" or "i like sam sung".
Your Task:
Complete wordBreak() function which takes a string and list of strings as a parameter
and returns 1 if it is possible to break words, else return 0. You don't need to read
any input or print any output, it is done by driver code.

Expected Time Complexity: O(len(A)2)
Expected Space Complexity: O(len(A))

Constraints:
1 ≤ n ≤ 12
1 ≤ len(A) ≤ 1100



*******************************************************************************/
import java.util.*;

public class WordBreak
{
    
    public static boolean check(String A,ArrayList<String> B,int s){
        if(A.length()==s)
            return true;
        for(int i=s+1;i<=A.length();i++)
            if(B.contains(A.substring(s,i)) && check(A,B,i))
                return true;
        return false;
    }
    
    public static int wordBreak(String A,ArrayList<String> B){
        if(check(A,B,0))
            return 1;
        return 0;
    }
    
	public static void main(String[] args) {
	    Scanner x=new Scanner(System.in);
	    int n=x.nextInt();
	    x.nextLine();
	    String[] a=x.nextLine().split(" ");
	    ArrayList<String> B=new ArrayList<>();
	    for(String i:a)
	        B.add(i);
	    String A=x.nextLine();
	    System.out.println(wordBreak(A,B));
	}
}
