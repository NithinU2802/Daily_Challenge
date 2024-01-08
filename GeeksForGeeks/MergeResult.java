/******************************************************************************

Given two linked lists of size N and M, which are sorted in non-decreasing order. 
The task is to merge them in such a way that the resulting list is in non-increasing order.

Example 1:

Input:
N = 2, M = 2
list1 = 1->3
list2 = 2->4
Output:
4->3->2->1
Explanation:
After merging the two lists in non-increasing order, we have new lists as 4->3->2->1.
Example 2:

Input:
N = 4, M = 3
list1 = 5->10->15->40 
list2 = 2->3->20
Output:
40->20->15->10->5->3->2
Explanation:
After merging the two lists in non-increasing order, we have new lists as 40->20->15->10->5->3->2.
Your Task:
The task is to complete the function mergeResult() which takes reference to the heads 
of both linked list and returns the pointer to the merged linked list.

Expected Time Complexity : O(N+M)
Expected Auxiliary Space : O(1)

Constraints:
0 <= N, M <= 104



*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

public class MergeResult
{
    
    static Node mergeResult(Node node1, Node node2)
    {
	    Node t=node1,head=null;
	    while(t!=null){
	        Node node=new Node(t.data);
	        node.next=null;
	        if(head==null){
	            head=node;
	            t=t.next;
	            continue;
	        }
	        
	        Node temp=head,prev=null;
	        while(temp!=null && temp.data>node.data){ 
	            prev=temp;
	            temp=temp.next;
	        }
	        if(prev==null){
	            temp=head;
	            head=node;
	            node.next=temp;
	            t=t.next;
	            continue;
	        }
	        prev.next=node;
	        if(temp!=null)
    	        node.next=temp;
	        t=t.next;
	    }
	    t=node2;
	    while(t!=null){
	        Node node=new Node(t.data);
	        node.next=null;
	        if(head==null){
	            head=node;
	            t=t.next;
	            continue;
	        }
	        
	        Node temp=head,prev=null;
	        while(temp!=null && temp.data>node.data){ 
	            prev=temp;
	            temp=temp.next;
	        }
	        if(prev==null){
	            temp=head;
	            head=node;
	            node.next=temp;
	            t=t.next;
	            continue;
	        }
	        prev.next=node;
	        if(temp!=null)
    	        node.next=temp;
	        t=t.next;
	    }
	    return head;
    }
    
    public static void printList(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),m=x.nextInt();
		Node head1=null,head2=null,t=null;
		for(int i=0;i<n;i++){
		    int a=x.nextInt();
		    Node node=new Node(a);
		    if(head1==null){
		        head1=node;
		        t=node;
		    }
		    else{
		        t.next=node;
		        t=node;
		    }
		}
		for(int i=0;i<m;i++){
		    int a=x.nextInt();
		    Node node=new Node(a);
		    if(head2==null){
		        head2=node;
		        t=node;
		    }
		    else{
		        t.next=node;
		        t=node;
		    }
		}
		printList(mergeResult(head1,head2));
	}
}
