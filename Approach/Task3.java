import java.util.*;


public class Task3 {
    public static void main(String[] arg){
    Scanner x=new Scanner(System.in);
    String s=x.nextLine();
    // String s="Today is a good day";
    int sc=x.nextInt();
    int sp=0,n=s.length(),no=0;
    for(int i=0;i<s.length();i++)
        if(s.charAt(i)==' ')
            sp++;
        else 
            no++;
    int d=(sc-no)/sp,r=(sc-no)%sp;
    System.out.println(d+" "+r);

    String st="";
    for(int i=0;i<d;i++)
        st+='*';


    String res="";

    for(int i=0;i<s.length();i++)
        if(s.charAt(i)==' '){
            res+=st; // 3 star
            if(r>0){
                res+='*'; // extra
                r--;
            }
        }else
            res+=s.charAt(i);
    System.out.println(res);
    }
}
