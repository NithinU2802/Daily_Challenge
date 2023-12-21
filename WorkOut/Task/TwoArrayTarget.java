/******************************************************************************

    Find the possible way to get target from the two array.

*******************************************************************************/
import java.util.*;
public class TwoArrayTarget{

    public static int solution(int[] firstArray, int[] secondArray, int target) {
        Map<Integer, Integer> list1 = getPrefixSums(firstArray);
        Map<Integer, Integer> list2 = getPrefixSums(secondArray);
        int res=0;
        for (int i=0;i<firstArray.length;i++)
            for (int k = i; k < firstArray.length; k++) {
                int a=list1.get(k)-(i>0?list1.get(i-1):0);
                for (int j = 0; j< secondArray.length; j++)
                    for (int l = j; l < secondArray.length; l++) {
                        int b = secondPrefixSums.get(l)-(j>0?secondPrefixSums.get(j-1):0);
                        if (a+b== target)
                            res++;
                    }
            }
        return res;
    }

    private static Map<Integer, Integer> getPrefixSums(int[] arr) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefixSums.put(i, sum);
        }
        return prefixSums;
    }

    public static void main(String[] args) {
        int[] firstArray = {5,2,1,6,4};
        int[] secondArray = {3, 5};
        int target = 10;
        System.out.println(findPairs(firstArray, secondArray, target));  // Output: 2
    }
}
