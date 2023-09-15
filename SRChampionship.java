/*******************************************************************************

In a class, there are N students. For each student, the number of times he/she 
has participated in the SR world programming championship is passed as the input

to the program. According to the SR world programming championship nudes, each 
person can participate in the world championship at mast 5 times. The class tuter 
recently gathering teams to participate in the world championship with the following rules.

Each team must consist of exactly three people. Any person cannot be a member of 
two or more teams. The program must print the maximum number of teams can the tutor
make if each team to participate in the world championship with the same
members at least K times (the value of K is also passed the input)

*******************************************************************************/
import java.util.*;
public class Hello {

    public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int n=x.nextInt();
		int k=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		int c=0;
		for(int i=0;i<n;i++){
		    if(a[i]+k>5)
		        c++;
		}
		System.out.println((n-c)/3);

	}
}
