/******************************************************************************

    Thousand Hundred ten and one's highest digit decode

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int a=x.nextInt(),b=x.nextInt(),c=x.nextInt();
	int th=Math.max(a/1000,Math.max(b/1000,c/1000)),hun=Math.max((a/100)%10,Math.max((b/100)%10,(c/100)%10));
	int ten=Math.max((a/10)%10,Math.max((b/10)%10,(c/10)%10));
	int on=Math.max(a%10,Math.max(b%10,c%10));
	int s=0;
	s=(s*10)+th;
	s=(s*10)+hun;
	s=(s*10)+ten;
	s=(s*10)+on;
	System.out.println(s);
	}
}
