/******************************************************************************

Ramu is in Birla Auditorium. He noticed that the auditorium is decored with an 
infinite series of electric bulbs indexed from 1 There are 40 switches indexed 
from 1 to 40 to control those bulbs. Switch with index N is connected to the bulbs
with indexes that are multiple of N. ie switch 2 is connected to bulb 2,4, 6, 8

So some bulbs are connected to multiple switches and some are not connected to any
switch. Ramu started to play with these switches, he wants to know the Kth glowing
bulb from the start if certain switches are in ON state, if any of the switch is ON,
connected to any bulb then bulb starts glowing But Ramu has special fond of prime numbers,
so he only puts prime indexed switches ON.

*******************************************************************************/
import java.util.*;

public class BulbSwitch
{
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s=x.nextLine();
		int k=x.nextInt();
		int b=1;
		while(true){
		    for(int i=0;i<s.length();i++)
		        if(s.charAt(i)=='1' && b%(i+1)==0){
		            k--;
		            if(k==0){
		                System.out.println(b);
		                return;
		            }
		            break;
		        }
		    b++;
		}
	}
}
