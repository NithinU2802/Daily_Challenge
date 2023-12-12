/******************************************************************************

    Given a gold mine called M of (n x m) dimensions. Each field in this mine contains
a positive integer which is the amount of gold in tons. Initially the miner can start
from any row in the first column. From a given cell, the miner can move

    1. to the cell diagonally up towards the right.
    2. to the right.
    3. to the cell diagonally down towards the right.
Find out maximum amount of gold which he can collect until he can no longer move.

Example 1:
Input: n = 3, m = 3
M = {{1, 3, 3},
     {2, 1, 4},
     {0, 6, 4}};
Output: 12
Explaination: 
The path is {(1,0) -> (2,1) -> (2,2)}.

Example 2:
Input: n = 4, m = 4
M = {{1, 3, 1, 5},
     {2, 2, 4, 1},
     {5, 0, 2, 3},
     {0, 6, 1, 2}};
Output: 16
Explaination: 
The path is { (2,0) -> (3,1) -> (2,2) -> (2,3) } or {(2,0) -> (1,1) -> (1,2) -> (0,3)}.
Your Task:
    You do not need to read input or print anything. Your task is to complete the function
maxGold() which takes the values n, m and the mine represented as a 2D array of positive
integeres M as input parameters and returns the maximum amount of gold that can be collected.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
0 ≤ M[i][j] ≤ 100

*******************************************************************************/
import java.util.*;

public class MaxGold{
    
    public static int maxGold(int n, int m, int M[][]){
       int ans=0;
       int[][] a=new int[n][m];
       for(int i=0;i<n;i++)
            a[i][m-1]=M[i][m-1];
       for(int j=m-2;j>=0;j--){ 
           for(int i=0;i<n;i++){
               int d=0;
               if(i+1<n && a[i+1][j+1]>d)
                    d=a[i+1][j+1];
                if(i-1>=0 && a[i-1][j+1]>d)
                    d=a[i-1][j+1];
                if(a[i][j+1]>d)
                    d=a[i][j+1];
                a[i][j]=M[i][j]+d;
           }
       }
       for(int i=0;i<n;i++)
            if(ans<a[i][0])
                ans=a[i][0];
       return ans;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),m=x.nextInt();
		int[][] a=new int[n][m];
		for(int i=0;i<n;i++)
		    for(int j=0;j<m;j++)
		        a[i][j]=x.nextInt();
		System.out.print(maxGold(n,m,a));
	}
}
