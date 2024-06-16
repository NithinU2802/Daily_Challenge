/******************************************************************************

Given a number n, find out if n can be expressed as a+b, where both a and b are 
prime numbers. If such a pair exists, return the values of a and b, otherwise 
return [-1,-1] as an array of size 2.
Note: If [a, b] is one solution with a <= b, and [c, d] is another solution with
c <= d, and a < c then  [a, b] is considered as our answer.

Examples

Input: n = 10
Output: 3 7
Explanation: There are two possiblities 3, 7 & 5, 5 are both prime & their sum is
10, but we'll pick 3, 7 as 3 < 5.

Input: n = 3
Output: -1 -1
Explanation: There are no solutions to the number 3.
Expected Time Complexity: O(n*loglog(n))
Expected Auxiliary Space: O(n)

Constraints:
2 <= n <= 106

*******************************************************************************/
import java.util.*;

public class IsPrime
{
    
    public static boolean isPrime(int a){
        if(a==3 || a==2)
            return true;
        if(a%2==0 || a%3==0)
            return false;
        for(int i=5;i*i<=a;i+=6)
            if(a%i==0 || a%(i+2)==0)
                return false;
        return true;
    }
    
    public static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        if(isPrime(n-2))
            return new ArrayList<>(Arrays.asList(2,n-2));
        for(int i=3;i<n;i+=2)
            if(isPrime(i) && isPrime(n-i))
                return new ArrayList<>(Arrays.asList(i,n-i));
        return new ArrayList<>(Arrays.asList(-1,-1));
    }

    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		for(int i:getPrimes(n))
		    System.out.print(i+" ");
	}
}
