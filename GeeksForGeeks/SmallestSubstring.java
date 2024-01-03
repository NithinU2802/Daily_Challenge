/******************************************************************************

Given a string S consisting of the characters 0, 1 and 2. Your task is to find the
length of the smallest substring of string S that contains all the three characters
0, 1 and 2. If no such substring exists, then return -1.

Example 1:

Input:
S = 10212
Output:
3
Explanation:
The substring 102 is the smallest substring
that contains the characters 0, 1 and 2.
Example 2:

Input: 
S = 12121
Output:
-1
Explanation: 
As the character 0 is not present in the
string S, therefor no substring containing
all the three characters 0, 1 and 2
exists. Hence, the answer is -1 in this case.
Your Task:
Complete the function smallestSubstring() which takes the string S as input, and 
returns the length of the smallest substring of string S that contains all the three
characters 0, 1 and 2.

Expected Time Complexity: O( length( S ) )
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ length( S ) ≤ 105
All the characters of String S lies in the set {'0', '1', '2'}

*******************************************************************************/
import java.util.*;

public class SmallestSubstring
{
    public static int smallestSubstring(String S) {
        int[] a=new int[3];
        int s=0,res=100001;
        for(int i=0;i<S.length();i++){
            Arrays.fill(a,0);
            for(int j=i;j<S.length();j++){
                a[(int)S.charAt(j)-'0']++;
                if(a[0]!=0 && a[1]!=0 && a[2]!=0){
                    res=res>j-i+1?j-i+1:res;
                    break;
                }
            }
        }
        return res==100001?-1:res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		System.out.println(smallestSubstring(s));
	}
}
