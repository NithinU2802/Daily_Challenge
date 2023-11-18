/******************************************************************************

Given a doubly linked list of n elements. Your task is to reverse the doubly linked
list in-place.

Example 1:

Input:
LinkedList: 3 <--> 4 <--> 5
Output: 5 4 3
Example 2:

Input:
LinkedList: 75 <--> 122 <--> 59 <--> 196
Output: 196 59 122 75
Your Task:
Your task is to complete the given function reverseDLL(), which takes head reference
as argument and this function should reverse the elements such that the tail becomes
the new head and all pointers are pointing in the right order. You need to return the
new head of the reversed list. The printing and verification is done by the driver code.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= number of nodes <= 10^4
0 <= value of nodes <= 10^4

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node prev,next;
    Node(int data){
        this.data=data;
        prev=null;
        next=null;
    }
}

public class ReverseDLL
{
    
    public static void display(Node head){
        while(head!=null){
	        System.out.print(head.data+" ");
	        head=head.next;
	    }
    }
    
    public static Node reverseDLL(Node head){
        if(head==null || head.next==null)
            return head;
        Node t=head,next=null,prev=null;
        next=t.next;
        prev=t.prev;
        t.next=prev;
        t.prev=next;
        t=next;
        while(t!=null){
            next=t.next;
            prev=t.prev;
            t.next=prev;
            t.prev=next;
            if(next==null)
                break;
            t=next;
        }
        return t;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	Node prev=null,head=null;
	for(int i=0;i<n;i++){
	    int a=x.nextInt();
	    if(i==0){
	        head=new Node(a);
	        prev=head;
	    }else{
	        Node node=new Node(a);
	        prev.next=node;
	        node.prev=prev;
	        prev=node;
	    }
	}
	head=reverseDLL(head);
	display(head);
	}
}
