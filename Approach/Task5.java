import java.util.*;

public class Task5 {

    public static int search(int[] a,int d,int s,int e){
        while(s<e){
            int m=(s+e)/2;
            if(a[m]==d)
                return m;
            if(a[m]>d && a[m-1]<a[m])
                return search(a, d, s, m-1);
            else if(a[m]<d && a[m-1]>a[m])
                return search(a, d, m+1, e);
            else{
                s++;
                e--;
            }
        }
        return -1;
    }

    public static void main(String[] arg){
    Scanner x=new Scanner(System.in);
    String[] s=x.nextLine().split(" ");
    int d=x.nextInt();
    int[] a=new int[s.length];
    int k=0;
    for(String i:s)
        a[k++]=Integer.parseInt((i));
    System.out.println(search(a,d,0,a.length));
    }
}
