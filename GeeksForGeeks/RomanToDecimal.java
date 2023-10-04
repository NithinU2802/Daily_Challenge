/******************************************************************************

Given a string in roman no format (s)  your task is to convert it to an integer .
Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000

Example 1:

Input:
s = V
Output: 5
Example 2:

Input:
s = III 
Output: 3
Your Task:
Complete the function romanToDecimal() which takes a string as input parameter 
and returns the equivalent decimal number. 

Expected Time Complexity: O(|S|), |S| = length of string S.
Expected Auxiliary Space: O(1)

Constraints:
1<=roman no range<=3999

*******************************************************************************/
import java.util.*;

public class Main
{
    public static int romanToDecimal(String s){
        int p=0,res=0;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        for(int i=0;i<s.length();i++){
            int c=map.get(""+s.charAt(i));
            if(c>p)
                res+=c-(2*p);
            else
                res+=c;
            p=c;
        }
        return res;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	System.out.println(romanToDecimal(s));
	}
}
