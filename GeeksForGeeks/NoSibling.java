/******************************************************************************

    Given a Binary Tree of n nodes, find all the nodes that don't have any siblings.
You need to return a list of integers containing all the nodes that don't have a 
sibling in sorted order (Increasing).

Two nodes are said to be siblings if they are present at the same level, and their
parents are the same.

Note: The root node can not have a sibling so it cannot be included in our answer.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 
20 113
Explanation: 
Nodes 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: 
-1
Explanation: 
Every node has a sibling.
Your Task:  
    You don't need to read input or print anything. Complete the function noSibling()
which takes the root of the tree as input parameter and returns a list of integers
containing all the nodes that don't have a sibling in sorted order. If all nodes
have a sibling, then the returning list should contain only one element -1.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(Height of the tree)

Constraints:
1 ≤ n ≤ 104



*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left=null,right=null;
    public Node(int data){
        this.data=data;
    }
}

public class NoSibling
{
    
    public static void traverse(Node root,ArrayList<Integer> res){
        if(root==null)
            return;
        if(root.left==null && root.right!=null)
            res.add(root.right.data);
        if(root.right==null && root.left!=null)
            res.add(root.left.data);
        traverse(root.left,res);
        traverse(root.right,res);
    }
    
    static ArrayList<Integer> noSibling(Node node)
    {
        ArrayList<Integer> res=new ArrayList<>();
        traverse(node,res);
        if(res.size()==0)
            res.add(-1);
        Collections.sort(res);
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] s=x.nextLine().split(" ");
		int i=0;
		Queue<Node> q=new LinkedList<>();
		Node head=new Node(Integer.parseInt(s[i++]));
		q.add(head);
		while(i<s.length && !q.isEmpty()){
		    Node r=q.remove();
		    if(!s[i].equals("N")){
		        r.left=new Node(Integer.parseInt(s[i]));
		        q.add(r.left);
		    }
		    i++;
		    if(i==s.length)
		        break;
		    if(!s[i].equals("N")){
		        r.right=new Node(Integer.parseInt(s[i]));
		        q.add(r.right);
		    }
		    i++;
		}
		for(int j:noSibling(head))
		    System.out.print(j+" ");
	}
}
