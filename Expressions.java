/******************************************************************************

A fast scheme for evaluating a polynomial such as:
        -19+ 7x- 4x2 + 6x3
when
x=3
is to arrange the computation as follows:((((0)x+6)x+(-4))x+7)x+(-19)

Output: 128

Write a Java program to compute the result from the innermost brackets.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	int m=x.nextInt();
	String tm=s;
	s="";
	for(int i=0;i<tm.length();i++)
	    if(tm.charAt(i)!=' ')
	        s+=tm.charAt(i);
	int i=0,k=0,f=0,sum=0,sm=0;
	int[] a=new int[(int)s.charAt(s.length()-1)];
	String r="";
	if(s.charAt(i++)=='-')
	    f=1;
	while(Character.isDigit(s.charAt(i)))
	    r+=s.charAt(i++);
	if(s.charAt(i)!='x'){
	sm=Integer.parseInt(r);
	if(f==1)
	    sm*=-1;
	sum+=sm;
	}
	i=0;
	f=0;
	r="";
	while(i<s.length()){
	    if(s.charAt(i)=='x'){
	        i++;
	        String d="";
	        while(i<s.length() && Character.isDigit(s.charAt(i)))
	            d+=s.charAt(i++);
	        sm=Integer.parseInt(r);
	        if(f==1)
	            sm*=-1;
	        int xValue=1;
	        if(d.equals(""))
	            d+='1';
	        int t=Integer.parseInt(d);
	        for(int j=0;j<t;j++)
	            xValue*=m;
	        sm*=xValue;
	        sum+=sm;
	        f=0;
	        r="";
	        if(i==s.length())
	            break;
	    }
	    if(Character.isDigit(s.charAt(i))){
	        r+=s.charAt(i);
	    }
	    if(s.charAt(i)=='-')
	        f=1;
	    i++;
	}
	System.out.print(sum);
	}
}
