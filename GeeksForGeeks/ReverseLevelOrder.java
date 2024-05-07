/******************************************************************************

Given a binary tree of size n, find its reverse level order traversal. ie- the traversal
must begin from the last level.

Example 1:

Input :
        1
      /   \
     3     2

Output: 
3 2 1
Explanation:
Traversing level 1 : 3 2
Traversing level 0 : 1
Example 2:

Input :
       10
      /  \
     20   30
    / \ 
   40  60

Output: 
40 60 20 30 10
Explanation:
Traversing level 2 : 40 60
Traversing level 1 : 20 30
Traversing level 0 : 10
Your Task: 
You don't need to read input or print anything. Complete the function reverseLevelOrder()
which takes the root of the tree as input parameter and returns a list containing the reverse
level order traversal of the given tree.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

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

public class ReverseLevelOrder
{
    
    public static ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            node=q.remove();
            res.add(node.data);
            if(node.right!=null)
                q.add(node.right);
            if(node.left!=null)
                q.add(node.left);
        }
        Collections.reverse(res);
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] s=x.nextLine().split(" ");
		Queue<Node> q=new LinkedList<>();
		int i=0;
		Node head=new Node(Integer.parseInt(s[i++]));
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
		for(int j:reverseLevelOrder(head))
		    System.out.print(j+" ");
	}
}
