/******************************************************************************

Given the root of a binary search tree and a number n, find the greatest number 
in the binary search tree that is less than or equal to n. 

Example 1 :

Input : 
5 2 12 1 3 9 21 N N N N 19 25 
n = 24
Output : 
21
Explanation : The greatest element in the tree which 
              is less than or equal to 24, is 21. 
              (Searching will be like 5->12->21)
              
Example 2 :
5 2 12 1 3 9 21 N N N N N N 19 25
Input : 

n = 4
Output : 
3
Explanation : The greatest element in the tree which 
              is less than or equal to 4, is 3. 
              (Searching will be like 5->2->3)
Your task :
You don't need to read input or print anything. Your task is to complete the function
findMaxForN() which takes the root of the BST, and the integer n as input paramters 
and returns the greatest element less than or equal to n in the given BST.

Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= n <= 103

*******************************************************************************/
import java.util.*;

class Node{
    int key;
    Node left,right;
    public Node(int key){
        this.key=key;
        left=null;
        right=null;
    }
}

public class FindMaxForN
{
    
    static int res=-1;
    
    public static void check(Node root,int n){
        if(root==null)
            return;
        if(res<root.key && root.key<=n)
            res=root.key;
        check(root.left,n);
        check(root.right,n);
    }
    
    public static int findMaxForN(Node root, int n) {
        res=-1;
        check(root,n);
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] a=x.nextLine().split(" ");
		int n=x.nextInt();
		int i=0;
		if(a[0].equals("N")){
		    System.out.println("No Tree is available");
		    return;
		}
		Queue<Node> q=new LinkedList<>();
		Node head=new Node(Integer.parseInt(a[i++]));
		q.add(head);
		while(i<a.length){
		    Node node=q.remove();
		    if(!a[i].equals("N")){
		        node.left=new Node(Integer.parseInt(a[i]));
		        q.add(node.left);
		    }
		    i++;
		    if(i>=a.length)
		        break;
		    if(!a[i].equals("N")){
		        node.right=new Node(Integer.parseInt(a[i]));
		        q.add(node.right);
		    }
		    i++;
		}
		System.out.println(findMaxForN(head,n));
	}
}
