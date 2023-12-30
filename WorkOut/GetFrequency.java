/******************************************************************************

Ninja and his friend playing a game in which his friend gave him a string ‘STR’ that
can contain spaces and a List/Array ‘WORDS’ which is of type string containing ‘N’
strings of words. Ninja’s task is to count the occurrences of all the words in ‘STR’.

For Example:

‘STR’ = “i am a Ninja”, ‘N’ = 3 and ‘WORDS[]’ = [“Ninja”,”a”,”am”]. Then the output 
should be [1,1,1]. Because the occurrence of “Ninja” in ‘STR’ is 1 and the occurrence 
of “a” in ‘STR’ is 1.Similarly occurrence of “am” is 1.
Note:

The output should be in the same order as given in ‘WORDS’.
Can you help Ninja to generate all valid strings from ‘STR’ by minimum removals?

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= ‘T’ <= 100
1 <= |STR| <= 4000
1<= N <= 4000
1<= |WORDS[i]| <= 4000

Where  |'STR'| denotes the length of the given string and ‘|WORDS[i]|’ denotes the 
length of the string word.  

Time limit: 1 sec
Sample Input 1:
2
2
Hi i am ninja and i love coding
ninja
m  
5
Hey ninja ! How are you ?
Hey  
ninja
Ninja 
How 
yo
Sample Output 1:
1 0
1 1 0 1 0
Explanation for Sample Output 1:
For the first test case : 
1. There is only one occurrence of “ninja” in ‘STR’= “Hi i am ninja and i love coding”.
2. There is no occurrence of “m” in ‘STR’ = “Hi i am ninja and i love coding”.

For the second test case:
1. There is 1 occurrence of “Hey” in given ‘STR’ = “Hey ninja ! How are you ?”
2. There is 1 occurrence of “ninja” in given ‘STR’ = “Hey ninja ! How are you ?”
3. There is 0 occurrence of “Ninja” in given ‘STR’ = “Hey ninja ! How are you ?”
4. There is 1 occurrence of “How” in given ‘STR’ = “Hey ninja ! How are you ?”
5. There are 0 occurrences of “yo” in given ‘STR’ = “Hey ninja ! How are you ?”
Sample Input 2:
2
2
the Ninja always wins the game of coding
nja 
the
3
Hey There I am enjoying algorithms
HEY
A
There
Sample Output 2:
0 2 
2 0 1
Explanation for Sample Output 2:
For the first test case : 
1. There is no occurrence of “nja” in ‘STR’= “the Ninja always wins the game of coding”.
2. There is 2 occurrences of “the” in ‘STR’ = “the Ninja always wins the game of coding”.

For the second test case:
1. There are 2 occurrences of “Hey” in given ‘STR’ = “Hey There I am enjoying algorithms”
2.There are 0 occurrences of “A” in given ‘STR’ = “Hey There I am enjoying algorithms”
3. There is 1 occurrence of “There” in given ‘STR’ = “Hey There I am enjoying algorithms”


*******************************************************************************/
import java.util.*;

public class GetFrequency
{
    
    public static ArrayList<Integer> getFrequency(String str, ArrayList<String> words, int n) {
		String[] s=str.split(" ");
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(String i:s)
			if(map.containsKey(i))
				map.put(i,map.get(i)+1);
			else
				map.put(i,1);
		ArrayList<Integer> res=new ArrayList<>();
		for(String i:words)
			res.add(map.getOrDefault(i,0));
		return res;
	}
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		int t=x.nextInt();
		for(int i=0;i<t;i++){
		    int n=x.nextInt();
		    x.nextLine();
		    String s=x.nextLine();
		    ArrayList<String> a=new ArrayList<String>();
		    for(int j=0;j<n;j++)
		        a.add(x.nextLine());
		    res.add(getFrequency(s,a,n));
		}
		for(ArrayList<Integer> i:res){
		    for(int j:i)
		        System.out.print(j+" ");
		    System.out.println();
	    }
	}
}
