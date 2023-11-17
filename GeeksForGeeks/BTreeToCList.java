/******************************************************************************

    Given a Binary Tree of N edges. The task is to convert this to a Circular 
Doubly Linked List (CDLL) in-place. The left and right pointers in nodes are to 
be used as previous and next pointers respectively in CDLL. The order of nodes 
in CDLL must be same as Inorder of the given Binary Tree. The first node of Inorder
traversal (left most node in BT) must be head node of the CDLL.

Example 1:

Input:
      1
    /   \
   3     2
Output:
3 1 2 
2 1 3
Explanation: After converting tree to CDLL
when CDLL is is traversed from head to
tail and then tail to head, elements
are displayed as in the output.
Example 2:

Input:
     10
   /    \
  20    30
 /  \
40  60
Output:
40 20 60 10 30 
30 10 60 20 40
Explanation:After converting tree to CDLL,
when CDLL is is traversed from head to
tail and then tail to head, elements
are displayed as in the output.
Your Task:
You don't have to take input or print anything. Complete the function bTreeToCList()
that takes root as a parameter and returns the head of the list. The driver code prints
the linked list twice, first time in the right order, and another time in reverse order.

Constraints:
1 <= N <= 103
0 <= Data of a node <= 104

Expected time complexity: O(N)

Expected auxiliary space: O(h) , where h = height of tree

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

public class BTreeToCList{
    
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
    
    public static void traversal(Node head,ArrayList<Integer> list){
        if(head==null)
            return;
        traversal(head.left,list);
        list.add(head.data);
        traversal(head.right,list);
    }
    
    public static Node bTreeToCList(Node root){
        ArrayList<Integer> list=new ArrayList<Integer>();
        traversal(root,list);
        Node head=new Node(list.get(0));
        Node prev=head;
        for(int i=1;i<list.size();i++){
            Node node=new Node(list.get(i));
            node.left=prev;
            prev.right=node;
            prev=node;
        }
        prev.right=head;
        head.left=prev;
        return head;
    }
    
    public static void displayCList(Node root){
        Node t=root;
        System.out.print(t.data+" ");
        t=t.right;
        while(t!=root){
            System.out.print(t.data+" ");
            t=t.right;
        }
        t=t.left;
        System.out.println();
        while(t!=root){
            System.out.print(t.data+" ");
            t=t.left;
        }
        System.out.print(t.data+" ");
    }
    
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	Node head=binTree(s);
	head=bTreeToCList(head);
	displayCList(head);
	}
}
