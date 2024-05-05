/******************************************************************************

    Given a binary tree having n nodes, find the vertical sum of the nodes that are in
the same vertical line. Return all sums through different vertical lines starting 
from the left-most vertical line to the right-most vertical line.

Example 1:

Input:
       1
    /    \
  2      3
 /  \    /  \
4   5  6   7
Output: 
4 2 12 3 7
Explanation:
The tree has 5 vertical lines
Line 1 has only one node 4 => vertical sum is 4.
Line 2 has only one node 2 => vertical sum is 2.
Line-3 has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12.
Line-4 has only one node 3 => vertical sum is 3.
Line-5 has only one node 7 => vertical sum is 7.
Example 2:

Input:
          1
         /
        2
       /
      3
     /
    4
   /
  6
 /
7
Output: 
7 6 4 3 2 1
Explanation:
There are six vertical lines each having one node.
Your Task:
    You don't need to take input. Just complete the function verticalSum() that takes 
root node of the tree as parameter and returns an array containing the vertical 
sum of tree from left to right.

Expected Time Complexity: O(nlogn).
Expected Auxiliary Space: O(n).

Constraints:
1<=n<=104
1<= Node value <= 105

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node left=null,right=null;
    public Node(int data){
        this.data=data;
    }
}

public class VerticalSum
{
    
    public static void traverse(Node root,Map<Integer,Integer> map,int k){
        if(root==null)
            return;
        map.put(k,map.getOrDefault(k,0)+root.data);
        traverse(root.left,map,k-1);
        traverse(root.right,map,k+1);
    }
    
    public static ArrayList <Integer> verticalSum(Node root) {
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        traverse(root,map,0);
        for(Map.Entry<Integer,Integer> i:map.entrySet())
            res.add(i.getValue());
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		Node head=null,node=null,prev=null;
		Queue<Node> queue=new LinkedList<>();
		String[] s=x.nextLine().split(" ");
		head=new Node(Integer.parseInt(s[0]));
		queue.add(head);
		int i=1;
		while(!queue.isEmpty() && i<s.length){
		    node=queue.remove();
		    if(!s[i].equals("N")){
		        node.left=new Node(Integer.parseInt(s[i]));
		        queue.add(node.left);
		    }
		    i++;
		    if(i==s.length)
		        break;
		    if(!s[i].equals("N")){
		        node.right=new Node(Integer.parseInt(s[i]));
		        queue.add(node.right);
		    }
		    i++;
		}
		for(int j:verticalSum(head))
		    System.out.print(j+" ");
	}
}
