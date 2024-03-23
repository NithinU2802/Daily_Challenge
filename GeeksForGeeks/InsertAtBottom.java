/******************************************************************************

You are given a stack st of n integers and an element x. You have to insert x at
the bottom of the given stack. 

Note: Everywhere in this problem, the bottommost element of the stack is shown 
first while priniting the stack.

Example 1:

Input:
n = 5
x = 2
st = {4,3,2,1,8}
Output:
{2,4,3,2,1,8}
Explanation:
After insertion of 2, the final stack will be {2,4,3,2,1,8}.
Example 2:

Input:
n = 3
x = 4
st = {5,3,1}
Output:
{4,5,3,1}
Explanation:
After insertion of 4, the final stack will be {4,5,3,1}.
Your Task:

You don't need to read input or print anything. Your task is to complete the function 
insertAtBottom() which takes a stack st and an integer x as inputs and returns the 
modified stack after insertion.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105
0 <= x, elements of stack <= 109



*******************************************************************************/
import java.util.*;

public class InsertAtBottom
{
    
    public static Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        if(st.isEmpty()){
            st.push(x);
            return st;
        }
        int t=st.peek();
        st.pop();
        insertAtBottom(st,x);
        st.push(t);
        return st;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),k=x.nextInt();
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<n;i++)
		    stack.add(x.nextInt());
		for(int i:insertAtBottom(stack,k))
		    System.out.print(i+" ");
	}
}
