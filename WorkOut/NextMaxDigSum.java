/******************************************************************************

    Given with an integer n your task is to find the element which is greater 
sum digit then n also which next to less than n.

Example 1:
Input: 34
Output: 29

*******************************************************************************/
import java.util.*;

public class NextMaxDigSum
{
    
    static int sum(int n){
        int s=0;
        while(n>0){
            s+=(n%10);
            n/=10;
        }
        return s;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int s=0,limit=sum(n),sm=-1,res=n;
		while(s<=n){
		    sm=sum(s-1);
		    if(sm>limit)
		        res=s-1;
		    s+=10;
		}
		s-=10;
		while(s<=n){
		    sm=sum(s);
		    if(sm>limit)
		        res=s;
		    s++;
		}
		System.out.println(res);
	}
}
