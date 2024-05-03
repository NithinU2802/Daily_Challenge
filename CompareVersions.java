/******************************************************************************

                         Comparing Versions 

*******************************************************************************/
import java.util.*;

public class CompareVersions
{
    
    public static int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        for(int i=0;i<v1.length || i<v2.length;i++){
            int d1=0,d2=0;
            if(i<v1.length)
                d1=Integer.parseInt(v1[i]);
            else
                d1=0;
            if(i<v2.length)
                d2=Integer.parseInt(v2[i]);
            else
                d2=0;
            if(d1>d2)
                return 1;
            else if(d1<d2)
                return -1;
        }
        return 0;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s1=x.nextLine(),s2=x.nextLine();
	    System.out.println(compareVersion(s1,s2));
	}
}
