/******************************************************************************

    You are given a matrix of dimensions n x m. The task is to perform boundary
traversal on the matrix in a clockwise manner.

Example 1:

Input:
n = 4, m = 4
matrix[][] = {{1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 10, 11, 12},
         {13, 14, 15,16}}
Output: 1 2 3 4 8 12 16 15 14 13 9 5
Explanation:
The matrix is:
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
The boundary traversal is:
1 2 3 4 8 12 16 15 14 13 9 5
Example 2:

Input:
n = 3, m = 4
matrrix[][] = {{12, 11, 10, 9},
         {8, 7, 6, 5},
         {4, 3, 2, 1}}
Output: 12 11 10 9 5 1 2 3 4 8

*******************************************************************************/
import java.util.*;

public class BoundaryTraversal
{
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
    ArrayList<Integer> res=new ArrayList<Integer>();
    if(n==1){
        for(int j=0;j<m;j++)
            res.add(matrix[0][j]);
        return res;
    }
    if(m==1){
        for(int i=0;i<n;i++)
            res.add(matrix[i][0]);
        return res;
    }
    int sr=0,sc=0,er=n-1,ec=m-1;
    for(int j=sc;j<=ec;j++)
        res.add(matrix[sr][j]);
    sr++;
    for(int i=sr;i<=er;i++)
        res.add(matrix[i][ec]);
    ec--;
    for(int j=ec;j>=sc;j--)
        res.add(matrix[er][j]);
    er--;
    for(int i=er;i>=sr;i--)
        res.add(matrix[i][sc]);
    return res;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt(),m=x.nextInt();
	int[][] a=new int[n][m];
	for(int i=0;i<n;i++)
	    for(int j=0;j<m;j++)
	        a[i][j]=x.nextInt();
	for(int i: boundaryTraversal(a,n,m))
	    System.out.print(i+" ");
	}
}
