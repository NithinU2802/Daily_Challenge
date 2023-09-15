/*******************************************************************************

    Find First three smallest and largest number of the given array.
    
Input:
5
1 2 5 2 3

Output:
Large: 5 3 1
Small: 1 2 2

Input:
7
3 4 2 5 7 2 3 

Output:
Large: 7 5 4
Small: 2 2 3

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
	int[] large=new int[3];
	int[] small=new int[3];
	Arrays.fill(small,Integer.MAX_VALUE);
	for(int i=0;i<n;i++){
	    if(large[0]<a[i]){
	        large[2]=large[1];
	        large[1]=large[0];
	        large[0]=a[i];
	    }else if(large[1]<a[i]){
	        large[2]=large[1];
	        large[1]=a[i];
	    }else if(large[2]<a[i])
	        large[2]=a[i];
	    if(small[0]>a[i]){
	        small[2]=small[1];
	        small[1]=small[0];
	        small[0]=a[i];
	    }else if(small[1]==Integer.MAX_VALUE || small[1]>a[i])
	        small[1]=a[i];
	    else if(small[2]==Integer.MAX_VALUE || small[2]>a[i])
	        small[2]=a[i];
	}
	
	System.out.print("Large: ");
	for(int i=0;i<3;i++)
	    System.out.print(large[i]+" ");
	System.out.println();
	System.out.print("Small: ");
	for(int i=0;i<3;i++)
	    System.out.print(small[i]+" ");
	
	}
}
