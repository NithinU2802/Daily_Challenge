/******************************************************************************

    Finding the elements of array are Straight Consecutive or not.

*******************************************************************************/
import java.util.*;

public class IsNStraightHand
{
    
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)
            return false;
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++){
            if(hand[i]==-1)
                continue;
            int j=i+1,t=groupSize-1,p=hand[i];
            hand[i]=-1;
            while(t>0 && j<hand.length){
                if(hand[j]-1==p && hand[j]!=-1){
                    p=hand[j];
                    System.out.print(p+" ");
                    hand[j]=-1;
                    t--;
                    j++;
                    continue;
                }
                if(hand[j]!=-1)
                    p=hand[j];
                j++;
            }
            System.out.println();
            if(t>0)
                return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		int n=3;
		int[] hand=new int[]{1,2,3,6,2,3,4,7,8};
		System.out.println(isNStraightHand(hand,n));
	}
}
