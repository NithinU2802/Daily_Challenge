/******************************************************************************

    Given a linked list sorted in ascending order and an integer called data, insert 
data in the linked list such that the list remains sorted.

Example 1:

Input:
LinkedList: 25->36->47->58->69->80
data: 19
Output: 
19 25 36 47 58 69 80
Explanation:
After inserting 19 the sorted linked list will look like the one in the output.
Example 2:

Input:
LinkedList: 50->100
data: 75
Output: 
50 75 100
Explanation:
After inserting 75 the sorted linked list will look like the one in the output.
Your Task:
The task is to complete the function sortedInsert() which should insert the element 
in sorted Linked List and return the head of the linked list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104
-99999 <= A[i] <= 99999, for each valid i

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int a){
        data=a;
        next=null;
    }
}

public class Main
{
    
    static Node insert(Node head,int a){
        Node node=new Node(a);
        if(head==null)
            return node;
        Node c=head,p=head.next;
        if(head.data>a){
            node.next=head;
            head=node;
        }else{
        while(p!=null){
            if(p.data>a)
                break;
            p=p.next;
            c=c.next;
        }
        c.next=node;
        node.next=p;
        }
        return head;
    }
    
    static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	Node head=null;
	for(int i=0;i<n;i++){
	    int a=x.nextInt();
	    head=insert(head,a);
	}
	print(head);
	}
}
