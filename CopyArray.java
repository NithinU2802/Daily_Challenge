/******************************************************************************

    Copy or cloning Array with call by reference or value

*******************************************************************************/

public class CopyArray
{
	public static void main(String[] args) {
		int[] a=new int[2];
		a[0]=1;
		a[1]=2;
		int[] b=a.clone(); // reference
		a[0]=3;
		for(int i:b)
		    System.out.print(i+" ");
		System.out.println();
		b=a; // value
		a[0]=3;
		for(int i:b)
		    System.out.print(i+" ");
	}
}
