/******************************************************************************

You are given a number n, Return the count of total numbers from 1 to n containing
4 as a digit.

Examples:

Input: n = 9
Output: 1
Explanation: 4 is the only number between 1 to 9 which contains 4 as a digit.

Input: n = 44
Output: 9
Explanation: 4, 14, 24, 34, 40, 41, 42, 43 & 44, there are total 9 numbers containing
4 as a digit.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 105

*******************************************************************************/
import java.util.*;

public class CountNumberswith4
{
    public static int countNumberswith4(int n) {
        int s=0,res=0,e=10;
        if(n<10){
            if(n%10>=4)
                return 1;
            else 
                return 0;
        }
        while(e<=n){
            int t=s;
            while(t>0){
                if(t%10==4){
                    res+=(e-s-1);
                    break;
                }
                t/=10;
            }
            res++;
            s=e;
            e+=10;
        }
        int f=0,t=s;
        while(t>0){
            if(t%10==4){
                f=1;
                break;
            }
            t/=10;
        }
        if(f==1)
            res+=(n-s+1);
        if(f==0 && n%10>=4)
            res++;
        return res;
    }
    
	public static void main(String[] args) {
		Sanner x=new Scanner(System.in);
		int n=x.nextInt();
		System.out.println(countNumberswith4(n));
	}
}
