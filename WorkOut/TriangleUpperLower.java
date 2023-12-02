/******************************************************************************

    Upper Triangle and Lower Triangle Matrix

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++)
		        a[i][j]=x.nextInt();
		System.out.println("Upper Triangle Matrix:");
		for(int i=0;i<n;i++){
		    for(int j=0;j<n;j++){
		        if(i<=j)
    		        System.out.print(a[i][j]+" ");
    		    else 
    		        System.out.print("  ");
		    }
		    System.out.println();
		}
		System.out.println("Lower Triangle Matrix:");
		for(int i=0;i<n;i++){
		    for(int j=0;j<n;j++){
		        if(i>=j)
    		        System.out.print(a[i][j]+" ");
    		    else 
    		        System.out.print("  ");
		    }
		    System.out.println();
		}
	}
}
