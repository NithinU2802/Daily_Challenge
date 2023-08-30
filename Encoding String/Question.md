Anand was assigned the task of coming up with an encoding mechanism for any given three strings. He has

come up with the below plan.

Step One: Given any three strings, break each string into 3 parts each.
For Example – If the three strings are as below –

Input1=”John”
Input2=”Johny”
Input3=”Janardhan”

“John” should be split into “J”, “oh”,”n” as the FRONT,MIDDLE and END parts respectively.
“Johny” should be split into “Jo”, “h”,”ny” as the FRONT,MIDDLE and END parts respectively.
“Janardhan” should be split into “Jan”, “ard”,”han” as the FRONT, MIDDLE and END parts respectively.
i.e. if the no. of characters in the string are in multiples of 3, then each split-part will contain equal no. of

characters, as seen in the example of “Janardhan”

If the no. of characters in the string are NOT in multiples of 3, and if there is one character more than multiple

of 3, then the middle part will get the extra character, as seen in the example of “John”
If the no. of characters in the string are NOT in multiples of 3, and if there are two characters more than
multiple of 3, then the FRONT and END parts will get one extra character each, as seen in the example of

“Johny”

STEP TWO: Concatenate (join) the FORNT, MIDDLE and END parts of the strings as per the below specified

concatenation-rule to form three Output Strings.

Output1= END part of input1+FIRST part of Input2+MIDDLE part of Input3
Output2= FRONT part of input1+MIDDLE part of Input2+END part of Input3
Output3= MIDDLE part of input1+END part of Input2+FRONT part of Input3

For example, for the above specified example strings,

Output 1 : nJoard
Output 2: Jhhan
Output 3: ohnyJan

STEP THREE: Process the resulting output strings based on the output-processing rule.
After the above, we will now have three output strings. Further processing is required only for the third output

string as per below rule-

“Toggle the case of each character in the string”, i.e in the third output string, all lower-case characters should

be made upper-case and vice versa.

For example, for the above example strings, Output3 is “ohnyJan”, so after applying the toggle rule Output3

should become “OHNYjAN”.

FINAL RESULT – The three output strings after applying the above three steps is the final result. i.e. for the

above example,
Output 1 : nJoard
Output 2: Jhhan
Output 3: OHNYjAN

Anand approaches you to help him write a program that would do the above mentioned processing on any

given three strings and generate the resulting three output strings.