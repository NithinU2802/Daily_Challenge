/******************************************************************************

    Repeated element from rear end of an array and avoid to print less than or 
equal to 0 value. If there in no value greater than 0 then print 0.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	int f=0;
	for(int i=n-1;i>=0;i--){
	    if(a[i]<=0)
	        continue;
	     f=1;
	    for(int j=i+1;j<n;j++)
	        if(a[i]==a[j]){
	            System.out.println(a[i]);
	            return;
	        }
	}
	if(f==1)
	    System.out.println("0");
	else 
	    System.out.println(a[n-1]);
	}
}
