/******************************************************************************

You are given a Linked list of size n. The list is in alternating ascending and 
descending orders. Sort the given linked list in non-decreasing order.

Example 1:

Input:
n = 6
LinkedList = 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation: 
After sorting the given list will be 1->2->3->7->8->9.
Example 2:

Input:
n = 5
LinkedList = 13->99->21->80->50
Output: 13 21 50 80 99
Explanation:
After sorting the given list will be 13->21->50->80->99.
Your Task:
You do not need to read input or print anything. The task is to complete the function 
sort() which should sort the linked list of size n in non-decreasing order. 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= Number of nodes <= 100
0 <= Values of the elements in linked list <= 103

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}

public class SortAlternateNode
{
    
    public static Node sort(Node head){
        if(head.next==null)
            return head;
        Node next=head.next,t=head;
        while(next!=null){
            if(next.data<t.data){
                int d=next.data;
                next.data=t.data;
                t.data=d;
                next=head.next;
                t=head;
                continue;
            }
            next=next.next;
            t=t.next;
        }
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
		int n=x.nextInt();
		Node head=null,prev=null;
		for(int i=0;i<n;i++){
		    Node node=new Node(x.nextInt());
		    if(head==null)
		        head=node;
		    else 
		        prev.next=node;
		    prev=node;
		}
		sort(head);
		print(head);
	}
}
