import java.util.*;

public class Solution
{
    
    public static int firstRepeat(int[] a,int n){
        for(int i=0;i<n;i++){
            if(a[i]<=0)
                continue;
            for(int j=i-1;j>=0;j--)
                if(a[i]==a[j])
                    return a[i];
        }
        int i=0;
        while(i<n && i<=0)
            i++;
        return a[i];
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	System.out.println(firstRepeat(a,n));
	}
}
