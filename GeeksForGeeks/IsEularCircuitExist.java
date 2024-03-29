/******************************************************************************

Eulerian Path is a path in a graph that visits every edge exactly once. Eulerian
Circuit is an Eulerian Path that starts and ends on the same vertex. Given the number 
of vertices v and adjacency list adj denoting the graph. Find that there exists the
Euler circuit or not. Return 1 if there exist  alteast one eulerian path else 0.

Example 1:

Input: 
v = 4  n=4
edges[] = {{0, 1}, 
           {0, 2}, 
           {1, 3}, 
           {2, 3}}

Output: 
1
Explanation: corresponding adjacency list will be {{1, 2},{0, 3},{0, 3},{1, 2}}
One of the Eularian circuit 
starting from vertex 0 is as follows:
0->1->3->2->0
Example 2:

Input: 
v = 3 n=2
edges[] = {{0, 1}, 
         {0, 2}}
         

Output: 
0
Explanation: corresponding adjacency list will be {{1, 2}}
No Eulerian path is found.
Your Task:
You don't need to read or print anything. Your task is to complete the function 
isEularCircuitExist() which takes v and adjacency list adj[] as input parameter 
and returns boolean value 1 if Eular circuit exists otherwise returns 0.

Expected Time Complexity: O(v + e)
Expected Space Complexity: O(v)

Constraints:
1 <= v <= 105
1 <= edges <= 2*105



*******************************************************************************/
import java.util.*;

public class IsEularCircuitExist
{
    
 //   boolean res=false;

    
    static boolean check(int v,ArrayList<ArrayList<Integer>> a,int c,int[] visit){ 
        if(visit[c]==1 && c==v){
            for(int i:visit)
                if(i==0)
                    return false;
            return true;
        }
        for (int i : a.get(c)) {
            if(visit[i]==0){
                visit[i]=1;
                if (check(v,a,i,visit))
                    return true;
                visit[i]=0;
            }
        }
        for(int i:visit)
                if(i==0)
                    return false;
        return true;
    }
    
    // Another Method: Degree of every element is always even for eular 
    
    public static boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) { 
        if(v<=2)
            return false;
        for(int j=0;j<v;j++){
            int[] visit=new int[v];
            if(check(j,adj,j,visit))
                return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		int v=x.nextInt(),n=x.nextInt();
		for(int i=0;i<v;i++)
		    adj.add(new ArrayList<>());
		for(int i=0;i<n;i++){
		    int d=x.nextInt(),e=x.nextInt();
		    adj.get(d).add(e);
		    adj.get(e).add(d);
		}
		if(isEularCircuitExist(v,adj))
		    System.out.println(1);
		else
		    System.out.println(0);
	}
}
