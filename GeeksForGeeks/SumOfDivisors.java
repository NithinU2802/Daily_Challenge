/******************************************************************************

Given a positive integer N., The task is to find the value of    \sum_{i=1}^{i=n}
F(i)  where function F(i) for the number i is defined as the sum of all divisors of i.

Example 1:

Input:
N = 4
Output:
15
Explanation:
F(1) = 1
F(2) = 1 + 2 = 3
F(3) = 1 + 3 = 4
F(4) = 1 + 2 + 4 = 7
ans = F(1) + F(2) + F(3) + F(4)
    = 1 + 3 + 4 + 7
    = 15
Example 2:

Input:
N = 5
Output:
21
Explanation:
F(1) = 1
F(2) = 1 + 2 = 3
F(3) = 1 + 3 = 4
F(4) = 1 + 2 + 4 = 7
F(5) = 1 + 5 = 6
ans = F(1) + F(2) + F(3) + F(4) + F(5)
    = 1 + 3 + 4 + 7 + 6
    = 21
Your Task:  
You don't need to read input or print anything. Your task is to complete the function
sumOfDivisors() which takes an integer N as an input parameter and returns an integer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 106

*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static long sumOfDivisors(int N){
        long s=0;
        for(int i=1;i<=N;i++){
            int c=1;
            for(int j=i+i;j<=N;j+=i)
                c++;
            s+=(i*c);
        }
        return s;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	System.out.println(sumOfDivisors(n));
	}
}
