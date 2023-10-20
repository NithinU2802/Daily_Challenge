
class Permutation{
    static int res=0;
    static void permute(String[] st,int s,int e){
        if(s==e){
            String rs="";
            for(String i:st)
                rs+=i;
            long a=Long.parseLong(rs);
            if(a%3==0)
                res++;
        }else{
            for(int i=s;i<=e;i++){
                swap(st,s,i);
                permute(st,s+1,e);
                swap(st,s,i);
            }
        }
    }
    
    static void swap(String[] st,int i,int j){
        String t=st[i];
        st[i]=st[j];
        st[j]=t;
    }
    
    static int isPossible(int N, int arr[]) {
    String[] s=new String[N];
    int k=0;
    for(int i:arr)
        s[k++]=String.valueOf(i);
    res=0;
    permute(s,0,N-1);
    return res!=0?1:0;
    }
}
