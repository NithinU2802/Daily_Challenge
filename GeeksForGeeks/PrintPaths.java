/******************************************************************************

Given a Binary tree and a sum S, print all the paths, starting from root, that sums
upto the given sum. Path not necessarily end on a leaf node.

Example 1:

Input : 
sum = 8
Input tree
         1
       /   \
     20      3
           /    \
         4       15   
        /  \     /  \
       6    7   8    9      

Output :
1 3 4
Explanation : 
Sum of path 1, 3, 4 = 8.
Example 2:

Input : 
sum = 38
Input tree
          10
       /     \
     28       13
           /     \
         14       15
        /   \     /  \
       21   22   23   24
Output :
10 28
10 13 15  
Explanation :
Sum of path 10, 28 = 38 and
Sum of path 10, 13, 15 = 38.
Your task :
You don't have to read input or print anything. Your task is to complete the function
printPaths() that takes the root of the tree and sum as input and returns a vector of
vectors containing the paths that lead to the sum.
 
Expected Time Complexity: O(N)
Expected Space Complexity: O(N2)
 
Your Task :
1 <= N <= 2*103
-103 <= sum, Node.key <= 103

*******************************************************************************/
import java.util.*;

class Node
{
  int data;
  Node left, right;

  public Node (int data)
  {
    this.data = data;
    this.left = this.right = null;
  }
}

public class PrintPaths
{
  static void findPaths (Node root, int sum, ArrayList < Integer > a,
			 ArrayList < ArrayList < Integer >> result, int s)
  {
    if (root == null)
      return;
    a.add (root.data);
    s += root.data;
    if (s == sum)
      result.add (new ArrayList <> (a));
    ArrayList < Integer > t = (ArrayList) a.clone ();
    findPaths (root.left, sum, new ArrayList <> (a), result, s);
    findPaths (root.right, sum, new ArrayList <> (t), result, s);
  }

  public static ArrayList < ArrayList < Integer >> printPaths (Node root,
							       int sum)
  {
    ArrayList < ArrayList < Integer >> result = new ArrayList <> ();
    findPaths (root, sum, new ArrayList <> (), result, 0);
    return result;
  }

  public static Node buildTree (String treeString)
  {
    String[]values = treeString.split (" ");
    Queue < Node > queue = new LinkedList <> ();
    Node root = new Node (Integer.parseInt (values[0]));
    queue.offer (root);

    for (int i = 1; i < values.length; i += 2)
      {
	Node current = queue.poll ();

	if (!values[i].equals ("N"))
	  {
	    current.left = new Node (Integer.parseInt (values[i]));
	    queue.offer (current.left);
	  }

	if (i + 1 < values.length && !values[i + 1].equals ("N"))
	  {
	    current.right = new Node (Integer.parseInt (values[i + 1]));
	    queue.offer (current.right);
	  }
      }

    return root;
  }

  public static void main (String[]args)
  {
    Scanner x=new Scanner(System.in);
    int sum = x.nextInt ();
    x.nextLine();
    String treeString = x.nextLine ();
    Node root = buildTree (treeString);
    for(ArrayList<Integer> i:printPaths(root,sum)){
        for(int j:i)
            System.out.print(j+" ");
        System.out.println();
    }
  }
}
