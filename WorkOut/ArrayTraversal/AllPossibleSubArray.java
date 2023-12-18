import java.util.*;

public class AllPossibleSubArray {

    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=x.nextInt();
        List<List<Integer>> comb=new ArrayList<>();
        combin(arr,0,new ArrayList<>(),comb);
       // int r=-1;
        for (List<Integer> i : comb) {
            System.out.println(i);
        }
      //  System.out.println(r);
    }
    
    static void combin(int[] A,int in,List<Integer> list,List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        for(int i=in;i<A.length;i++){
            list.add(A[i]);
            combin(A,i+1,list,res);
            list.remove(list.size()-1);
        }
    }
}
