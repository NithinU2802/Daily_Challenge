/******************************************************************************

Given weights and values of N items, we need to put these items in a knapsack of 
capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item here. 

Example 1:

Input:
N = 3, W = 50
value[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.000000
Explanation:
Take the item with value 60 and weight 10, value 100 and weight 20 and split the third 
item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80,
so the total weight becomes 60+100+80.0=240.0
Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. 
Example 2:

Input:
N = 2, W = 50
value[] = {60,100}
weight[] = {10,20}
Output:
160.000000
Explanation:
Take both the items completely, without breaking.
Total maximum value of item we can have is 160.00 from the given capacity of sack.
Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of 
structure/class and size N and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= W <= 109
1 <= valuei, weighti <= 104

*******************************************************************************/
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack
{
    
    static double fractionalKnapsack(int W, Item arr[], int n) 
    {
      Arrays.sort(arr,(i,j)->{return Double.compare(((double)j.value/(double)j.weight),((double)i.value/(double)i.weight));});
        double res=0;
        for(int i=0;i<n && W>0;i++)
            if(W>=arr[i].weight){
                res+=arr[i].value;
                W-=arr[i].weight;
            }else{
                res+=((double) W / (double)arr[i].weight) * arr[i].value;
                break;
            }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt(),W=x.nextInt();
		Item[] arr=new Item[n];
		int[] value=new int[n];
		int[] weight=new int[n];
		for(int i=0;i<n;i++)
		    value[i]=x.nextInt();
		for(int i=0;i<n;i++)
		    weight[i]=x.nextInt();
		for(int i=0;i<n;i++)
		    arr[i]=new Item(value[i],weight[i]);
	    System.out.println(fractionalKnapsack(W,arr,n));
	}
}
