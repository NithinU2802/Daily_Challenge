/******************************************************************************

In a restaurant, two waiters, A and B, receive n orders per day, earning tips as per
arrays arr[i] and brr[i] respectively. If A takes the ith order, the tip is arr[i] 
rupees; if B takes it, the tip is brr[i] rupees.

To maximize total tips, they must distribute the orders such that:

A can handle at most x orders
B can handle at most y orders
Given that x + y ≥ n, all orders can be managed by either A or B. Return the maximum
possible total tip after processing all the orders.

Examples

Input: n = 5, x = 3, y = 3, arr = {1, 2, 3, 4, 5}, brr = {5, 4, 3, 2, 1}
Output: 21
Explanation: Person A will serve the 3rd, 4th and 5th order while person B will serve
the rest so the total tip from A = 3+4+5 & B = 5 + 4 i.e. 21. 
 

Input: n = 8, x = 4, y = 4, arr = {1, 4, 3, 2, 7, 5, 9, 6}, brr = {1, 2, 3, 6, 5, 4, 9, 8}
Output: 43
Explanation: Person A will serve 1st, 2nd, 5th and 6th order while Person B will serve 
the rest & the total tip will be 43.
 

Input: n = 7, x = 3, y = 4, arr[] = {8, 7, 15, 19, 16, 16, 18}, brr[] = {1, 7, 15, 11, 12, 31, 9}
Output: 110
Explanation: Person A will serve orders 8,19,18 while person B will serve 7,15, 12 & 31.
Expected Time Complexity: O(n*logn)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 105
1 ≤ x, y ≤ n
1 ≤ arr[i], brr[i] ≤ 109



*******************************************************************************/
import java.util.*;

class Pair{
    int value,index;
    Pair(int value,int index){
        this.value=value;
        this.index=index;
    }
}

public class MaxTip
{
    
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new Pair(arr[i]-brr[i],i));
        Collections.sort(list,Comparator.comparingInt(a->a.value));
        Collections.reverse(list);
        long res=0;
        for(int i=0;i<n;i++)
            if(list.get(i).value>0){
                if(x>0){
                    res+=arr[list.get(i).index];
                    x--;
                }else{
                    res+=brr[list.get(i).index];
                    y--;
                }
            }else{
                if(n-i<=y){
                    res+=brr[list.get(i).index];
                    y--;
                }else{
                    res+=arr[list.get(i).index];
                    x--;
                }
            }
        return res;
    }

    
	public static void main(String[] args) {
	    Scanner x=new Scanner(System.in);
	    int n=x.nextInt();
	    int xx=x.nextInt();
	    int yy=x.nextInt();
	    int[] a=new int[n];
	    for(int i=0;i<n;i++)   
	        a[i]=x.nextInt();
	    int[] b=new int[n];
		for(int j=0;j<n;j++)
		    b[j]=x.nextInt();
		System.out.println(maxTip(n,xx,yy,a,b));
	}
}
