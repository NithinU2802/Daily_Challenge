/******************************************************************************

    Finding Missing and Repeating number of an array.
    
Input:
5
4 1 1 2 3

Ouput:
Miss: 5
Repeat: 1

*******************************************************************************/
import java.util.*;

public class RepeatMiss
{
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		Arrays.sort(a);
		for(int i:a)
		    System.out.println(i);
		int repeat=-1,miss=-1;
		for(int i=0;i<n-1;i++)
		    if(a[i]==a[i+1])
		        repeat=a[i];
		    else if(a[i]!=a[i+1]+1)
		        miss=a[i+1]+1;
		System.out.println("Miss: "+miss);
		System.out.println("Repeat: "+repeat);
	}
}
