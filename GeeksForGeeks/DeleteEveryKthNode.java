/******************************************************************************

Given a singly linked list having n nodes, your task is to remove every kth node 
from the linked list. 

Example 1:

Input:
n = 8
linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 
k = 2
Output: 
1 -> 3 -> 5 -> 7
Explanation: 
After removing every 2nd node of the linked list, the resultant linked list will 
be: 1 -> 3 -> 5 -> 7.
Example 2:

Input:
n = 10
linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 
k = 3
Output: 
1 -> 2 -> 4 -> 5 -> 7 -> 8 -> 10
Explanation: 
After removing every 3rd node of the linked list, the resultant linked list will 
be: 1 -> 2 -> 4 -> 5 -> 7 -> 8 -> 10.
Your Task:
The task is to complete the function deleteK() which takes head of linked list and 
integer k as input parameters and delete every kth node from the linked list and 
return its head.

Expected Time Complexity :  O(n)
Expected Auxiliary Space :  O(1)

Constraints:
1 <= n <= 105
-109 <= elements of linked list <= 109
1 <= k <= n



*******************************************************************************/
import java.util.*;

class Node{
    
    int data;
    Node next=null;
    
    public Node(int data){
        this.data=data;
    }
}

public class DeleteEveryKthNode
{
    
    static Node delete(Node head, int k)
    {
        if(k==1)
            return null;
	    Node t=head;
	    while(t!=null && t.next!=null){
	        int tm=1;
	        while(tm<k-1 && t!=null && t.next!=null){
	            t=t.next;
	            tm++;
	        }
	        if(t==null || t.next==null)
	            break;
	        t.next=t.next.next;
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
		Node head=null,prev=null;
		int n=x.nextInt();
		for(int i=0;i<n;i++){
		    Node node=new Node(x.nextInt());
		    if(head==null)
		        head=node;
		    else
		        prev.next=node;
		    prev=node;
		}
		int k=x.nextInt();
		head=delete(head,k);
		print(head);
	}
}
