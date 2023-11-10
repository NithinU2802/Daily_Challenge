/******************************************************************************

Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern. Digits from 1-9
and digits can't repeat.

Example 1:

Input:
D
Output:
21
Explanation:
D is meant for decreasing, so we choose the minimum number among all possible numbers 
like 21,31,54,87,etc.
Example 2:

Input:
IIDDD
Output:
126543
Explanation:
Above example is self- explanatory,
1 < 2 < 6 > 5 > 4 > 3
  I - I - D - D - D
Your Task:
You don't need to read input or print anything. Your task is to complete the function 
printMinNumberForPattern() which takes the string S and returns a string containing the
minimum number following the valid number.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ Length of String ≤ 8



*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static String printMinNumberForPattern(String S){
        String res="";
        int n=S.length(),i=0,st=1;
        while(i<n){
            String a="";
            while(i<n && S.charAt(i)=='I'){
                a+=st++;
                i++;
            }
            res+=a;
            a="";
            while(i<n && S.charAt(i)=='D'){
                a+=st++;
                i++;
            }
            a+=st++;
            i++;
            for(int j=a.length()-1;j>=0;j--)
                res+=a.charAt(j);
        }
        if(S.charAt(n-1)=='I' && res.length()<n+1)
            res+=st;
        return res;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	System.out.println(printMinNumberForPattern(s));
	}
}
