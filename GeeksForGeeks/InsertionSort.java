/******************************************************************************

Given a singly linked list, sort the list (in ascending order) using insertion sort algorithm.

Example 1:

Input:
N = 10
Linked List = 30->23->28->30->11->14->
              19->16->21->25 
Output : 
11 14 16 19 21 23 25 28 30 30 
Explanation :
The resultant linked list is sorted.
Example 2:

Input : 
N = 7
Linked List=19->20->16->24->12->29->30 
Output : 
12 16 19 20 24 29 30 
Explanation : 
The resultant linked list is sorted.
Your task:
You don't need to read input or print anything. Your task is to complete the function
insertionSort() which takes the head of the linked list, sorts the list using insertion
sort algorithm and returns the head of the sorted linked list.
 
Expected Time Complexity : O(n2)
Expected Auxiliary Space : O(1)
 
Constraints:
0 <= n <= 5*103


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

public class InsertionSort{
    
    public static Node insertionSort(Node head_ref)
    {
        Node head=null,t=head_ref;
        while(t!=null){
            Node node=new Node(t.data);
            if(head==null)
                head=node;
            else{
                Node temp=head,prev=null;
                while(temp!=null && temp.data<node.data){
                    prev=temp;
                    temp=temp.next;
                }
                if(prev==null){
                    node.next=head;
                    head=node;
                }else{
                    prev.next=node;
                    node.next=temp;
                }
            }
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
		head=insertionSort(head);
		print(head);
	}
}
