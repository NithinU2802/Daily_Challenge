import java.util.*;


public class Main
{
    
    public static String betterString(String s,String a){
        if(check(a)>check(b))
            return a;
        else    
            return b;
    }
    
    public static long check(String s){ 
        int n=s.length(),t;
        int[] pr=new int[123];
        Arrays.fill(pr,-1);
        long[] dp=new long[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1]*2L;
            t=pr[s.charAt(i-1)];
            if(t!=-1)
                dp[i]-=dp[t];
            pr[s.charAt(i-1)]=i-1;
        }
        return dp[n];
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextInt(),a=x.nextInt();
	System.out.println(betterString(s,a));
	}
}
