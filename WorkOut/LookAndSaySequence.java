/******************************************************************************

You have been given a positive integer N. Your task is to find the Nth term of the Look-And-Say sequence.

The Look-And-Say sequence is a sequence of positive integers. The sequence is as follows:

1, 11, 21, 1211, 111221, 312211, 13112221,...

This sequence is constructed in the following way:

The first number is 1.

This is read as “One 1”. 
Hence, the second number will be 11.

The second number is read as “Two 1s”. 
Hence, the third number will be 21.

The third number is read as “One 2, One 1”. 
Hence, the fourth number will be 1211.

The fourth term is read as “One 1, One 2, Two 1s”.
Hence, the fifth term will be 111221. And so on.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100
1 <= N <= 40

Time Limit: 1 sec
Sample Input 1:
3
1
2
3
Sample Output 1:
1
11
21
Explanation for Sample 1:
The first term is 1.
The second term is 11.
The third term is 21.
Sample Input 2:
1
6
Sample Output 2:
312211


*******************************************************************************/
import java.util.*;

public class LookAndSequence
{
    
    public static String lookAndSaySequence(int n) {
        String s="",l="1",p="1";
        while(n>1){
            l="";
            int i=0;
            while(i<p.length()){
                s=""+p.charAt(i);
                int c=0;
                while(i<p.length() && s.charAt(0)==p.charAt(i)){ 
                    c++;
                    i++;
                }
                l+=c+s;
            }
            p=l;
            n--;
        }
        return l;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int t=x.nextInt();
		String[] a=new String[t];
		for(int i=0;i<t;i++){
		    int n=x.nextInt();
		    a[i]=lookAndSaySequence(n);
		}
		for(String i:a)
		    System.out.println(i);
	}
}
