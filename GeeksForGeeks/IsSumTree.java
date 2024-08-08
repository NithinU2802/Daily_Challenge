/******************************************************************************

    Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return
true if it is a Sum Tree otherwise, return false.

    A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes
present in its left subtree and right subtree. An empty tree is also a Sum Tree as the
sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.

Examples :
Input:
    3
  /   \    
 1     2
Output: true
Explanation: The sum of left subtree and right subtree is 1 + 2 = 3, which is the value 
of the root node. Therefore,the given binary tree is a sum tree.

Input:
          10
        /    \
      20      30
    /   \ 
   10    10
Output: false
Explanation: The given tree is not a sum tree. For the root node, sum of elements in left subtree is 40 and sum of elements in right subtree is 30. Root element = 10 which is not equal to 30+40.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(Height of the Tree)

Constraints:
2 ≤ number of nodes ≤ 105
1 ≤ node value ≤ 105



*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class IsSumTree
{
    
    public static int sum(Node root){
        if(root==null)
            return 0;
        int a=sum(root.left),b=sum(root.right);
        return a+b+root.data;
    }
    
    static boolean isSumTree(Node root) {
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        if(sum(root.right)+sum(root.left)==root.data)
            return isSumTree(root.left) && isSumTree(root.right);
        return false;
    }
    
    public static Node binTree(String s){
        String[] elements=s.split(" ");
        if(elements.length==0 || elements[0].charAt(0)=='N')
            return null;
        Node root=new Node(Integer.parseInt(elements[0]));
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty() && i<elements.length){
            Node t=queue.remove();
            String st=elements[i];
            if(!st.equals("N")){
                t.left=new Node(Integer.parseInt(st));
                queue.add(t.left); 
            }
            i++;
            if(i>=elements.length)
                break;
            st=elements[i];
            if(!st.equals("N")){
                t.right=new Node(Integer.parseInt(st));
                queue.add(t.right);
            }
            i++;
        }
        return root;
    }
    
	public static void main(String[] args) {
	    Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		Node head=binTree(s);
		System.out.print(isSumTree(head));
	}
}
