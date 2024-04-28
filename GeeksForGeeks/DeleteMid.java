/******************************************************************************

Given a singly linked list, delete middle of the linked list. For example, if given 
linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5.
If there are even nodes, then there would be two middle nodes, we need to delete the
second middle element. For example, if given linked list is 1->2->3->4->5->6 then it
should be modified to 1->2->3->5->6.
If the input linked list has single node, then it should return NULL.

Example 1:

Input:
LinkedList: 1->2->3->4->5
Output: 
1 2 4 5
Example 2:

Input:
LinkedList: 2->4->6->7->5->1
Output: 
2 4 6 5 1
Your Task:
The task is to complete the function deleteMid() which takes head of the linkedlist  
and return head of the linkedlist with middle element deleted from the linked list. 
If the linked list is empty or contains single element then it should return NULL.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= n <= 105
1 <= value[i] <= 109

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
}

public class DeleteMid
{
    
    static Node deleteMid(Node head) {
        if(head.next==null)
            return null;
        Node f=head.next,s=head;
        while(f.next!=null && f.next.next!=null){
            f=f.next.next;
            s=s.next;
        }
        s.next=s.next.next;
        return head;
    }
    
    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] s=x.nextLine().split(" ");
		Node head=null,prev=null;
		for(String i:s){
		    Node node=new Node(Integer.parseInt(i));
		    if(head==null)
		        head=node;
		    else
		        prev.next=node;
		    prev=node;
		}
		head=deleteMid(head);
		print(head);
	}
}
