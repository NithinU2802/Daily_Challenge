/******************************************************************************

Given a boolean matrix of size RxC where each cell contains either 0 or 1, find 
the row numbers (0-based) of row which already exists or are repeated.

Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
            {1, 0}}
Output: 
1
Explanation:
Row 1 is duplicate of Row 0.
Example 2:

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
            { 1, 0, 0},
            { 0, 0, 0},
            { 0, 0, 0}}
Output: 
1 3 
Explanation:
Row 1 and Row 3 are duplicates of Row 0 and 2 respectively. 
Your Task:
You dont need to read input or print anything. Complete the function repeatedRows()
that takes the matrix as input parameter and returns a list of row numbers which are duplicate rows.

Expected Time Complexity: O(R * C)
Expected Auxiliary Space: O(R * C)

Constraints:
1 ≤ R, C ≤ 103
0 ≤ matrix[i][j] ≤ 1

*******************************************************************************/
import java.util.*;

public class RepeatedRows
{
    
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        boolean[] visit=new boolean[m];
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=m-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                int f=0;
                if(visit[j])
                    continue;
                for(int k=0;k<n;k++)
                    if(matrix[i][k]!=matrix[j][k]){
                        f=1;
                        break;
                    }
                if(f==0){
                    res.add(i);
                    visit[j]=true;
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int m=x.nextInt(),n=x.nextInt();
		int[][] mat=new int[m][n];
		for(int i=0;i<m;i++)
		    for(int j=0;j<n;j++)
		        mat[i][j]=x.nextInt();
		for(int i:repeatedRows(mat,m,n))
		    System.out.print(i+" ");
	}
}
