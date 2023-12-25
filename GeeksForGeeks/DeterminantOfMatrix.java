/******************************************************************************

Given a square matrix of size n*n. The task is to find the determinant of this matrix.

Example 1:

Input:
n = 4
matrix[][] = {{1, 0, 2, -1},
              {3, 0, 0, 5},
              {2, 1, 4, -3},
              {1, 0, 5, 0}}
Output: 30
Explanation:
Determinant of the given matrix is 30.
Example 2:

Input:
n = 3
matrix[][] = {{1, 2, 3},
              {4, 5, 6},
              {7, 10, 9}}
Output: 12
Explanation:
Determinant of the given matrix is 12.
Your Task:
You don't need to read input or print anything. Complete the function determinantOfMatrix()
that takes matrix and its size n as input parameters and returns the determinant of the matrix.

Expected Time Complexity: O(N4)
Expected Auxiliary Space: O(N2)

Constraints:
1 <= N <= 10
-10 <= mat[i][j] <= 10

*******************************************************************************/
import java.util.*;

public class DeterminantOfMatrix
{
    
    public static int determinantOfMatrix(int[][] matrix,int n){
        if(n==1)
            return matrix[0][0];
        else if(n==2)
            return (matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]);
        int m=n-1,res=0,f=0;
        for(int k=0;k<n;k++){
            int[][] r=new int[m][m];
            int l=0;
            for(int i=1;i<n;i++){
                int t=0;
                for(int j=0;j<n;j++){
                    if(j!=k)
                        r[l][t++]=matrix[i][j];
                }
                l++;
            }
            if(f==0){
                res+=matrix[0][k]*determinantOfMatrix(r,m);
                f=1;
            }else{
                res-=matrix[0][k]*determinantOfMatrix(r,m);
                f=0;
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
	    Scanner x=new Scanner(System.in);
	    int n=x.nextInt();
	    int[][] matrix=new int[n][n];
	    for(int i=0;i<n;i++)
	        for(int j=0;j<n;j++)
	            matrix[i][j]=x.nextInt();
	    System.out.println(determinantOfMatrix(matrix,n));
	}
}
