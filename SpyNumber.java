/******************************************************************************

    Check whether the number is Spy Number or number 
    
*******************************************************************************/
import java.util.*;

public class SpyNumber
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int s=0,p=1;
	while(n>0){
	    s+=(n%10);
	    p*=(n%10);
	    n/=10;
	}
	if(s==p)
	    System.out.println("YES");
	else
	    System.out.println("NO");
	}
}
