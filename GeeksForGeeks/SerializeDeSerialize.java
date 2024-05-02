/******************************************************************************

Serialization is to store a tree in an array so that it can be later restored and 
deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive 
integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree))
is same as the input tree. Driver code will print the in-order traversal of the tree returned
by deSerialize(serialize(input_tree)).

Example 1:

Input:
      1
    /   \
   2     3
Output: 
2 1 3
Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 
40 20 60 10 30
Your Task:
The task is to complete two functions serialize which takes the root node of the tree 
as input and stores the tree into an array and deSerialize which deserializes the array 
to the original tree and returns the root of it.

Expected Time Complexity: O(Number of nodes).
Expected Auxiliary Space: O(Number of nodes).

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 109



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

public class SerializeDeSerialize
{
    
    public static ArrayList<Integer> serialize(Node root) {
        Node head=null;
        ArrayList<Integer> res=new ArrayList<>();
        res.add(root.data);
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node n=queue.remove();
            if(n.left!=null){
                res.add(n.left.data);
                queue.add(n.left);
            }else
                res.add(-1);
            if(n.right!=null){
                res.add(n.right.data);
                queue.add(n.right);
            }else
                res.add(-1);
        }
        return res;
    }

    public static Node deSerialize(ArrayList<Integer> A) {
        Node head=new Node(A.get(0));
        if(A.size()==1)
            return head;
        int i=1;
        Queue<Node> queue=new LinkedList<>();
        queue.add(head);
        Node node=null;
        while(!queue.isEmpty()){
            Node n=queue.remove();
            if(A.get(i)==-1){
                n.left=null;
                i++;
            }else{
                node=new Node(A.get(i++));
                queue.add(node);
                n.left=node;
                if(i==A.size())
                    break;
            }
            if(A.get(i)==-1){
                n.right=null;
                i++;
            }else{
                node=new Node(A.get(i++));
                queue.add(node);
                n.right=node;
                if(i==A.size())
                    break;
            }
        }
        return head;
    }
    
    
    public static void print(Node root){
        if(root==null)
            return;
        print(root.left);
        System.out.print(root.data+" ");
        print(root.right);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] s=x.nextLine().split(" ");
		ArrayList<Integer> A=new ArrayList<>();
		for(int i=0;i<s.length;i++)
		    if(s[i].equals("N"))
		        A.add(-1);
		    else    
		        A.add(Integer.parseInt(s[i]));
		Node head=buildTree(A);
		ArrayList<Integer> serialize=serialize(head);
		Node deserialize=deSerialize(serialize);
		print(deserialize);
	}
	
	public static Node buildTree(ArrayList<Integer> A) {
        Node head=new Node(A.get(0));
        if(A.size()==1)
            return head;
        int i=1;
        Queue<Node> queue=new LinkedList<>();
        queue.add(head);
        Node node=null;
        while(!queue.isEmpty()){
            Node n=queue.remove();
            if(A.get(i)==-1){
                n.left=null;
                i++;
            }else{
                node=new Node(A.get(i++));
                queue.add(node);
                n.left=node;
                if(i==A.size())
                    break;
            }
            if(A.get(i)==-1){
                n.right=null;
                i++;
            }else{
                node=new Node(A.get(i++));
                queue.add(node);
                n.right=node;
                if(i==A.size())
                    break;
            }
        }
        return head;
    }
    
}
