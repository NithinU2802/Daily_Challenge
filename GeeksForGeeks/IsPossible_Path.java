/******************************************************************************

You are presented with an undirected connected graph consisting of n vertices and
connections between them represented by an adjacency matrix. Your objective is to 
determine whether it is possible to start traversing from a node, x, and return to
it after traversing all the vertices at least once, using each edge exactly once.

Example 1:

Input: 
paths = 0 1 1 1 1
        1 0 0 1 0
        1 0 0 1 0
        1 1 1 0 1
        1 0 0 1 0
Output: 1
Explanation: 
One can visit the vertices in the following way:
1->3->4->5->1->4->2->1 (assuming 1-based indexing)
Here all the vertices has been visited and all
paths are used exactly once.
Example 2:

Input: 
paths = 0 1 1 0
        1 0 1 1
        1 1 0 0
        0 1 0 0
Output: 0
Explanation: 
There exists no such vertex from which all the 
vertices could be visited and all edges are used 
exactly once.
Your Task:
You don't need to read or print anything. Your task is to complete the function 
isPossible() which takes adjacency matrix paths as an input parameter and returns
1 if it is possible to start traversing from a node, x, and come back to it after
traversing all the vertices at least once, using each edge exactly once.

 Expected Time Complexity: O(n2)
Expected Space Compelxity: O(1)

*******************************************************************************/
import java.util.*;

public class IsPossible_Path
{   
    public static int isPossible(int[][] paths)
    {
        for (int i = 0; i < paths.length; i++) {
            int c = 0;
            for (int j = 0; j < paths.length; j++) 
                if (paths[i][j] == 1)
                    c++;
            if (c % 2 != 0)
                return 0;
        }
        
        return 1;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++)
		        a[i][j]=x.nextInt();
		System.out.println(isPossible(a));
	}
}
