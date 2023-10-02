/******************************************************************************

Given a string consisting of lower case English alphabets, the task is to find the
number of distinct subsequences of the string
Note: Answer can be very large, so, ouput will be answer modulo 109+7.

Example 1:

Input: 
s = "gfg"
Output: 
7
Explanation: 
The seven distinct subsequences are "", "g", "f", "gf", "fg", "gg" and "gfg" .
Example 2:

Input: 
s = "ggg"
Output: 
4
Explanation: 
The four distinct subsequences are "", "g", "gg", "ggg".

*******************************************************************************/
import java.util.*;
public class Main
{
    static int distanceSubsequence(String s){
        int[] dp=new int[s.length()+1];
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int mod=1000000007;
        dp[0]=1;
        for(int i=1;i<=s.length();i++){
            dp[i]=(dp[i-1]*2)%mod;
            if(map.containsKey(s.charAt(i-1)))
                dp[i]=((dp[i]-dp[map.get(s.charAt(i-1))-1])+mod)%mod;
            map.put(s.charAt(i-1),i);
        }
        return dp[s.length()];
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	System.out.println(distanceSubsequence(s));
	}
}
