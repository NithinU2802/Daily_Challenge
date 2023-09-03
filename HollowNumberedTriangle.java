/******************************************************************************

    Inverted Hollow Triangle with numbers.

Input:
5

Ouput:
* * * * *
 * 1 2 *
  * 3 *
   * *
    *

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt(),k=1;
	for(int i=0;i<n;i++)
	    System.out.print("* ");
	System.out.println();
	for(int i=1;i<n;i++){
	    for(int j=0;j<i;j++)
	        System.out.print(" ");
	    for(int j=0;j<n-i;j++){
	        if(j==0 || j==n-i-1)
	            System.out.print("* ");
	        else 
	            System.out.print((k++)+" ");
	    }
	    System.out.println();
	}
	}
}
