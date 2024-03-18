/******************************************************************************

Given a root of a binary tree with n nodes, find its level order traversal.
Level order traversal of a tree is breadth-first traversal for the tree.

Example 1:

Input:
    1
  /   \ 
 3     2
Output:
1 3 2
Example 2:

Input:
        10
     /      \
    20       30
  /   \
 40   60
Output:
10 20 30 40 60
Your Task:
You don't have to take any input. Complete the function levelOrder() that takes 
the root node as input parameter and returns a list of integers containing the 
level order traversal of the given Binary Tree.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 105
0 ≤ Data of a node ≤ 109



*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}

public class LevelOrder
{
    static ArrayList <Integer> levelOrder(Node root) 
    {
        Queue<Node> q=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node n=q.remove();
            res.add(n.data);
            if(n.left!=null)
                q.add(n.left);
            if(n.right!=null)
                q.add(n.right);
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
	    String[] s=x.nextLine().split(" ");
	    int i=0;
	    Queue<Node> q=new LinkedList<>();
	    Node head=new Node(Integer.parseInt(s[i++]));
	    q.add(head);
	    while(i<s.length){
	        Node node=q.poll();
	        if(!s[i].equals("N")){
	            node.left=new Node(Integer.parseInt(s[i]));
	            q.add(node.left);
	        }
	        i++;
	        if(i<s.length && !s[i].equals("N")){
	            node.right=new Node(Integer.parseInt(s[i]));
	            q.add(node.right);
	        }
	        i++;
	    }
		for(int j:levelOrder(head))
		    System.out.print(j+" ");
	}
}
