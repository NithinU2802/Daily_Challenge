/******************************************************************************

Given a binary tree with n nodes and two node values, a and b, your task is to find 
the minimum distance between them. The given two nodes are guaranteed to be in the
binary tree and all node values are unique.

Example 1:

Input:
        1
      /  \
     2    3
a = 2, b = 3
Output: 
2
Explanation: 
We need the distance between 2 and 3. Being at node 2, we need to take two steps ahead 
in order to reach node 3. The path followed will be: 2 -> 1 -> 3. Hence, the result is 2. 
Example 2:

Input:
        11
      /   \
     22  33
    /  \  /  \
  44 55 66 77
a = 77, b = 22
Output: 
3
Explanation: 
We need the distance between 77 and 22. Being at node 77, we need to take three steps 
ahead in order to reach node 22. The path followed will be: 77 -> 33 -> 11 -> 22. 
Hence, the result is 3.
Your Task:
You don't need to read input or print anything. Your task is to complete the function 
findDist() which takes the root node of the tree and the two node values a and b as 
input parameters and returns the minimum distance between the nodes represented by 
the two given node values.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
2 <= n <= 105
0 <= Data of a node <= 109



*******************************************************************************/

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class FirstDist{
    
    public static void traverse(Node root, Map<Integer, List<Integer>> adj, Map<Integer, Integer> distance) {
        if (root == null) return;
        distance.put(root.data, Integer.MAX_VALUE);
        if (root.left != null) {
            adj.computeIfAbsent(root.data, k -> new ArrayList<>()).add(root.left.data);
            adj.computeIfAbsent(root.left.data, k -> new ArrayList<>()).add(root.data);
        }
        if (root.right != null) {
            adj.computeIfAbsent(root.data, k -> new ArrayList<>()).add(root.right.data);
            adj.computeIfAbsent(root.right.data, k -> new ArrayList<>()).add(root.data);
        }
        traverse(root.left, adj, distance);
        traverse(root.right, adj, distance);
    }

    public static int findDist(Node root, int a, int b) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> distance = new HashMap<>();
        traverse(root, adj, distance);
        distance.put(a, 0);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        pq.add(new int[]{0, a});
        while (!pq.isEmpty()) {
            int currDist = pq.peek()[0];
            int currNode = pq.poll()[1];
            for (int newNode : adj.getOrDefault(currNode, Collections.emptyList())) {
                if (1 + currDist < distance.get(newNode)) {
                    distance.put(newNode, 1 + currDist);
                    pq.add(new int[]{1 + currDist, newNode});
                }
            }
        }
        return distance.get(b);
    }
    
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
		String[] a=x.nextLine().split(" ");
		int n=a.length;
		Queue<Node> queue=new LinkedList<>();
		int i=1;
		Node head=new Node(Integer.parseInt(a[0]));
		queue.add(head);
		while(!queue.isEmpty()){
		    int m=queue.size();
		    for(int j=0;j<m;j++){
		        Node t=queue.remove();
		        if(t.left==null){
		            if(a[i].equals("N"))
		                t.left=null;
		           else
		                t.left=new Node(Integer.parseInt(a[i]));
		            i++;
		        }
		        if(i==n)
		            break;
		        if(t.right==null){
		            if(a[i].equals("N"))
		                t.right=null;
		           else
		                t.right=new Node(Integer.parseInt(a[i]));
		            i++;
		        }
		        if(i==n)
		            break;
		    }
		    if(i==n)
		            break;
		}

        int s = x.nextInt();
        int b = x.nextInt();

        System.out.println(findDist(head, s, b));
    }
}

