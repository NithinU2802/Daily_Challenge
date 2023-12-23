/******************************************************************************

There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) 
where S[i] is the start time of meeting i and F[i] is the finish time of meeting i. 
The task is to find the maximum number of meetings that can be accommodated in the 
meeting room. You can accommodate a meeting if the start time of the meeting is strictly
greater than the finish time of the previous meeting. Print all meeting numbers.

Note: If two meetings can be chosen for the same slot then choose meeting with smaller 
index in the given array.

Example 1:

Input:
N = 6
S = {1,3,0,5,8,5}
F = {2,4,6,7,9,9} 
Output:
{1,2,4,5}
Explanation:
We can attend the 1st meeting from (1 to 2), then the 2nd meeting from (3 to 4), 
then the 4th meeting from (5 to 7), and the last meeting we can attend is the 5th 
from (8 to 9). It can be shown that this is the maximum number of meetings we can attend.
Example 2:

Input:
N = 1
S = {3}
F = {7}
Output:
{1}
Explanation:
Since there is only one meeting, we can attend the meeting.
Your Task:

You don't need to read input or print anything. Your task is to complete the function
maxMeetings() which takes the arrays S, F, and its size N as inputs and returns the 
meeting numbers we can attend in sorted order.

Expected Time Complexity: O(N*log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
0 <= S[i] <= F[i] <= 109
Sum of N over all test cases doesn't exceeds 106

*******************************************************************************/

import java.util.*;

class Node {
    int start;
    int end;
    int index;

    Node(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Solution { 
    
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) { 
        // ArrayList<Integer> res=new ArrayList<Integer>();
        // for(int j=0;j<N;j++){
        // ArrayList<Integer> a=new ArrayList<Integer>();
        // int p=F[j];
        // a.add(S[j]);
        // for(int i=j+1;i<N;i++)
        //     if(S[i]>p){
        //         a.add(i+1);
        //         p=F[i];
        //     }
        // if(a.size()>res.size())
        //     res=(ArrayList)a.clone();
        // }
        // Collections.sort(res);
        // return res;
        ArrayList<Node> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++)
            meetings.add(new Node(S[i], F[i], i + 1));
        
        Collections.sort(meetings, Comparator.comparingInt(m -> m.end));

        ArrayList<Integer> results = new ArrayList<>();

        int prevFinishTime = 0;
        for (Node meeting : meetings)
            if (meeting.start > prevFinishTime) {
                results.add(meeting.index);
                prevFinishTime = meeting.end;
            }
        Collections.sort(results);
        return results;
    }
    
}

public class MaxMeetings{

    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        // int N = 6;
        // int[] S = {1, 3, 0, 5, 8, 5};
        // int[] F = {2, 4, 6, 7, 9, 9};
        int N=x.nextInt();
        int[] S=new int[N];
        int[] F=new int[N];
        for(int i=0;i<N;i++)
            s[i]=x.nextInt();
        for(int j=0;j<N;j++)
            F[i]=x.nextInt();
        Solution solution=new Solution();
        List<Integer> meetings = solution.maxMeetings(S, F, N);
        System.out.println(meetings);  // Output: [1, 2, 4, 5]
    }
}
