/******************************************************************************

Given an AVL tree and N values to be inserted in the tree. Write a function to insert
elements into the given AVL tree.

Note:
The tree will be checked after each insertion. 
If it violates the properties of balanced BST, an error message will be printed followed
by the inorder traversal of the tree at that moment.
If instead all insertions are successful, inorder traversal of the tree will be printed.

Example 1:

Input:
N = 3
Values to be inserted = {5,1,4} 
Output:
1 4 5
Explanation:
Value to be inserted = 5
    5
Value to be inserted = 1
    5
   /
  1
Value to be inserted = 4
  5                     4
 /    LR rotation        /  \
1    ----------->       1   5
 \
 4
Therefore the inorder of the final tree will be 1, 4, 5.
Example 2:

Input:
N = 7
Values to be inserted = {21,26,30,9,4,14,28} 
Output:
4 9 14 21 26 28 30
Explanation:
Value to be inserted = 21
    21
Value to be inserted = 26
    21
     \
     26
Value to be inserted = 30
  21                        26
   \      LL rotation         /  \
   26    ----------->       21  30
    \
     30
Value to be inserted = 9
    26
   /  \
  21  30
 /
9
Value to be inserted = 4
      26                          26
     /  \                          /  \
    21  30                      9   30
   /          RR rotation        /  \
  9          ----------->       4  21
 /
4
Value to be inserted = 14
      26                          21
     /  \                          /  \
    9   30                      9   26
   / \          LR rotation      /  \    \
  4  21        ----------->    4  14  30
     /
    14
Value to be inserted = 28
      21                          21
     /  \                          /  \
    9   26                      9   28
   / \    \     RL rotation       / \    / \
  4  14   30   ----------->   4  14 26 30
          /
         28
Therefore the inorder of the final tree will be 4, 9, 14, 21, 26, 28, 30.
Your Task:  
You don't need to read input or print anything. Complete the function insertToAVL()
which takes the root of the tree and the value of the node to be inserted as input 
parameters and returns the root of the modified tree.

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ N ≤ 2000

*******************************************************************************/
import java.util.*;

class Node{
    int data,height;
    Node left,right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
        this.height=0;
    }
}

public class InsertToAVL
{
    
    public static int getBalance(Node node){
        if(node==null)
            return 0;
        int a=0,b=0;
        if(node.left!=null)
            a=node.left.height;
        if(node.right!=null)
            b=node.right.height;
        return a-b;
    }
    
    public static Node rotateRight(Node y) {
    Node x = y.left;
    Node T2 = x.right;
    x.right = y;
    y.left = T2;
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;
    return x;
  }

  public static Node rotateLeft(Node x) {
    Node y = x.right;
    Node T2 = y.left;
    y.left = x;
    x.right = T2;
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;
    return y;
  }
  
  public static int max(int a,int b){
      if(a>b)
        return a;
    return b;
  }
  
  public static int height(Node node){
      if(node==null)
        return 0;
      return node.height;
  }
    
    public static Node insertToAVL(Node node,int data)
    {
        if(node==null)
            return new Node(data);
        if(node.data>data)
            node.left=insertToAVL(node.left,data);
        else if(node.data<data)
            node.right=insertToAVL(node.right,data);
        else
            return node;
        int a=0,b=0;
        if(node.left!=null)
            a=node.left.height;
        if(node.right!=null)
            b=node.right.height;
        node.height=1+Math.max(a,b);
        int balance=getBalance(node);
        if(balance>1 && node.left!=null){
            if(data<node.left.data)
                return rotateRight(node);
            else if(data>node.left.data){
                node.left=rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        if(balance<-1 && node.right!=null){
            if(data>node.right.data)
                return rotateLeft(node);
            else if(data<node.right.data){
                node.right=rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }

    public static void display(Node head){
        if(head!=null){
            display(head.left);
            System.out.print(head.data+" ");
            display(head.right);
        }
    }

	public static void main(String[] args) {
	    Scanner x=new Scanner(System.in);
	    int n=x.nextInt();
	    Node head=null;
	    for(int i=0;i<n;i++)
	        head=insertToAVL(head,x.nextInt());
	    display(head);
	}
}
