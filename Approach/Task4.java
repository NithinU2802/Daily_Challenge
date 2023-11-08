import java.util.*;

public class Task4 {
    public static void main(String[] arg){
    Scanner x=new Scanner(System.in);

    //String s="/animal/./box/../../Cat/";
    String s=x.nextLine();
    String[] stack=new String[100001];
    
    //String result="";
    int n=s.length();
    int k=0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='/'){
            String a=""; // file dir

//String s="/animal/./box/../../Cat/";

            int j=i+1;
            while(j<n && s.charAt(j)!='/'){
                a+=s.charAt(j);
                j++;
            }


            if(a.equals("..")){
                if(k==0)
                    continue;
                k--;
            }else if(a.equals(".") || a.equals(""))
                continue;
            else
                stack[k++]=a;
        }
    }
    for(int i=0;i<k;i++)
        System.out.print("/"+stack[i]);
    }
}
