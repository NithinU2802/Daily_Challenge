import java.util.*;

public class Solution
{
	public static void main(String[] args) { 
	Scanner x=new Scanner(System.in);
	String r="";
	String[] s=x.nextLine().split(" ");
	for(String i:s)
	    r+=String.valueOf(i.length());
	System.out.print(r);
	}
}
