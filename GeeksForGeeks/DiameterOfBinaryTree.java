/*****************************************************
 
    Program to find the Diameter of Binary Tree 
 
 ****************************************************/

import java.util.*;


class TreeNode{
    int data;
    TreeNode left,right;
    public TreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class DiameterOfBinaryTree
{

    static int res=0;

    public static int length(TreeNode root){
        if(root==null)
            return 0;
        int left=length(root.left),right=length(root.right);
        if(left+right>res)
            res=left+right;
        return Math.max(left,right)+1;
    }
   
    public static int diameterOfBinaryTree(TreeNode root) {
        res=0;
        length(root);
        return res;
    }
    
    public static void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		x.nextLine();
		String[] arr=new String[n];
		for(int i=0;i<n;i++)
		    arr[i]=x.next();
		Queue<TreeNode> queue=new LinkedList<>();
		int i=0;
		TreeNode head=new TreeNode(Integer.parseInt(arr[i++]));
		queue.add(head);
		while(!queue.isEmpty()){
		    TreeNode node=queue.poll();
		    if(i<n){
		        if(arr[i].equals("N"))
		            i++;
		        else{
		            TreeNode a=new TreeNode(Integer.parseInt(arr[i++]));
		            node.left=a;
		            queue.add(a);
		        }
		    }
		    if(i<n){
		        if(arr[i].equals("N"))
		            i++;
		        else{
		            TreeNode a=new TreeNode(Integer.parseInt(arr[i++]));
		            node.right=a;
		            queue.add(a);
		        }
		    }
		}
		System.out.println(diameterOfBinaryTree(head));
	}
}
