/******************************************************************************

Given a singly linked list having n nodes containing english alphabets ('a'-'z'). 
Rearrange the linked list in such a way that all the vowels come before the consonants
while maintaining the order of their arrival. 

Example 1:

Input:
n = 9
linked list: a -> b -> c -> d -> e -> f -> g -> h -> i 
Output: 
a -> e -> i -> b -> c -> d -> f -> g -> h
Explanation: 
After rearranging the input linked list according to the condition the resultant
linked list will be as shown in output.
Example 2:

Input:
n = 8
linked list: a -> b -> a -> b -> d -> e -> e -> d 
Output: 
a -> a -> e -> e -> b -> b -> d -> d
Explanation: 
After rearranging the input linked list according to the condition the resultant
linked list will be as shown in output.
Your Task:
Your task is to complete the function arrangeCV(), which takes head of linked list 
and arranges the list in such a way that all the vowels come before the consonants 
while maintaining the order of their arrival and returns the head of the updated linked list.

Expected Time Complexity :  O(n)
Expected Auxiliary Space :  O(1)

Constraints:
1 <= n <= 104
'a' <= elements of linked list <= 'z'



*******************************************************************************/
import java.util.*;


class Node{
    char data;
    Node next=null;
    public Node(char data){
        this.data=data;
    }
}

public class arrangeCV
{
    
    static boolean isVowel(char a){
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u')
            return true;
        return false;
    }
    
    public static Node arrangeCV(Node head){
        Node vowel=null,prev=null,cons=null,prec=null;
        while(head!=null){
            if(isVowel(head.data)){
                if(vowel==null)
                    vowel=head;
                else
                    prev.next=head;
                prev=head;
            }else{
                if(cons==null)
                    cons=head;
                else
                    prec.next=head;
                prec=head;
            }
            Node t=head;
            head=head.next;
            t.next=null;
        }
        if(prev==null)
            return cons;
        prev.next=cons;
        return vowel;
    }
    
    public static Node input(){
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        x.nextLine();
        Node head=null,prev=null;
        for(int i=0;i<n;i++){
            Node node=new Node(x.next().charAt(0));
            if(head==null)
                head=node;
            else
                prev.next=node;
            prev=node;
        }
        return head;
    }
    
	public static void main(String[] args) {
		Node head=input();
		head=arrangeCV(head);
		while(head!=null){
		    System.out.print(head.data+" ");
		    head=head.next;
		}
	}
}
