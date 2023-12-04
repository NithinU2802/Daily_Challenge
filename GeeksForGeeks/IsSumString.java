/******************************************************************************

Given a string of digits, the task is to check if it is a ‘sum-string’. A string S
is called a sum-string when it is broken down into more than one substring and the
rightmost substring can be written as a sum of two substrings before it and the same 
is recursively true for substrings before it.

Example 1:

Input:
S = "12243660"
Output:
1
Explanation:
"12243660" can be broken down as {"12", "24", "36", "60"}.
We can get 60 from 24 and 36 as 24 + 36 = 60. Similarly 36 can be written as 12 + 24.
Example 2:

Input:
1111112223
Output:
1
Explanation:
"1111112223" can be broken down as {"1", "111", "112", "223"}.
We can get 223 from 111 and 1112 as 111 + 112 = 223. Similarly 112 can be written as 1 + 111.
Your Task:

You don't need to read input or print anything. Your task is to complete the function
isSumString() which takes the string S and returns 1 is S is a sum-string otherwise returns 0.

Expected Time Complexity: O(|S|3)
Expected Auxiliary Space: O(|S|)

Constraints:
1 <= |S| <= 500
String consists of characters from '0' to '9'.

*******************************************************************************/
import java.util.*;

class Solution{
    public int isSumString(String S){
        for(int i=1;i<S.length()-1;i++){
            for(int j=i+1;j<S.length();j++){
                String s1=S.substring(0,i),s2=S.substring(i,j),s3=S.substring(j,S.length());
                
                long a=Long.parseLong(s1);
                long b=Long.parseLong(s2);
                long c=Long.parseLong(s3);
                while(c!=0){
                    if(a+b==c){
                        s1 = s2;
                        s2 = s3.substring(0, Long.toString(a).length());
                        s3 = s3.substring(Long.toString(a).length());
                        a = b;
                        b = Long.parseLong(s2);
                        c = Long.parseLong(s3);
                    }else
                        break;
                }
                if(c==0)    
                    return 1;
            }
        }
    return 0;
    }
}

public class Main
{
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		Solution solution=new Solution();
		System.out.println(solution.isSumString(s));
	}
}
