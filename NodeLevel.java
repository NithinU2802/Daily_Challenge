/******************************************************************************

Given an integer X and an undirected acyclic graph with V nodes, labeled from 0 to
V-1, and E edges, find the level of node labeled as X.

Level is the minimum number of edges you must travel from the node 0 to some target.

If there doesn't exists such a node that is labeled as X, return -1.

Example 1:

Input:

X = 4
Output:
2
Explanation:

We can clearly see that Node 4 lies at Level 2.
Example 2:

Input:

X = 1
Output:
1
Explanation:
Node 1 lies at level 1, immediate after Node 0.
Your task:
You dont need to read input or print anything. Your task is to complete the function
nodeLevel() which takes two integers V and X denoting the number of vertices and the
node, and another adjacency list adj as input parameters and returns the level of Node X.
If node X isn't present it returns -1.

Expected Time Complexity: O(V)
Expected Auxiliary Space: O(V)

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ 104
0 ≤ adji, j < V
1 ≤ X < V
Graph doesn't contain multiple edges and self loops.

*******************************************************************************/
import java.util.*;

public class NodeLevel
{
    
    public static int nodeLevel(int V,List<List<Integer>> adj,int X){
        Stack<Integer> s=new Stack<Integer>();
        Stack<Integer> a=new Stack<Integer>();
        s.add(0);
        a.add(0);
        boolean[] visit=new boolean[V];
        while(!s.isEmpty()){
            int n=s.pop(),l=a.pop();
            if(n==X)
                return l;
            visit[n]=true;
            for(int i:adj.get(n))
                if(!visit[i]){
                    s.add(i);
                    a.add(l+1);
                }
        }
        return -1;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int vertex=x.nextInt();
	int edge=x.nextInt();
	List<List<Integer>> graph=new ArrayList<List<Integer>>();
	for(int i=0;i<vertex;i++)
	    graph.add(new ArrayList<Integer>());
	for(int i=0;i<edge;i++){
	    int v=x.nextInt(),e=x.nextInt();
	    graph.get(v).add(e);
	}
	int X=x.nextInt();
	System.out.println(nodeLevel(vertex,graph,X));
	}
}
