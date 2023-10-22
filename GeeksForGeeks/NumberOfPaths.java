/******************************************************************************

    The problem is to count all the possible paths from top left to bottom right
of an MxN matrix with the constraints that from each cell you can either move to right or down.

Return answer modulo 109+7.

Example 1:

Input:
M = 3 and N = 3
Output: 6
Explanation:
Let the given input 3*3 matrix is filled 
as such:
A B C
D E F
G H I
The possible paths which exists to reach 
'I' from 'A' following above conditions 
are as follows:ABCFI, ABEHI, ADGHI, ADEFI, 
ADEHI, ABEFI
Example 2:

Input:
M = 1 and N = 4
Output: 1
Explanation:
There is only one direction to go in,
and thus, there is only one path possible.
Your Task
You don't need to read input or print anything. Your task is to complete the function 
numberOfPaths() which takes the integer M and integer N as input parameters and returns
an integer, the number of paths.

Expected Time Complexity: O(M)
Expected Space Complexity: O(1)

Constraints:
1 ≤ N ≤ 108
1 ≤ M ≤ 105

*******************************************************************************/
import java.util.*;

public class Main
{
    static int mod = 1000000007;
    static public long modInverse(int A, int N) {
    int a=N,n=A,q=0,r=a%n,t1=0,t2=1,t=0;
    while(r!=0){
        q=a/n;
        r=a%n;
        t=t1-(t2*q);
        q=r;
        a=n;
        n=r;
        t1=t2;
        t2=t;
    }
    if(t1==0)
        return 1;
    if(t1<0)
        t1=t1+N;
    return (long)t1;
    }
    
    public static long numberOfPaths(int m,int n){
        long res=1;
        for(int i=1;i<m;i++){
            res=res*(n+i-1)%mod;
            res=(res*modInverse(i,mod))%mod;
        }
        return res;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int m=x.nextInt(),n=x.nextInt();
	System.out.println(numberOfPaths(m,n));
	}
}
