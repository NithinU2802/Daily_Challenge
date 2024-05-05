/******************************************************************************

                            Matrix Conundrum
                            
    You are given with 2D matrix check the letters p, l, a and y which are present 
in distinct column contigious formate of matrix.

*******************************************************************************/
import java.util.*;

public class MatrixConundrim{ 

    public static boolean matrixConundrum(int n, int m, List<String> mat) { 
        ArrayList<String> list=new ArrayList<>();
        int in=0;
        for(int j=0;j<m;j++){
            int[] a=new int[130];
            for(int i=0;i<mat.size();i++)
                if(mat.get(i).charAt(j)=='p')
                    a['p']++;
                else if(mat.get(i).charAt(j)=='l')
                    a['l']++;
                else if(mat.get(i).charAt(j)=='a')
                    a['a']++;
                else if(mat.get(i).charAt(j)=='y')
                    a['y']++;
            if(a['y']!=0){
                in=list.indexOf("pla");
                if(in!=-1)
                    return true;
            }
            if(a['a']!=0){
                in=list.indexOf("pl");
                if(in!=-1)
                    list.set(in,"pla");
            }
            if(a['l']!=0){
                in=list.indexOf("p");
                if(in!=-1)
                    list.set(in,"pl");
            }
            if(a['p']!=0 && !list.contains("p"))
                list.add("p");
        }
        return false;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),m=x.nextInt();
		x.nextLine();
		List<String> list=new ArrayList<>();
		for(int i=0;i<n;i++)
		    list.add(x.nextLine());
		System.out.println(matrixConundrum(n,m,list));
	}
}
