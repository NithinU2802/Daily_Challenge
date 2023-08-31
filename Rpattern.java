import java.util.*;

class Main{

public static void main(String[] arg){
    Scanner x=new Scanner(System.in);
    int n=x.nextInt();
    int k=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i==0 || j==0 || (j==n-1 && i<=n/2) || (i==n/2) || (i>=n/2 && j==k)){
            System.out.print("*");
            }else System.out.print(" ");
        }
        if(i>=n/2) k++;
        System.out.println();
    }
    }
}

