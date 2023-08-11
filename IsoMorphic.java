/******************************************************************************

    Check whether the string is Isomorphic or Not 

Input:  str1 = “aab”, str2 = “xxy”
Output: True
Explanation: ‘a’ is mapped to ‘x’ and ‘b’ is mapped to ‘y’.

Input:  str1 = “aab”, str2 = “xyz”
Output: False
Explanation: One occurrence of ‘a’ in str1 has ‘x’ in str2 and other occurrence of ‘a’ has ‘y’.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s1=x.nextLine();
	String s2=x.nextLine();
	int[] s=new int[130];
	int n=s1.length();
	boolean[] c=new boolean[130];
	for(int i=0;i<n;i++){
	    if(s[s1.charAt(i)]==0){
	        if(c[s2.charAt(i)]){
	            System.out.println("False");
	            return;
	        }
	        c[s2.charAt(i)]=true;
	        s[s1.charAt(i)]=s2.charAt(i);
	    }else if(s[s1.charAt(i)]!=s2.charAt(i)){
	            System.out.println("False");
	            return;
	        }
	}
	System.out.println("True");
	}
}
