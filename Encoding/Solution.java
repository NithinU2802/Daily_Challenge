/******************************************************************************

Example 1:
Original array = {2, 5, 1, 7, 9, 3}
Encoded array = {7, 6, 8, 16, 12, 3}
First number in original array = 2
Sum of all numbers in original array = 27
NOTE: Only the “Encoded array” will be supplied to the function and it is expected
to do the processing to find the expected result values.

Example 2:
Original array = {20,15,17,45,23,12,78,54,21,98,70,80,56,71,77,93,44,19}
Encoded array = {35,32,62,68,35,90,132,75,119,168,150,136,127,148,170,137,63,19}
First number in original array = 20
Sum of all numbers in original array = 893

Example 3:
Original array = {8,-10,3,-15}
Encoded array ={-2,-7,-12,-15}
First number in original array = 8
Sum of all numbers in original array = -14

Example 4:
Original array = {9}
Encoded array ={9}
First number in original array = 9
Sum of all numbers in original array = 9

Example 5:
Original array ={10, 12, 3, 5, 7, 20}
Encoded array ={22, 15, 8, 12, 27, 20}
First number in original array = 10
Sum of all numbers in original array = 57

Example 6:
Original array ={1, -45, 8, 23, 0, 0, -6, 89, 21, 53}
Encoded array ={-44, -37, 31, 23, 0, -6, 83, 110, 74, 53}
First number in original array = 1
Sum of all numbers in original array = 144

Example 7:
Original array ={12,17,-13,-16,0,90,87,-56,67,-67,-67,6,11,12,9,-1,0,0,8,3,4,2,-6,9,-18,19,27,-5,0,23,28,-56,-81,-50,16,0}
Encoded array ={29,4,-29,-16,90,177,31,11,0,-134,-61,17,23,21,8,-1,0,8,11,7,6,-4,3,-9,1,46,22,-5,23,51,-28,-137,-131,-34,16,0}
First number in original array = 12
Sum of all numbers in original array = 14


*******************************************************************************/
import java.util.*;

public class Solution
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
	    a[i]=x.nextInt();
	int[] b=new int[a.length];
	for(int i=0;i<n;i++)
	    b[i]=a[i];
	for(int i=0;i<n-1;i++)
	    b[i]+=b[i+1];
	int s=0;
	for(int i=0;i<n;i++)
	    s+=a[i];
	System.out.println("Orginal: "+Arrays.toString(a));
	System.out.println("Encoded: "+Arrays.toString(b));
	System.out.println(a[0]);
	System.out.println(s);
	}
}
