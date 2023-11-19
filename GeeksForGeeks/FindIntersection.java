/******************************************************************************

Given two linked lists sorted in increasing order, create a new linked list representing
the intersection of the two linked lists. The new linked list should be made with without 
changing the original lists.

Note: The elements of the linked list are not necessarily distinct.

Example 1:

Input:
LinkedList1 = 1->2->3->4->6
LinkedList2 = 2->4->6->8
Output: 2 4 6
Explanation: For the given two
linked list, 2, 4 and 6 are the elements
in the intersection.
Example 2:

Input:
LinkedList1 = 10->20->40->50
LinkedList2 = 15->40
Output: 40
Your Task:
You don't have to take any input of print anything. Your task is to complete the 
function findIntersection(), which will take head of both of the linked lists as 
input and should find the intersection of two linked list and add all the elements
in intersection to the third linked list and return the head of the third linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(n+m)
Note: n, m are the size of the respective linked lists.

Constraints:
1 <= size of linked lists <= 5000
1 <= Data in linked list nodes <= 104

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class FindIntersection
{
    
    public static Node findIntersection(Node head1,Node head2){
        Node head=null,prev=null;
        while(head1!=null && head2!=null){
            if(head1.data==head2.data){
                Node node=new Node(head1.data);
                if(head==null)
                    head=node;
                else 
                    prev.next=node;
                prev=node;
                head1=head1.next;
                head2=head2.next;
            }else if(head2.data<head1.data)
                head2=head2.next;
            else 
                head1=head1.next;
        }
        return head;
    }
    
    public static void display(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt(),a;
	Node head1=null,prev=null;
	for(int i=0;i<n;i++){
	    a=x.nextInt();
	    if(i==0){
	        Node node=new Node(a);
	        head1=node;
	        prev=node;
	    }else{
	        Node node=new Node(a);
	        prev.next=node;
	        prev=node;
	    }
	}
	Node head2=null;
	prev=null;
	n=x.nextInt();
	for(int i=0;i<n;i++){
	    a=x.nextInt();
	    if(i==0){
	        Node node=new Node(a);
	        head2=node;
	        prev=node;
	    }else{
	        Node node=new Node(a);
	        prev.next=node;
	        prev=node;
	    }
	}
	Node head=findIntersection(head1,head2);
	display(head);
	}
}
