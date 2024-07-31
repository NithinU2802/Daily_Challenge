/******************************************************************************

    Given an array of strings arr. Return the longest common prefix among all strings
present in the array. If there's no prefix common in all the strings, return "-1".

Examples :

Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
Output: gee
Explanation: "gee" is the longest common prefix in all the given strings.
Input: arr[] = ["hello", "world"]
Output: -1
Explanation: There's no common prefix in the given strings.
Expected Time Complexity: O(n*min(|arri|))
Expected Space Complexity: O(min(|arri|))

*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static String longestCommonPrefix(String arr[]) {
        String res="";
        for(int i=0;i<arr[0].length();i++){
            int f=0;
            char c=arr[0].charAt(i);
            for(int j=0;j<arr.length;j++)
                if(i>=arr[j].length() || arr[j].charAt(i)!=c){
                    f=1;
                    break;
                }
            if(f==1)
                break;
            res+=c;
        }
        if(res.length()==0)
            return "-1";
        return res;    
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		String[] a=new String[n];
		x.nextLine();
		for(int i=0;i<n;i++)
		    a[i]=x.next();
		System.out.println(longestCommonPrefix(a));
	}
}
