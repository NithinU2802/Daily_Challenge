/******************************************************************************

REMOVE EXCEEDS TWICE: 

    Check integer in the array can occur less than twice if exceeds then remove
other than 1st two occurance

Input:
8
3 4 6 3 4 5 7 3

Output:
3 4 6 3 4 5 7

*******************************************************************************/
import java.util.*;

public class ExceedTwice
{
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		int[] b=new int[10001];
		for(int i=0;i<n;i++){
		    if(b[a[i]]<2)
		        System.out.print(a[i]+" ");
		    b[a[i]]++;
		}
	}
}
