/******************************************************************************

Given an integer K and a queue of integers, we need to reverse the order of the 
first K elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Note: The above operations represent the general processings. In-built functions 
of the respective languages can be used to solve the problem.

Example 1:

Input:
5 3
1 2 3 4 5
Output: 
3 2 1 4 5
Explanation: 
After reversing the given
input from the 3rd position the resultant
output will be 3 2 1 4 5.
Example 2:

Input:
4 4
4 3 2 1
Output: 
1 2 3 4
Explanation: 
After reversing the given
input from the 4th position the resultant
output will be 1 2 3 4.
Your Task:
Complete the provided function modifyQueue() that takes queue and K as parameters 
and returns a modified queue. The printing is done automatically by the driver code.

Expected Time Complexity : O(N)
Expected Auxiliary Space : O(K)

Constraints:
1 <= K <= N <= 105



*******************************************************************************/
import java.util.*;

public class ModifyQueue
{
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<k;i++)
            stack.push(q.remove());
        Queue<Integer> res=new LinkedList<Integer>();
        while(!stack.isEmpty())
            res.add(stack.pop());
        while(!q.isEmpty())
            res.add(q.remove());
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),k=x.nextInt();
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
		    q.add(x.nextInt());
		for(int i:modifyQueue(q,k))
		    System.out.print(i+" ");
	}
}
