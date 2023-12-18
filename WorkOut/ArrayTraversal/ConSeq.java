import java.util.*;

class ConSeq {
    
    static int conSeq(int N , int[] A) {
        if(N==1)
            return A[0];
        List<List<Integer>> comb=new ArrayList<>();
        
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
                List<Integer> a=new ArrayList<>();
                for(int k=i;k<=j;k++)
                    a.add(A[k]);
                comb.add(a);
            }
        int r=-1;
        for(List<Integer> i:comb){
            if(i.size()==0)
                continue;
            int s=i.get(0);
            for(int j=1;j<i.size();j++)
                s^=i.get(j);
            if(r==-1)
                r=s;
            else
                r^=s;
        }
        return r;
    }
    
    public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(conSeq(n,a));
	}
    
}
