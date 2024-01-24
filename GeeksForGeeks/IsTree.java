/******************************************************************************

You are given an undirected graph of N nodes (numbered from 0 to N-1) and M edges.
Return 1 if the graph is a tree, else return 0.

Note: The input graph can have self-loops and multiple edges.

Example 1:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [1, 3]]
Output: 
1
Explanation: 
Every node is reachable and the graph has no loops, so it is a tree
Example 2:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [2, 0]]
Output: 
0
Explanation: 
3 is not connected to any node and there is a loop 0->1->2->0, so it is not a tree.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function 
isTree() which takes the integer N (the number nodes in the input graph) and the edges 
representing the graph as input parameters and returns 1 if the input graph is a tree, else 0.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 2*105
0 <= M <= 2*105
*******************************************************************************/
import java.util.*;

public class IsTree
{
    
    public static boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        boolean[] a=new boolean[n];
        if(m==0)
            return n<=1;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(u).add(v);
            map.get(v).add(u);
            set.add(u);
            set.add(v);
        }
        if (cycle(map, a, 0, -1))
            return false;
        return set.size()==n;
    }
    
    static boolean cycle(HashMap<Integer, List<Integer>> map, boolean[] a, int i, int b) {
        a[i] = true;

        if (map.containsKey(i))
            for (int j : map.get(i)) {
                if (!a[j]) {
                    if (cycle(map, a, j, i)) 
                        return true;
                } else if (j != b)
                    return true; 
            }

        return false;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),m=x.nextInt();
		ArrayList<ArrayList<Integer>> a=new ArrayList<>();
		for(int i=0;i<m;i++){
		    ArrayList<Integer> b=new ArrayList<Integer>();
		    b.add(x.nextInt());
		    b.add(x.nextInt());
		    a.add(b);
		}
		if(isTree(n,m,a))
		    System.out.println(1);
		else    
		    System.out.println(0);
	}
}
