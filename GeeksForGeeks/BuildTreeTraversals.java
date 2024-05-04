/******************************************************************************

Given inorder and postorder traversals of a binary tree(having n nodes) in the arrays
in[] and post[] respectively. The task is to construct a binary tree from these traversals.

Driver code will print the preorder traversal of the constructed tree.

Example 1:

Input:
n = 8
in[] = {4, 8, 2, 5, 1, 6, 3, 7}
post[] = {8, 4, 5, 2, 6, 7, 3, 1}
Output: 
1 2 4 8 5 3 6 7
Explanation: 
For the given postorder and inorder traversal of tree the  resultant binary tree will be
          1
       /      \
     2        3
   /  \      /  \
  4   5    6   7
   \
    8
Example 2:

Input:
n = 5
in[] = {9, 5, 2, 3, 4}
post[] = {5, 9, 3, 4, 2}
Output: 
2 9 5 4 3
Explanation:  
The  resultant binary tree will be
           2
        /     \
       9      4
        \     /
         5   3
Your Task:
You do not need to read input or print anything. Complete the function buildTree() 
which takes the inorder, postorder traversals and the number of nodes in the tree as
input parameters and returns the root node of the newly constructed Binary Tree.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 103
1 <= in[i], post[i] <= 106

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left=null,right=null;
    public Node(int data){
        this.data=data;
    }
}

public class BuildTreeTraversals
{
    
    public static Node tree(int[] in,int[] post,Map<Integer,Integer> map,int is,int ie,int ps,int pe){
        if(is>ie || ps>pe)
            return null;
        Node root=new Node(post[pe]);
        int id=map.get(post[pe]),left=id-is;
        root.left=tree(in,post,map,is,id-1,ps,ps+left-1);
        root.right=tree(in,post,map,id+1,ie,ps+left,pe-1);
        return root;
    }
    
    public static Node buildTree(int[] in,int[] post,int n){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<in.length;i++)
            map.put(in[i],i);
        return tree(in,post,map,0,n-1,0,n-1);
    }
    
    public static void preOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] in=new int[n],post=new int[n];
		for(int i=0;i<n;i++)
		    in[i]=x.nextInt();
		for(int i=0;i<n;i++)
		    post[i]=x.nextInt();
		Node head=buildTree(in,post,n);
		preOrder(head);
	}
}
