/******************************************************************************

Given a square matrix mat[][] of n*n size, the task is to determine the diagonal
pattern which is a linear arrangement of the elements of the matrix as depicted 
in the following example:



Example 1:

Input:
n = 3
mat[][] = {{1, 2, 3},
           {4, 5, 6},
           {7, 8, 9}}
Output: {1, 2, 4, 7, 5, 3, 6, 8, 9}
Explaination:
Starting from (0, 0): 1,
Move to the right to (0, 1): 2,
Move diagonally down to (1, 0): 4,
Move diagonally down to (2, 0): 7,
Move diagonally up to (1, 1): 5,
Move diagonally up to (0, 2): 3,
Move to the right to (1, 2): 6,
Move diagonally up to (2, 1): 8,
Move diagonally up to (2, 2): 9
There for the output is {1, 2, 4, 7, 5, 3, 6, 8, 9}.
Example 2:

Input:
n = 2
mat[][] = {{1, 2},
           {3, 4}}
Output: {1, 2, 3, 4}
Explaination:
Starting from (0, 0): 1,
Move to the right to (0, 1): 2,
Move diagonally down to (1, 0): 3,
Move to the right to (1, 1): 4
There for the output is {1, 2, 3, 4}.
Your Task:
You only need to implement the given function matrixDiagonally() which takes a 
matrix mat[][] of size n*n as an input and returns a list of integers containing 
the matrix diagonally. Do not read input, instead use the arguments given in the function.

Expected Time Complexity: O(n*n).
Expected Auxiliary Space: O(1).
Constraints:
1 <= n <= 100
-100 <= elements of matrix <= 100

*******************************************************************************/
import java.util.*;

public class MatrixDiagonally
{
    
    public static int[] matrixDiagonally(int[][] mat) {
        int si=0,sj=0,f=0,k=0,ei=0,ej=0;
        int[] res=new int[mat.length*mat[0].length];
        res[k++]=mat[0][0];
        while(k<mat.length*mat[0].length){
            if(sj<mat[0].length-1)
                sj++;
            else
                ej++;
            if(si<mat.length-1)
                si++;
            else
                ei++;
            int i=si,j=sj;  // 1 2 4 4 2 3 5 7 7
            if(f==0){
                i=ei;
                while(j>=0 && i<mat.length && k<mat.length*mat[0].length){
                    res[k++]=mat[i][j];
                    j--;
                    i++;
                }
                f=1;
            }else{
                j=ej;
                while(j<mat[0].length && i>=0 && k<mat.length*mat[0].length){
                    res[k++]=mat[i][j];
                    j++;
                    i--;
                }
                f=0;
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++)    
    		    a[i][j]=x.nextInt();
		for(int i: matrixDiagonally(a))
		    System.out.print(i+" ");
	}
}
