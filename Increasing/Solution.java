/******************************************************************************* 

Input1 = 9
Intput2[]={11,3,4,7,8,12,2,3,7}
Output1 should be 5

Input1 = 4
Intput2[]={1,3,2,1}
Output1 should be 2

Input1 = 4
Intput2[]={1,3,2,1}
Output1 should be 2


*******************************************************************************/
import java.util.*;

public class Solution
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	int m=0;
	for(int i=0;i<n-1;i++){
	    if(a[i+1]>a[i]){
	        int c=1;
	        while(i+1<n && a[i]<a[i+1]){
	            c++;
	            i++;
	        }
	        i--;
	        if(c>m)
	            m=c;
	    }
	}
	System.out.print(m);
	}
}
