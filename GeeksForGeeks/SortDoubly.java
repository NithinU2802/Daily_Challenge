/******************************************************************************

Given Pointer/Reference to the head of a doubly linked list of n nodes, the task is
to Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing order.

Example 1:

Input:
n = 8
value[] = {7,3,5,2,6,4,1,8}
Output:
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
Explanation: After sorting the given
linked list in both ways, resultant
matrix will be as given in the first
two line of output, where first line
is the output for non-decreasing
order and next line is for non-
increasing order.
Example 2:

Input:
n = 5
value[] = {9,15,0,-1,0}
Output:
-1 0 0 9 15
15 9 0 0 -1
Explanation: After sorting the given
linked list in both ways, the
resultant list will be -1 0 0 9 15
in non-decreasing order and 
15 9 0 0 -1 in non-increasing order.
Your Task:
The task is to complete the function sortDoubly() which takes reference to the head
of the doubly linked and Sort the given doubly linked list using Merge Sort in both
non-decreasing and non-increasing. The printing is done automatically by the driver code.

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(logn)

Constraints:
1 <= n <= 104
-105 <= values[i] <= 105



*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node prev=null,next=null;
    Node(int data){
        this.data=data;
        prev=null;
        next=null;
    }
}

public class SortDoubly
{
    
    public static void forward(Node node){
        if(node==null)
            return;
        System.out.print(node.data+" ");
        forward(node.next);
    }
    
    public static Node split(Node head){
        Node fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node t=slow.next;
        slow.next=null;
        return t;
    }
    
    public static Node sortDoubly(Node node){
        if(node==null || node.next==null)
            return node;
        Node s=split(node);
        return merge(sortDoubly(node),sortDoubly(s));
    }
    
    public static Node merge(Node f,Node s){
        if(f==null)
            return s;
        if(s==null)
            return f;
        if(f.data<s.data){
            f.next=merge(f.next,s);
            f.next.prev=f;
            f.prev=null;
            return f;
        }
        s.next=merge(f,s.next);
        s.next.prev=s;
        s.prev=null;
        return s;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		Node head=null,prev=null;
		for(int i=0;i<n;i++){
		    Node node=new Node(x.nextInt());
		    if(head==null)
		        head=node;
		    else{
		       prev.next=node;
		       node.prev=prev;
		    }
		    prev=node;
		}
		
		head=sortDoubly(head);
		
	    while(head.next!=null){
	        System.out.print(head.data+" ");
	        head=head.next;
	    }
	    System.out.println(head.data+" ");
		while(head.prev!=null){
	        System.out.print(head.data+" ");
	        head=head.prev;
	    }
	    System.out.print(head.data+" ");
	}
}
