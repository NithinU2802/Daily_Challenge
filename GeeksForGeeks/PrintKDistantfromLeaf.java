/******************************************************************************

    Given a binary tree with n nodes and a non-negative integer k, the task is to count
the number of special nodes.
A node is considered special if there exists at least one leaf in its subtree such
that the distance between the node and leaf is exactly k.

Note: Any such node should be counted only once. For example, if a node is at a 
distance k from 2 or more leaf nodes, then it would add only 1 to our count.

Example 1:

Input:
Binary tree
        1
      /   \
     2     3
   /  \   /  \
  4   5  6    7
          \ 
          8
k = 2
Output: 
2
Explanation: 
    There are only two unique nodes that are at a distance of 2 units from the leaf 
node. (node 3 for leaf with value 8 and node 1 for leaves with values 4, 5 and 7) Note
that node 2 isn't considered for leaf with value 8 because it isn't a direct ancestor of node 8.

Example 2:
Input:
Binary tree
          1
         /
        3
       /
      5
    /  \
   7    8
         \
          9
k = 4
Output: 
1
Explanation: 
Only one node is there which is at a distance of 4 units from the leaf node.(node 1 for leaf with value 9) 
Your Task:
You don't have to read input or print anything. Complete the function printKDistantfromLeaf() that takes root node and k as inputs and returns the number of nodes that are at distance k from a leaf node. 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 105

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
    }
}

public class PrintKDistantfromLeaf
{
    
    static boolean check(Node root,int k){
        if(root==null)
            return false;
        if((root.left==null && root.right==null) && k==0)
            return true;
        if((root.left==null && root.right==null) && k<=0)
            return false;
        return check(root.left,k-1) || check(root.right,k-1);
    }
    
    static int printKDistantfromLeaf(Node root, int k)
    {
        if(root==null)
            return 0;
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        int res=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node t=queue.remove();
                if(check(t,k))
                    res++;
                if(t.left!=null)
                    queue.add(t.left);
                if(t.right!=null)
                    queue.add(t.right);
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] a=x.nextLine().split(" ");
		int n=a.length;
		int k=x.nextInt();
		Queue<Node> queue=new LinkedList<>();
		int i=1;
		Node head=new Node(Integer.parseInt(a[0]));
		queue.add(head);
		while(!queue.isEmpty()){
		    int m=queue.size();
		    for(int j=0;j<m;j++){
		        Node t=queue.remove();
		        if(t.left==null){
		            if(a[i].equals("N"))
		                t.left=null;
		           else
		                t.left=new Node(Integer.parseInt(a[i]));
		            i++;
		        }
		        if(i==n)
		            break;
		        if(t.right==null){
		            if(a[i].equals("N"))
		                t.right=null;
		           else
		                t.right=new Node(Integer.parseInt(a[i]));
		            i++;
		        }
		        if(i==n)
		            break;
		    }
		    if(i==n)
		            break;
		}
		System.out.println(printKDistantfromLeaf(head,k));
	}
}
