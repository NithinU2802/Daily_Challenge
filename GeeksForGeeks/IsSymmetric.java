/******************************************************************************

Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary
tree is a Mirror image of itself or not.

Example 1:

Input:
         5
       /   \
      1     1
     /       \
    2         2
Output: 
True
Explanation: 
Tree is mirror image of itself i.e. tree is symmetric
Example 2:

Input:
         5
       /   \
      10     10
     /  \     \
    20  20     30
Output: 
False
Your Task:
You don't need to read input or print anything. Your task is to complete the function
isSymmetric() which takes the root of the Binary Tree as its input and returns True 
if the given Binary Tree is the same as the Mirror image of itself. Else, it returns False.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0<=N<=105

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

public class IsSymmetric
{
    
    public static Node buildTree(String s){
        String[] d=s.split(" ");
        Queue<Node> queue=new LinkedList<Node>();
        Node head=new Node(Integer.parseInt(d[0]));
        queue.add(head);
        int i=1;
        while(queue.size()>0 && i<d.length){
            Node t=queue.remove();
            String c=d[i];
            if(!c.equals("N")){
                t.left=new Node(Integer.parseInt(c));
                queue.add(t.left);
            }
            i++;
            if(i>=d.length)
                break;
            c=d[i];
            if(!c.equals("N")){
                t.right=new Node(Integer.parseInt(c));
                queue.add(t.right);
            }
            i++;
        }
        return head;
    }
    
    public static boolean isSymmetric(Node root){
        if(root==null)
            return true;
        return check(root.left,root.right);
    }
    
    public static boolean check(Node head1,Node head2){
        if(head1==null && head2==null)
            return true;
        if(head1==null || head2==null)
            return false;
        if(head1.data!=head2.data)
            return false;
        return check(head1.left,head2.right) && check(head1.right,head2.left);
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	Node root=buildTree(s);
	if(isSymmetric(root))
	    System.out.print("True");
	else 
	    System.out.print("False");
	}
}
