/******************************************************************************

    Calculating Mod Inverse for the given numbers

*******************************************************************************/

public class Main
{
    
    static public long modInverse(int A, int N) {
    int a=N,n=A,q=0,r=a%n,t1=0,t2=1,t=0;
    while(r!=0){
        q=a/n;
        r=a%n;
        t=t1-(t2*q);
        q=r;
        a=n;
        n=r;
        t1=t2;
        t2=t;
    }
    if(t1==0)
        return 1;
    if(t1<0)
        t1=t1+N;
    return t1;
    }
    
	public static void main(String[] args) {
	//int a=x.nextInt(),b=x.nextInt();
	System.out.println(modInverse(11,26));
	}
}
