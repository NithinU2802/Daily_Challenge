Decreasing Sequence: Given an integer array, find the number of decreasing sequences in the array and the length of its longest decreasing sequence.
The prototype of the function is as below:
Public static void decreasingSeq(int[] input1);
The function takes as input an integer array input1
The function sets the output1 variable to the number of decreasing sequences in the array, and sets the output2 variable to the length of the longest decreasing sequence in the array.
Example1:
Intput1[]={11,4,3,1,4,7,8,12,2,3,7}
Output1 should be 2
Output2 should be 4
Explanation:
In the given array input1, the decreasing sequences are “11,4,3,1” and “12,2” i.e there are two decreasing sequences in the array, and so output1 is assigned 2. The first sequence i.e. “11,4,3,1” is the longer one containing four items, when compared to the second sequence “12,2” which contains 2 items. So, the length of the longest decreasing sequence output2=4

Example 2:
Intput1[]={1,3,2,1}
Output1 should be 1
Output2 should be 3
Explanation:
In the given array input1, there is only one decreasing sequence which is “3,2,1” containing three items. So, the number of decreasing sequences output1 is assigned the value 1, and the length of the longest decreasing sequence output2 is assigned the value 3.
Example 3:
Intput1[]={12,15,21,29,69,79}
Output1 should be 0
Output2 should be 0
Explanation:
In the given array input1, there is no decreasing sequence. All the items are in decreasing order, hence the number of decreasing sequences output1 is assigned 0. Similarly the length of the longest decreasing sequence is also assigned the value 0.