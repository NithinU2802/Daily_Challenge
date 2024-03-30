/******************************************************************************

Given the root of a Binary Search Tree. The task is to find the minimum valued 
element in this given BST.

Example 1:

Input:
           5
         /    \
        4      6
       /        \
      3          7
     /
    1
Output: 1
Example 2:

Input:
             9
              \
               10
                \
                 11
Output: 9
Your Task:
The task is to complete the function minValue() which takes root as the argument
and returns the minimum element of BST. If the tree is empty, there is no minimum 
element, so return -1 in that case.

Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(1).

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}

public class MinValueBST
{
    
    static int minEle(Node root,int min){
        if(root==null)
            return min;
        if(root.data<min)
            min=root.data;
        int left=minEle(root.left,min),right=minEle(root.right,min);
        if(left<right)
            return left;
        else
            return right;
    }
    
    static int minValue(Node root) {
        if(root==null)
            return 0;
        return minEle(root,root.data);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] s=x.nextLine().split(" ");
		int i=0;
		if(s[i].equals("N")){
		    System.out.println("No Tree Found");
		    return;
		}
		Queue<Node> q=new LinkedList<>();
		Node head=new Node(Integer.parseInt(s[i++]));
		q.add(head);
		while(i<s.length){
		    Node node=q.remove();
		    if(!s[i].equals("N")){
		        Node n=new Node(Integer.parseInt(s[i++]));
		        q.add(n);
		        node.left=n;
		    }else
		        i++;
		    if(i>=s.length)
		        break;
		    if(!s[i].equals("N")){
		        Node n=new Node(Integer.parseInt(s[i++]));
		        q.add(n);
		        node.right=n;
		    }else
		        i++;
		}
		System.out.println(minValue(head));
	}
}
