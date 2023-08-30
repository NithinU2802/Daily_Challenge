/******************************************************************************


Input1=”John”  
Input2=”Johny” 
Input3=”Janardhan” 

Output1= “J”+”h”+”han”=”Jhhan”
Output2=”oh”+”ny”+”Jan”=”ohnyJan”
Output3=”n”+”Jo”+”ard”=”nJoard”


*******************************************************************************/
import java.util.*;

public class Solution
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String input1=x.nextLine();
	String input2=x.nextLine();
	String input3=x.nextLine();
	String[] s={input1,input2,input3};
	String[] first=new String[3];
	String[] second=new String[3];
	String[] third=new String[3];
	for(int i=0;i<3;i++){
	    String a=s[i];
	    int n=a.length(),j=n/3;
	    if(n%3==2)
	        j++;
	    int k=n-(j*2);
	    first[i]=a.substring(0,j);
	    second[i]=a.substring(j,j+k);
	    third[i]=a.substring(j+k,n);
	}
	System.out.println(first[0]+second[1]+third[2]);
	System.out.println(second[0]+third[1]+first[2]);
	System.out.println(third[0]+first[1]+second[2]);
	}
}
