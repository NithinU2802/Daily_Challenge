/******************************************************************************

Given a square matrix of size N*N, print the sum of upper and lower triangular elements.
Upper Triangle consists of elements on the diagonal and above it. The lower triangle consists
of elements on the diagonal and below it. 

Example 1:

Input:
N = 3 
mat[][] = {{6, 5, 4},
           {1, 2, 5}
           {7, 9, 7}}
Output: 
29 32
Explanation:
The given matrix is
6 5 4
1 2 5
7 9 7
The elements of upper triangle are
6 5 4
  2 5
    7
Sum of these elements is 6+5+4+2+5+7=29.
The elements of lower triangle are
6
1 2
7 9 7
Sum of these elements is 6+1+2+7+9+7= 32.
Example 2:

Input:
N = 2
mat[][] = {{1, 2},
           {3, 4}}
Output: 
7 8
Explanation:
Upper triangular matrix:
1 2
  4
Sum of these elements are 7.
Lower triangular matrix:
1
3 4
Sum of these elements are 8.

Your Task:
You don't need to read input or print anything. Complete the function sumTriangles() that takes matrix and its size N as input parameters and returns the list of integers containing the sum of upper and lower triangle.

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(1)

Constraints: 
1 <= N <= 103
1 <= matrix[i][j] <= 106


*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static ArrayList<Integer> sumTriangles(int[][] mat,int n){
        ArrayList<Integer> res=new ArrayList<Integer>();
        int s=0,r=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<=j)
                    s+=mat[i][j];
                if(j<=i)
                    r+=mat[i][j];
            }
        }
        res.add(s);
        res.add(r);
        return res;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[][] a=new int[n][n];
	for(int i=0;i<n;i++)
	    for(int j=0;j<n;j++)
	        a[i][j]=x.nextInt();
	for(int i:sumTriangles(a,n))
	    System.out.print(i+" ");
	}
}
