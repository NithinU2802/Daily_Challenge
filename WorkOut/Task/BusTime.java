/******************************************************************************

    To find time in minute that person miss the bus

*******************************************************************************/
import java.util.*;

public class BusTime
{
    public static int solution(String[] schedule,String time){
        String[] t=time.split(":");
        int h=Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        int r=(h*60)+m;
        for (int i = schedule.length - 1; i >= 0; i--) {
            if(schedule[i].equals(time))
                return -1;
            t =schedule[i].split(":");
            h=Integer.parseInt(t[0]);
            m=Integer.parseInt(t[1]);
            int c=(h* 60)+m;
            if (c<=r)
                return r-c;

        }
        return -1;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String[] s=x.nextLine().split(" ");
		String t=x.nextLine();
		System.out.println(solution(s,t));
	}
}
