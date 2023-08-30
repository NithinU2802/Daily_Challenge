/******************************************************************************

Example 1: If the participants details are as below –
First_Name = Rajiv
Last_Name = Roy
PIN – 560037
N=6
Step 1: Length of Last_Name is less than the length of First_Name, so the smaller name is “Roy”and the Longer name is “Rajiv””.
Step 2: The user-id will be = First letter of the longer name + Entire word of the smaller name + Digit at position N in the PIN when traversing the PIN from right to left
=First letter of “Rajiv”+Entire word of “Roy”+6th digit of PIN from left+6th Digit of PIN from right.
=R+Roy+7+5
Therefore user-id = RRoy75.
Step 3 : Toggle the alphabets in the user-id. So, user-id = rrOY75

Example 2: If the participants details are as below –
First_Name= Manoj 
Last_Name = Kumar
PIN – 561327
N=2
OUTPUT :
M+Kumar+6+2 == MKumar62
mkUMAR62


*******************************************************************************/

import java.util.*;

public class Solution
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s1=x.nextLine();
	String s2=x.nextLine();
	String c=x.nextLine();
	int n=x.nextInt();
	String r="",d=String.valueOf(c.charAt(n-1))+String.valueOf(c.charAt(c.length()-n));
	if(s1.length()==s2.length()){
	    TreeSet<String> s=new TreeSet<>();
	    s.add(s1);
	    s.add(s2);
	    if(Character.isUpperCase(s.last().charAt(0)))
	        r+=Character.toLowerCase(s.last().charAt(0));
	    else 
	        r+=Character.toUpperCase(s.last().charAt(0));
	    for(int i=0;i<s.first().length();i++){
	       if(Character.isUpperCase(s.first().charAt(i)))
	           r+=Character.toLowerCase(s.first().charAt(i));
	       else 
	           r+=Character.toUpperCase(s.first().charAt(i));
	}
	}else{
	    if(s1.length()<s2.length()){
	        String t=s1;
	        s1=s2;
	        s2=t;
	    }
	    if(Character.isLowerCase(s1.charAt(0)))
	        r+=Character.toUpperCase(s1.charAt(0));
	    else 
	        r+=Character.toLowerCase(s2.charAt(0));
	    for(int i=0;i<s2.length();i++)
	        if(Character.isUpperCase(s2.charAt(i)))
	            r+=Character.toLowerCase(s2.charAt(i));
	        else 
	            r+=Character.toUpperCase(s2.charAt(i));
	}
	r+=d;
	System.out.println(r);
	}
}
