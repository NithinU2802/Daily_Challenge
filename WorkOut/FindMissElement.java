// Consider 3 array size a as n, b as n-1 and c as n-2 find elements missing from b with a and c with b
import java.util.*;

public class FindMissElement
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		int[] b=new int[n-1];
		int[] c=new int[n-2];
		for(int i=0;i<n;i++)
		    a[i]=sc.nextInt();
		for(int i=0;i<n-1;i++)
		    b[i]=sc.nextInt();
		for(int i=0;i<n-2;i++)
		    c[i]=sc.nextInt();
		int suma=0,sumb=0,sumc=0;
		for(int i:a)
		    suma+=i;
		for(int i:b)
		    sumb+=i;
		for(int i:c)
		    sumc+=i;
		System.out.println(suma-sumb);
		System.out.println(sumb-sumc);
	}
}
