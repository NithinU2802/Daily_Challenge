import java.util.*;

public class UniqueChar
{
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		x.nextLine();
		String s=x.nextLine().trim();
		if(s.length()==0){
		    System.out.println("-1");
		    return;
		}
		int[] fq=new int[256];
		int res=0;
		for(int i=0;i<s.length();i++){
		    if(fq[s.charAt(i)]==0)
		        res++;
		    fq[s.charAt(i)]=1;
	    }
        System.out.println(res);
	}
}
