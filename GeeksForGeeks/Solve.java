/******************************************************************************

You are given two four digit prime numbers Num1 and Num2. Find the distance of the
shortest path from Num1 to Num2 that can be attained by altering only single digit 
at a time such that every number that we get after changing a digit is a four digit 
prime number with no leading zeros.

Example 1:

Input:
Num1 = 1033 
Num2 = 8179
Output: 6
Explanation:
1033 -> 1733 -> 3733 -> 3739 -> 3779 -> 8779 -> 8179.
There are only 6 steps reuired to reach Num2 from Num1. 
and all the intermediate numbers are 4 digit prime numbers.
Example 2:

Input:
Num1 = 1033 
Num2 = 1033
Output:
0
Your Task:  
You don't need to read input or print anything. Your task is to complete the function 
solve() which takes two integers Num1 and Num2 as input parameters and returns the distance 
of the shortest path from Num1 to Num2. If it is unreachable then return -1.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1000<=Num1,Num2<=9999
Num1 and Num2 are prime numbers.

*******************************************************************************/
import java.util.*;

public class Solve
{
        boolean isPrime(int a){
        if(a<=1)
            return false;
        if(a==2)
            return true;
        for(int i=2;i<=Math.sqrt(a);i++)
            if(a%i==0)
                return false;
        return true;
    }
    
    boolean isSingle(int a,int b){ 
        int res=0;
        while(a>0){
            if(a%10!=b%10)
                res++;
            a/=10;
            b/=10;
        }
        return res==1;
    }
    
    int solve(int Num1,int Num2){
        Queue<String> queue=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        String a=String.valueOf(Num1),b=String.valueOf(Num2);
        Map<String,Integer> map=new HashMap<>();
        map.put(a,0);
        queue.offer(a);
        while(!queue.isEmpty()){
            String s=queue.remove();
            set.add(s);
            //int n=map.get(a);
            if(s.equals(b))
                return map.get(s);
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                for(int j=0;j<10;j++){
                    if(i==0 && j==0)
                        continue;
                    String r=s.substring(0,i)+((char)(j+'0'))+s.substring(i+1,s.length());
                    if(set.contains(r))
                        continue;
                    int n=Integer.parseInt(r);
                    if(isPrime(n)){
                        set.add(r);
                        if(!map.containsKey(r))
                            map.put(r,0);
                        map.put(r,map.get(s)+1);
                        queue.offer(r);
                    }
                }
                s=s.substring(0,i)+c+s.substring(i+1,s.length());
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int a=x.nextInt(),b=x.nextInt();
		System.out.println(solve(a,b));
	}
}
