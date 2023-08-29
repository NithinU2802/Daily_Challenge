/******************************************************************************

Example1:
Intput1[]={11,4,3,1,4,7,8,12,2,3,7}
Output1 should be 2
Output2 should be 4

Example 2:
Intput1[]={1,3,2,1}
Output1 should be 1
Output2 should be 3

Example 3:
Intput1[]={12,15,21,29,69,79}
Output1 should be 0
Output2 should be 0


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
	int m=0,count=0;
	for(int i=0;i<n-1;i++){
	    if(a[i]>a[i+1]){
	        int c=1;
	        count++;
	        while(i+1<n && a[i]>a[i+1]){
	            i++;
	            c++;
	        }
	        i--;
	        if(c>m)
	            m=c;
	    }
	}
	System.out.println(count);
	System.out.println(m);
	}
}
