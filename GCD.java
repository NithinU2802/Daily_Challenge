/******************************************************************************

    Find the greatest common divisor
    
*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int a=x.nextInt(),b=x.nextInt();
	if(a>b){
	    a^=b;
	    b^=a;
	    a^=b;
	}
	int s=a;
	while(s>=1){
	    if(a%s==0 && b%s==0){
	        System.out.println(s);
	        break;
	    }
	    s--;
	}
	}
}
