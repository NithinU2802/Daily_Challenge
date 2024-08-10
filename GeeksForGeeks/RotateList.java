/******************************************************************************

    Given the head of a singly linked list, the task is to rotate the linked list anti-clockwise
by k nodes, i.e., left-shift the linked list by k nodes, where k is a given positive integer
smaller than or equal to length of the linked list.

Examples:

Input: linkedlist: 2->4->7->8->9 , k = 3
Output: 8->9->2->4->7
Explanation:
Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
Rotate 3: 8 -> 9 -> 2 -> 4 -> 7

Input: linkedlist: 1->2->3->4->5->6->7->8 , k = 4
Output: 5->6->7->8->1->2->3->4

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= number of nodes <= 103
1 <= node -> data <= 104
1 <= k <= number of nodes 



*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        next=null;
    }
}

public class RotateList
{
    
    public static Node rotate(Node head, int k) {
        Node t=head,prev=null;
        int c=0;
        while(c<k){
            c++;
            prev=t;
            t=t.next;
            if(t==null)
                t=head;
        }
        Node e=t;
        while(e.next!=null)
            e=e.next;
        e.next=head;
        prev.next=null;
        return t;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),k=x.nextInt();
		Node head=null,prev=null;
		for(int i=0;i<n;i++){
		    Node node=new Node(x.nextInt());
		    if(i==0)
		        head=node;
		    else
		        prev.next=node;
		    prev=node;
		}
		head=rotate(head,k);
		while(head!=null){
		    System.out.print(head.data+" ");
		    head=head.next;
		}
	}
}
