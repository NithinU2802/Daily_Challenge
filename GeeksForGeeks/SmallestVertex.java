/******************************************************************************

Vertex cover of an undirected graph is a list of vertices such that every vertex 
not in the vertex cover shares their every edge with the vertices in the vertex cover.
In other words, for every edge in the graph, atleast one of the endpoints of the graph 
should belong to the vertex cover. You will be given an undirected graph G, and your 
task is to determine the smallest possible size of a vertex cover.

Example 1:

Input:
N=5
M=6
edges[][]={{1,2}
           {4, 1},
           {2, 4},
           {3, 4},
           {5, 2},
           {1, 3}}
Output:
3
Explanation:
{2, 3, 4} forms a vertex cover
with the smallest size.
Example 2:

Input:
N=2
M=1
edges[][]={{1,2}} 
Output: 
1 
Explanation: 
Include either node 1 or node 2
in the vertex cover.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function 
vertexCover() which takes the edge list and an integer n for the number of nodes of the
graph as input parameters and returns the size of the smallest possible vertex cover.

Expected Time Complexity: O(M*2N)
Expected Auxiliary Space: O(N2)

 Constraints:
1 <= N <= 16
1 <= M <= N*(N-1)/2
1 <= edges[i][0], edges[i][1] <= N



*******************************************************************************/
import java.util.*;

public class Main
{
    
    static int smallestVertex(int[][] edges,int[] v,int x,int n,int m) {
        if(x >= m)
            return 0;
        int a = edges[x][0],b = edges[x][1];
        
        if(v[a]==0 && v[b]==0){
            v[a]=1;
            int r = 1 + smallestVertex(edges,v,x+1,n,m);
            v[a]=0;
            v[b]=1;
            int t = 1 + smallestVertex(edges,v,x+1,n,m);
            if(t<r)
                r=t;
            v[b]=0;
            return r;
        }
        return smallestVertex(edges,v,x+1,n,m);
    }
    
    public static int vertexCover(int n, int m, int[][] edges) {
        int[] v=new int[1000001];
        return smallestVertex(edges,v,0,n,m);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),m=x.nextInt();
		int[][] a=new int[m][2];
		for(int i=0;i<m;i++){
		    a[i][0]=x.nextInt();
		    a[i][1]=x.nextInt();
		}
		System.out.println(vertexCover(n,m,a));
	}
}
