/******************************************************************************

 Given a Binary Search Tree that contains unique positive integer values greater
 than 0. The task is to complete the function isDeadEnd which returns true if the
 BST contains a dead end else returns false. Here Dead End means a leaf node, at 
 which no other node can be inserted.

Example 1:

Input :   
               8
             /   \ 
           5      9
         /  \     
        2    7 
       /
      1     
          
Output : 
Yes
Explanation : 
Node 1 is a Dead End in the given BST.
Example 2:

Input :     
              8
            /   \ 
           7     10
         /      /   \
        2      9     13

Output : 
Yes
Explanation : 
Node 9 is a Dead End in the given BST.
Your Task: You don't have to input or print anything. Complete the function isDeadEnd()
which takes BST as input and returns a boolean value.

Expected Time Complexity: O(N), where N is the number of nodes in the BST.
Expected Space Complexity: O(N)

Constraints:
1 <= N <= 1001
1 <= Value of Nodes <= 10001

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

public class IsDeadEnd
{
    
    static Node root=null;
    
    static void insert(int a){
        root=insert(root,a);
    }
    
    public static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static Node insert(Node root,int a){
        if(root==null)
            root=new Node(a);
        else{
            if(a<root.data)
                root.left=insert(root.left,a);
            else if(a>root.data)
                root.right=insert(root.right,a);
        }
        return root;
    }
    
    public static int check(Node root,int a,int b){
        if(root==null)
            return 0;
        if(a==b)
            return 1;
        a=check(root.left,a,root.data-1);
        b=check(root.right,root.data+1,b);
        return a|b;
    }
    
    public static int isDeadEnd(Node root){
        return check(root,1,10001);
    }

    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		for(int i=0;i<n;i++)
		    insert(x.nextInt());
	    System.out.println(isDeadEnd(root));
	}
}
