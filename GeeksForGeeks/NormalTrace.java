/******************************************************************************

    Java Program to Find the Normal and Trace of a Matrix.

For a given 2D matrix, the purpose is to find the Trace and Normal of the matrix.

    Normal of a matrix is defined as the square root of the sum of squares of all the
elements of the matrix.

Trace of a given square matrix is defined as the sum of all the elements in the diagonal.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) { 
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[][] a=new int[n][n];
	for(int i=0;i<n;++i)
	    for(int j=0;j<n;j++)
	        a[i][j]=x.nextInt();
	int normal=0,trace=0;
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++){
	        if(i==j)
	            trace+=a[i][j];
	        normal+=(a[i][j]*a[i][j]);
	    }
	}
	System.out.println("Normal: "+normal);
	System.out.println("Trace: "+trace);
	}
}
