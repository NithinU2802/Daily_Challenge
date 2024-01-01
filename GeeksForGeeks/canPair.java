/******************************************************************************

Given an array of integers nums and a number k, write a function that returns true
if given array can be divided into pairs such that sum of every pair is divisible by k.

Example 1 :

Input : 
nums = [9, 5, 7, 3]
k = 6
Output: 
True
Explanation: 
{(9, 3), (5, 7)} is a 
possible solution. 9 + 3 = 12 is divisible
by 6 and 7 + 5 = 12 is also divisible by 6.
Example 2:

Input : 
nums = [4, 4, 4]
k = 4
Output: 
False
Explanation: 
You can make 1 pair at max, leaving a single 4 unpaired.
Your Task:
You don't need to read or print anything. Your task is to complete the function
canPair() which takes array nums and k as input parameter and returns true if array
can be divided into pairs such that sum of every pair is divisible by k otherwise returns false.

Expected Time Complexity: O(n)
Expected Space Complexity : O(n)

Constraints:
1 <= length( nums ) <= 105
1 <= numsi <= 105
1 <= k <= 105



*******************************************************************************/
import java.util.*;

public class canPair
{
    
    public static boolean canPair(int[] a,int k){
        int n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]==-1)
                continue;
            int f=0;
            for(int j=i+1;j<n;j++){
                if(a[j]!=-1 && (a[i]+a[j])%k==0){
                    a[j]=-1;
                    a[i]=-1;
                    f=1;
                    break;
                }
            }
            if(f==0)
                return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		int k=x.nextInt();
		System.out.println(canPair(a,k));
	}
}
