/******************************************************************************

Given an integer, check whether it is Bleak or not.

A number n is called Bleak if it cannot be represented as sum of a positive number x 
and set bit count in x, i.e., x + countSetBits(x) is not equal to n for any non-negative number x.

Example 1:

Input: 
4
Output: 
1
Explanation: 
There is no x such that x + countSetbit(x) = 4
Example 2:

Input: 
3
Output: 
0
Explanation: 
3 is a Bleak number as 2 + countSetBit(2) = 3.
Your Task:
You don't need to read or print anything. Your task is to complete the function 
is_bleak() which takes n as input parameter and returns 1 if n is not a Bleak number 
otherwise returns 0.

Expected Time Complexity: O(log(n) * log(n))
Expected Space Complexity: O(1)
 
Constraints:
1 <= n <= 109



*******************************************************************************/
import java.util.*;

public class Main
{
    public static int is_bleak(int n){
        if(n==0)
            return 0;
        for(int i=1;i<n;i++)
            if(i+countSetBit(i)==n)
                return 0;
        return 1;
    }
    
    public static int countSetBit(int a){
        int s=0;
        while(a>0){
            if(a%2==1)
                s++;
            a/=2;
        }
        return s;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	System.out.println(is_bleak(n));
	}
}
