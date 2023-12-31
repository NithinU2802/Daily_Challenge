/******************************************************************************

Given a binary tree and an integer K. Find the number of paths in the tree which
have their sum equal to K.
A path may start from any node and end at any node in the downward direction.
Since the answer may be very large, compute it modulo 109+7.

Example 1:

Input:      
Tree = 
          1                               
        /   \                          
       2     3
K = 3
Output: 
2
Explanation:
Path 1 : 1 + 2 = 3
Path 2 : only leaf node 3
Example 2:

Input: 
Tree = 
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5                        
        /   / \     \                    
       1   1   2     6    
K = 5                    
Output: 
8
Explanation:
The following paths sum to K.  
3 2 
3 1 1 
1 3 1 
4 1 
1 -1 4 1 
-1 4 2 
5 
1 -1 5 
Your Task:  
You don't need to read input or print anything. Complete the function sumK() which
takes root node and integer K as input parameters and returns the number of paths 
that have sum K. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)

Constraints:
1 ≤ N ≤ 2*104
-105 ≤ Node Value ≤ 105
-109 ≤ K ≤ 109

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

class SumK
{
    public static int sumK(Node root,int k)
    {
       if(root==null)
            return 0;
        int a=path(root,k);
        int b=sumK(root.left,k);
        int c=sumK(root.right,k);
        return a+b+c;
    }

     public static Node binTree(String s){
        String[] elements=s.split(" ");
        if(elements.length==0 || elements[0].charAt(0)=='N')
            return null;
        Node root=new Node(Integer.parseInt(elements[0]));
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty() && i<elements.length){
            Node t=queue.remove();
            String st=elements[i];
            if(!st.equals("N")){
                t.left=new Node(Integer.parseInt(st));
                queue.add(t.left); 
            }
            i++;
            if(i>=elements.length)
                break;
            st=elements[i];
            if(!st.equals("N")){
                t.right=new Node(Integer.parseInt(st));
                queue.add(t.right);
            }
            i++;
        }
        return root;
    }
    
    public static void main(String[] arg){
        Scanner x=new Scanner(System.in);
        String s=x.nextLine();
        Node head=binTree(s);
        int k=x.nextInt();
        System.out.println(sumK(head,k));
    }
    
    
    public static int path(Node root,int k){
        if(root==null)
            return 0;
        int c=0;
        if(root.data==k)
            c++;
        c+=path(root.left,k-root.data);
        c+=path(root.right,k-root.data);
        return c;
    }
}
