/******************************************************************************

Given two binary trees, the task is to find if both of them are identical or not.
Note: You need to return true or false, the printing is done by the driver code.

Example 1:

Input:
     1          1
   /   \      /   \
  2     3    2     3
Output: 
Yes

Explanation: 
There are two trees both having 3 nodes and 2 edges, both trees are identical having 
the root as 1, left child of 1 is 2 and right child of 1 is 3.


Example 2:

Input:
    1       1
  /  \     /  \
 2    3   3    2
Output: 
No

Explanation: There are two trees both having 3 nodes and 2 edges, but both trees are
not identical.
Your task:
Since this is a functional problem you don't have to worry about input, you just have
to complete the function isIdentical() that takes two roots as parameters and returns
true or false. The printing is done by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 105
1 <=Data of a node <= 109



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

public class IsIdentical
{
    
    public static boolean isIdentical(Node head1,Node head2){
        if(head1==null && head2==null)
            return true;
        if(head2.data!=head1.data)
            return false;
        if(head1==null || head2==null)
            return false;
        return isIdentical(head1.left,head2.left) && isIdentical(head1.right,head2.right);
    }
    
    public static Node buildTree(String s){
        String[] a=s.split(" ");
        Queue<Node> queue=new LinkedList<Node>();
        Node root=new Node(Integer.parseInt(a[0]));
        queue.add(root);
        int i=1;
        while(queue.size()>0 && i<a.length){
            Node node=queue.remove();
            String t=a[i];
            if(!t.equals("N")){
                node.left=new Node(Integer.parseInt(t));
                queue.add(node.left);
            }
            i++;
            if(i>=a.length)
                break;
            t=a[i];
            if(!t.equals("N")){
                node.right=new Node(Integer.parseInt(t));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
    
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	Node head1=buildTree(s);
	s=x.nextLine();
	Node head2=buildTree(s);
	if(isIdentical(head1,head2))
	    System.out.println("Yes");
	else 
	    System.out.println("No");
	}
}
