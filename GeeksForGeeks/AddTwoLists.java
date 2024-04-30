/******************************************************************************

Given two numbers, num1 and num2, represented by linked lists of size n and m respectively. 
The task is to return a linked list that represents the sum of these two numbers.

For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly
25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 
2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros 
in the output list.

Example 1:

Input:
n = 2
num1 = 45 (4->5->null)
m = 3
num2 = 345 (3->4->5->null)
Output: 
3->9->0->null  
Explanation: 
For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant
linked list will be (3 9 0).
Example 2:

Input:
n = 4
num1 = 0063 (0->0->6->3->null)
m = 2
num2 = 07 (0->7->null)
Output: 
7->0->null
Explanation: 
For the given two linked list (0 0 6 3) and (0 7), after adding the two linked list resultant
linked list will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked
lists and returns the head of the sum list.   

Expected Time Complexity: O(n+m)
Expected Auxiliary Space: O(max(n,m)) for the resultant list.

Constraints:
1 <= n, m <= 104

*******************************************************************************/
import java.util.*;

class Node{
    int data;
    Node next=null;
    public Node(int data){
        this.data=data;
    }
}

public class AddTwoLists
{
    
    static Node reverse(Node head){
        Node f=head,s=null,t=null;
        while(f.next!=null){
            t=f.next;
            f.next=s;
            s=f;
            f=t;
        }
        f.next=s;
        return f;
    }
    
    static Node addTwoLists(Node num1, Node num2){
        num1=reverse(num1);
        num2=reverse(num2);
        int sm=0,b=0;
        Node head=null,pre=null;
        while(num1!=null && num2!=null){
            sm=num1.data+num2.data+b;
            b=sm/10;
            Node node=new Node(sm%10);
            if(head==null)
                head=node;
            else
                pre.next=node;
            pre=node;
            num1=num1.next;
            num2=num2.next;
        }
        while(num1!=null){
            sm=num1.data+b;
            b=sm/10;
            Node node=new Node(sm%10);
            if(head==null)
                head=node;
            else
                pre.next=node;
            pre=node;
            num1=num1.next;
        }
        while(num2!=null){
            sm=num2.data+b;
            b=sm/10;
            Node node=new Node(sm%10);
            if(head==null)
                head=node;
            else
                pre.next=node;
            pre=node;
            num2=num2.next;
        }
        if(b!=0)
            pre.next=new Node(b);
        head=reverse(head);
        while(head!=null && head.data==0)
            head=head.next;
        if(head==null)
            return new Node(0);
        return head;
    }
    
    public static Node input(){
        Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		Node head=null,pre=null,node=null;
		for(int i=0;i<n;i++){
		    node=new Node(x.nextInt());
		    if(head==null)
		        head=node;
		    else 
		        pre.next=node;
		    pre=node;
		}
		return head;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		Node num1=input(),num2=input();
		Node res=addTwoLists(num1,num2);
		while(res!=null){
		    System.out.print(res.data+" ");
		    res=res.next;
		}
	}
}
