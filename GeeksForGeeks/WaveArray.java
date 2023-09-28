/******************************************************************************

    Wave Converter from an random array..!
    
    
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
In other words, arrange the elements into a sequence such that 

    arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....

If there are multiple solutions, find the lexicographically smallest one.

Note:The given array is sorted in ascending order, and you don't need to return
anything to make changes in the original array itself.
    
Input:
6
2 3 7 3 6 8

Output:
3 2 3 7 6 8 

*******************************************************************************/
import java.util.*;

public class WaveArray
{
    
    public static int partition(int s,int e,int[] a){
        int p=a[e];
        int i=s-1;
        for(int j=s;j<e;j++)
            if(a[j]<p){
                i++;
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        int t=a[i+1];
        a[i+1]=a[e];
        a[e]=t;
        return i+1;
    }
    
    public static void quick(int s,int e,int[] a){
        if(s<e){
            int p=partition(s,e,a);
            quick(s,p-1,a);
            quick(p+1,e,a);
        }
    }
    
    public static void print(int[] a){
        int n=a.length;
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	quick(0,n-1,a);
	for(int i=0;i<n;i+=2){
	    if(i<0 && a[i]<a[i-1]){
	        int t=a[i];
	        a[i]=a[i+1];
	        a[i+1]=t;
	    }
	    if(i<n-1 && a[i]<a[i+1]){
	        int t=a[i];
	        a[i]=a[i+1];
	        a[i+1]=t;
	    }
	}
	print(a);
	}
}
