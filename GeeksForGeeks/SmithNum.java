/******************************************************************************

Given a number n, the task is to find out whether this number is a Smith number
or not. A Smith number is a composite number whose sum of digits is equal to the
sum of digits of its prime factors.

Example 1:

Input:
n = 4
Output:
1
Explanation:
The sum of the digits of 4 is 4, and the sum of the digits of its prime factors is 2 + 2 = 4.
Example 2:

Input:
n = 378
Output:
1
Explanation:
378 = 21*33*71 is a Smith number since 3+7+8 = 2*1+3*3+7*1.
Your Task:
You don't need to read input or print anything. Your task is to complete the function
smithNum() which takes an Integer n as input and returns the answer.

Expected Time Complexity: O(n * log(n))
Expected Auxiliary Space: O(n)

*******************************************************************************/
import java.util.*;

public class SmithNum
{
    
    static int divisable(int a){
        if(a==1 || a==2)
            return -1;
        for(int i=2;i<=a/2;i++)
            if(a%i==0)
                return i;
        return -1;
    }
    
    static boolean prime(int a){
        if(a==1 || a==2)
            return true;
        for(int i=2;i<=a/2;i++)
            if(a%i==0)
                return false;
        return true;
    }
    
    static int smithNum(int n){
        int t=n,s=0,r=0;
        while(t>0){
            s+=t%10;
            t/=10;
        }
        
        t=n;
        while(t>0){
            int a=divisable(t);
            if(a==-1)
                break;
            else{
                int p=a;
                while(p>0){
                    r+=(p%10);
                    p/=10;
                }
            }
            t/=a;
        }
        if(t==n)
            return 0;
        if(t>1 && prime(t)){
            while(t>0){
                r+=(t%10);
                t/=10;
            }
        }
        if(r==s)
            return 1;
        return 0;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		System.out.println(smithNum(n));
	}
}
