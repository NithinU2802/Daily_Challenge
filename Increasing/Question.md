Increasing Sequence: Given an integer array, find the number of increasing sequences in the array and the length of its longest increasing sequence.
The prototype of the function is as below:
Public static void increasingSeq(int input1,int[] input2);
The function takes as input an integer input1 and integer array input2.  
Containing input1 as number of integers  and function sets the output1 to the length of the longest increasing sequence in the array.
Example1:
Input1 = 9
Intput2[]={11,3,4,7,8,12,2,3,7}
Output1 should be 5
Explanation:
In the given array input2, the two  increasing sequences are “3,4,7,8,12” and “2,3,7”. The first sequence i.e. “3,4,7,8,12” is the longest one containing five items. So, the longest increasing sequence = 5.

Example 2:
Input1 = 4
Intput2[]={1,3,2,1}
Output1 should be 2
Explanation:
In the given array input2, The increasing sequence is “1,3” containing two items. So, the longest increasing sequence = 2.  
Example 3:
Input1 = 12
Intput2[]={12,17,21,3,7,9,10,11,33,100,4,8 }
Output1 should be 7
Explanation:
In the given array input2, the increasing sequence are “12,17,21” containing three items , “3,7,9,10,11,33,100” containing seven items and “4,8” containing two items. So the longest increasing sequence =7
