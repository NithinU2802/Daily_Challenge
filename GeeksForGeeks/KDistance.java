/******************************************************************************

Given a binary tree having n nodes and an integer k. Print all nodes that are at
distance k from the root (root is considered at distance 0 from itself). Nodes 
should be printed from left to right.

Example 1:

Input:
k = 0
      1
    /   \
   3     2
Output: 
1
Explanation: 
1 is the only node which is 0 distance from the root 1.
Example 2:

Input:
k = 3
        1
       /
      2
       \
        1
      /  \
     5    3
Output: 
5 3
Explanation:  
5 and 3 are the nodes which are at distance 3 from the root 3.
Here, returning 3 5 will be incorrect.
Your Task:
You don't have to take input. Complete the function Kdistance() that accepts root
node and k as parameters and returns the value of the nodes that are at a distance
k from the root.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 104
0 <= k <= 30

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left=null,right=null;
    public Node(int data){
        this.data=data;
    }
}

public class KDistance
{
    
    static void traverse(Node root,int d,ArrayList<Integer> res,int k){
         if(root==null)
            return;
         traverse(root.left,d+1,res,k);
         if(d==k)
            res.add(root.data);
         traverse(root.right,d+1,res,k);
     }
     
     static ArrayList<Integer> Kdistance(Node root, int k)
     {
          ArrayList<Integer> res=new ArrayList<>();
          if(k==0){
            res.add(root.data);
            return res;
          }
          traverse(root,0,res,k);
          return res;
     }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] s=x.nextLine().split(" ");
		Queue<Node> queue=new LinkedList<>();
		Node head=new Node(Integer.parseInt(s[0]));
		queue.add(head);
		int i=1;
		while(!queue.isEmpty() && i<s.length){
		    Node n=queue.remove();
		    if(!s[i].equals("N")){
		        n.left=new Node(Integer.parseInt(s[i]));
		        queue.add(n.left);
		    }
		    i++;
		    if(i==s.length)
		        break;
		    if(!s[i].equals("N")){
		        n.right=new Node(Integer.parseInt(s[i]));
		        queue.add(n.right);
		    }
		    i++;
		}
		int k=x.nextInt();
		for(int j:Kdistance(head,k))
		    System.out.print(j+" ");
	}
}
