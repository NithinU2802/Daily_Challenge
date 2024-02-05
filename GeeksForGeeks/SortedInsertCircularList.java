/******************************************************************************

Given a sorted circular linked list of length n, the task is to insert a new node
in this circular list so that it remains a sorted circular linked list.

Example 1:

Input:
n = 3
LinkedList = 1->2->4
(the first and last node is connected, i.e. 4 --> 1)
data = 2
Output: 
1 2 2 4
Explanation:
We can add 2 after the second node.
Example 2:

Input:
n = 4
LinkedList = 1->4->7->9
(the first and last node is connected, i.e. 9 --> 1)
data = 5
Output: 
1 4 5 7 9
Explanation:
We can add 5 after the second node.
Your Task:
The task is to complete the function sortedInsert() which should insert the new 
node into the given circular linked list and return the head of the linked list.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
0 <= n <= 105

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}

public class SortedInsertCircularList
{
    public static Node sortedInsert(Node head, int data) {
       if(head==null){
            Node node= new Node(data);
            node.next=node;
            return node;
       }
       if(head.data>=data){
           Node node=new Node(data);
           node.next=head;
           Node t=head;
           while(t.next!=head)
                t=t.next;
           t.next=node;
           head=node;
           return head;
       }
    Node node=new Node(data);
    //   Node t=head,fst=t,prev=t;
    //   t=t.next;
    //   while(fst.data==t.data)
    //         t=t.next;
    //   while(t!=fst && fst.data!=t.data && t.data<data){ 
    //       prev=t;
    //       t=t.next;
    //   }
    //   prev.next=node;
    //   node.next=t;
        Node t = head;
        while (t.next != head && data > t.next.data)
            t = t.next;
        node.next = t.next;
        t.next = node;
       return head;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		Node head=null,prev=null;
		for(int i=0;i<n;i++){
		    Node node=new Node(x.nextInt());
		    if(head==null){
		        head=node;
		        node.next=head;
		    }else{
		        prev.next=node;
		        node.next=head;
		    }
		    prev=node;
		}
		int data=x.nextInt();
		head=sortedInsert(head,data);
		Node t=head;
		System.out.print(t.data+" ");
		t=t.next;
		while(t!=head){
		    System.out.print(t.data+" ");
		    t=t.next;
		}
	}
}
