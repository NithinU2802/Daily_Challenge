/******************************************************************************

    Largest three and Smallest three Even Numbers 

*******************************************************************************/

import java.util.*;


public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int m=x.nextInt();
	int[] s=new int[m];
	for(int i=0;i<m;i++)
	    s[i]=x.nextInt();
	List<Integer> b=new ArrayList<Integer>();
	for(int i=0;i<m;i++)
	    if(s[i]%2==0)
	        b.add(s[i]);
	int n=b.size();
	int[] a=new int[b.size()];
	for(int i=0;i<b.size();i++)
	    a[i]=b.get(i);
	int[] large=new int[3];
	int[] small=new int[3];
	Arrays.fill(large,Integer.MIN_VALUE);
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
	    }else if(small[1]>a[i]){
	        small[2]=small[1];
	        small[1]=a[i];
	    }else if(small[2]>a[i])
	        small[2]=a[i];
	}
	System.out.print("Large: ");
	for(int i=0;i<2;i++)
	    System.out.print(large[i]+",");
	System.out.println(large[2]);
	System.out.print("Smallest: ");
	for(int i=0;i<2;i++)
	    System.out.print(small[i]+",");
	System.out.print(small[2]);
	}
}
