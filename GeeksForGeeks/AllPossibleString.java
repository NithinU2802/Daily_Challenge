/******************************************************************************

Given a string s of length n, find all the possible subsequences of the string s 
in lexicographically-sorted order.

Example 1:

Input : 
s = "abc"
Output: 
a ab abc ac b bc c
Explanation : 
There are a total 7 number of subsequences possible 
for the given string, and they are mentioned above 
in lexicographically sorted order.
Example 2:

Input: 
s = "aa"
Output: 
a a aa
Explanation : 
There are a total 3 number of subsequences possible 
for the given string, and they are mentioned above 
in lexicographically sorted order.
Your Task:
You don't need to read input or print anything. Your task is to complete the function
AllPossibleStrings() which takes a string s as the input parameter and returns a list
of all possible subsequences (non-empty) that can be formed from s in lexicographically-sorted order.

Expected Time Complexity: O( n*2n  )
Expected Space Complexity: O( n * 2n )

Constraints: 
1 <= n <= 16
s will constitute of lower case english alphabets

*******************************************************************************/
import java.util.*;

public class AllPossibleString
{
    static List<String> res;
    
    public static void generate(String s,int index,String a){
        if(index==s.length()){
            if(a.equals(""))
                return;
            res.add(a);
            return;
        }
        generate(s,index+1,a+s.charAt(index));
        generate(s,index+1,a);
    }
    
    public static List<String> AllPossibleStrings(String s)
    {
        res=new ArrayList<>();
        generate(s,0,"");
        Collections.sort(res);
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		for(String i:AllPossibleStrings(s))
		    System.out.print(i+" ");
	}
}
