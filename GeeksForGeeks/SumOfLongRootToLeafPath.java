/******************************************************************************

Given a binary tree having n nodes. Find the sum of all nodes on the longest path 
from root to any leaf node. If two or more paths compete for the longest path, then
the path having maximum sum of nodes will be considered.

Example 1:

Input: 
        4        
       /  \       
      2   5      
     / \   /  \     
    7  1 2  3    
      /
     6
Output: 
13
Explanation:
        4        
       /  \       
      2   5      
     / \   /  \     
    7  1 2  3 
      /
     6
The highlighted nodes (4, 2, 1, 6) above are part of the longest root to leaf path 
having sum = (4 + 2 + 1 + 6) = 13
Example 2:

Input: 
          1
        /   \
       2    3
      / \    /  \
     4   5 6   7
Output: 
11
Explanation:
Use path 1->3->7, with sum 11.
Your Task:
You don't need to read input or print anything. Your task is to complete the function
sumOfLongRootToLeafPath() which takes root node of the tree as input parameter and 
returns an integer denoting the sum of the longest root to leaf path of the tree.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105
0 <= data of each node <= 104

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

public class SumOfLongRootToLeafPath
{
    
    static int res=0,h=1;
    
    public static void inOrder(Node root,int sum,int height){
        if(root==null){ 
            if(height>h){
                res=sum;
                h=height;
            }else if(height==h && res<sum)
                res=sum;
            return;
        }
        inOrder(root.left,sum+root.data,height+1);
        inOrder(root.right,sum+root.data,height+1);
    }
    
    public static int sumOfLongRootToLeafPath(Node root)
    {
        res=0;
        h=1;
        inOrder(root,0,1);
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] a=x.nextLine().split(" ");
		Queue<Node> q=new LinkedList<>();
		int i=0;
		Node head=new Node(Integer.parseInt(a[i++]));
		q.add(head);
		while(!q.isEmpty() && i<a.length){
		    Node node=q.remove();
		    if(!a[i].equals("N")){
		        Node t=new Node(Integer.parseInt(a[i]));
		        node.left=t;
		        q.add(t);
		    }
		    i++;
		    if(i>=a.length)
		        break;
		    if(!a[i].equals("N")){
		        Node t=new Node(Integer.parseInt(a[i]));
		        node.right=t;
		        q.add(t);
		    }
		    i++;
		}
		System.out.println(sumOfLongRootToLeafPath(head));
	}
}
