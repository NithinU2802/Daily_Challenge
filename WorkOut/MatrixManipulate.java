/******************************************************************************

Given a matrix M of size m x n ( 1 <= m,n <= 1000 ). It is initially filled with 
integers from 1 to m x n sequentially in a row major order. The task is to process
a list of queries manipulating M such that every query is one of the following three. 

R(x, y): swaps the x-th and y-th rows of M where x and y vary from 1 to m.
C(x, y): swaps the x-th and y-th columns of M where x and y vary from 1 to n.
P(x, y): prints the element at x-th row and y-th column where x varies from 1 to m 
and y varies from 1 to n.
Note that the given matrix is stored as a typical 2D array with indexes start 
from 0, but values of x and y start from 1.

Input : 
Enter Row and Column: 3 3 
Enter Query Size: 6 

                    R(1, 2)
                    P(1, 1)
                    P(2, 1)
                    C(1, 2)
                    P(1, 1)
                    P(2, 1)
Output: value at (1, 1) = 4
        value at (2, 1) = 1
        value at (1, 1) = 5
        value at (2, 1) = 2
Explanation:


Input : 
Enter Row and Column: 1234 5678 
Enter Query Size: 6 
                R(1, 2)
                P(1, 1)
                P(2, 1)
                C(1, 2)
                P(1, 1)
                P(2, 1)
Output: value at (1, 1) = 5679
        value at (2, 1) = 1
        value at (1, 1) = 5680
        value at (2, 1) = 2

*******************************************************************************/

import java.util.*;

public class MatrixManipulate
{
    
    static void rowChange(int a,int b,int mat[][]){
        a--;
        b--;
        int[] t=new int[mat[0].length];
        for(int i=0;i<mat[0].length;i++)
        t[i]=mat[a][i];
        for(int i=0;i<mat[0].length;i++){
        mat[a][i]=mat[b][i];
        mat[b][i]=t[i];
        }
    }
    
    static void columnChange(int a,int b,int mat[][]){
        a--;
        b--;
        int[] t=new int[mat.length];
        for(int i=0;i<mat.length;i++)
        t[i]=mat[i][a];
        for(int i=0;i<mat.length;i++){
        mat[i][a]=mat[i][b];
        mat[i][b]=t[i];
        }
    }
    
    static int print(int a,int b,int mat[][]){
        return mat[a-1][b-1];
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	System.out.println("Enter Row and Column: ");
	int r=x.nextInt(),c=x.nextInt();
	x.nextLine();
	System.out.println("Enter Query Size: ");
	int q=x.nextInt();
	int[][] mat=new int[r][c];
	int num=1;
	for(int i=0;i<r;i++)
	for(int j=0;j<c;j++)
	mat[i][j]=num++;
	int[] pt=new int[q];
	int[] f=new int[q];
	int[] l=new int[q];
	int g=0;
	x.nextLine();
	for(int i=0;i<q;i++){
	    try{
	    String s=x.nextLine().trim();
	    String[] t=s.substring(2,s.length()-1).split(",");
	    int a=Integer.parseInt(t[0]),b=Integer.parseInt(t[1]);
	    switch(s.charAt(0)){
	        case 'R':
	            rowChange(a,b,mat);
	            break;
	        case 'C':
	            columnChange(a,b,mat);
	            break;
	        case 'P':
	            pt[g]=print(a,b,mat);
	            f[g]=a;
	            l[g++]=b;
	            break;
	        default:
	            System.out.println("Invalid Query");
	    }
	    }
	    catch(Exception e){
	        System.out.println("Beyond the row and column size..!");
	    }
	}
	for(int i=0;i<g;i++){
	    System.out.println("Value at ("+f[i]+","+l[i]+") ="+pt[i]);
	}
	}
}
