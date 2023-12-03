/******************************************************************************

Given two BSTs containing N1 and N2 distinct nodes respectively and given a value
x, your task is to complete the function countPairs(), that returns the count of 
all pairs of (a, b), where a belongs to one BST and b belongs to another BST, such that a + b = x.

Example 1:

Input:
BST1:
       5
     /   \
    3     7
   / \   / \
  2   4 6   8
BST2:
       10
     /    \
    6      15
   / \    /  \
  3   8  11   18
x = 16
Output:
3
Explanation:
The pairs are: (5, 11), (6, 10) and (8, 8)
Example 2:

Input:
BST1:
  1
   \
    3
   /
  2
BST2:
    3
   / \
  2   4
 /     
1
x = 4
Output:
3
Explanation:
The pairs are: (2, 2), (3, 1) and (1, 3)
Your Task:
You don't need to read input or print anything. Your task is to complete the function
countPairs(), which takes two BST's as parameter in the form of root1 and root2 and 
the integer x, that returns the count of all pairs from both the BSTs whose sum is equal to x.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106

*******************************************************************************/
import java.util.*;


class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}


class Solution{
    
    public static int traverseCheck(Node root,boolean[] visit,int x,int res){
        if(root!=null){
            res=traverseCheck(root.left,visit,x,res);
            if(x-root.data<0 || x-root.data>1000001)
                return res;
            if(visit[x-root.data])
                res++;
            res=traverseCheck(root.right,visit,x,res);
        }
        return res;
    }
    
    public static void traverse(Node root,boolean[] visit){
        if(root!=null){
            traverse(root.left,visit);
            visit[root.data]=true;
            traverse(root.right,visit);
        }
    }
    
    public static int countPairs(Node root1,Node root2,int x){
        if(root1==null || root2==null)
            return 0;
        boolean[] visit=new boolean[1000001];
        traverse(root1,visit);
        return traverseCheck(root2,visit,x,0);
    }
    
    
    
}

public class CountPairs
{
    
    public static Node buildTree(String s){
        String[] arr=s.split(" ");
        if(arr.length==0)
            return null;
        Queue<Node> queue=new LinkedList<Node>();
        Node node=new Node(Integer.parseInt(arr[0]));
        queue.add(node);
        int i=1;
        while(!queue.isEmpty() && i<arr.length){
            Node curr=queue.remove();
            String r=arr[i++];
            if(!r.equals("N")){
                curr.left=new Node(Integer.parseInt(r));
                queue.add(curr.left);
            }
            if(i>=arr.length)
                break;
            r=arr[i++];
            if(!r.equals("N")){
                curr.right=new Node(Integer.parseInt(r));
                queue.add(curr.right);
            }
        }
        return node;
    }
    
    public static void traverse(Node root){
        if(root!=null){
            traverse(root.left);
            System.out.print(root.data+" ");
            traverse(root.right);
        }
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		String b=x.nextLine();
		int k=x.nextInt();
		Node head1=buildTree(s);
		Node head2=buildTree(b);
		Solution solution=new Solution();
		System.out.println(solution.countPairs(head1,head2,k));
	}
}
