/******************************************************************************

Given a Binary Tree of nodes, you need to find all the possible paths from the root 
node to all the leaf nodes of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 
1 2 
1 3 
Explanation: 
All possible paths:
1->2
1->3
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 
10 20 40 
10 20 60 
10 30 
Your Task:
Your task is to complete the function Paths() which takes the root node as an argument
and returns all the possible paths. (All the paths are printed in new lines by the driver's code.)

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the tree)

Constraints:
1<=n<=104

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left=null,right=null;
    public Node(int data){
        this.data=data;
    }
}

public class AllPaths
{
    
    public static void traverse(Node root,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> a){
        if(root==null)
            return;
        a.add(root.data);
        if(root.left==null && root.right==null)
            res.add(new ArrayList<>(a));
        traverse(root.left,res,a);
        traverse(root.right,res,a);
        a.remove(a.size()-1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        traverse(root,res,new ArrayList<>());
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		Node head=null;
		String[] s=x.nextLine().split(" ");
		int i=0;
		head=new Node(Integer.parseInt(s[i++]));
		Queue<Node> q=new LinkedList<>();
		q.add(head);
		while(!q.isEmpty() && i<s.length){
		    Node node=q.remove();
		    if(!s[i].equals("N")){
		        node.left=new Node(Integer.parseInt(s[i]));
		        q.add(node.left);
		    }
		    i++;
		    if(i==s.length)
		        break;
		    if(!s[i].equals("N")){
		        node.right=new Node(Integer.parseInt(s[i]));
		        q.add(node.right);
		    }
		    i++;
		}
		for(ArrayList<Integer> a:Paths(head)){
		    for(int j:a)
		        System.out.print(j+" ");
		    System.out.println();
		}
	}
}
