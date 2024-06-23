/*
Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
*/ 

package leetcode;

import java.util.Arrays;
import java.util.HashMap;


public class ReduceArraySizeToHalf {
    public static void main(String[] args) {
        int[] arr = {9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
        System.out.println(minSetSize(arr));

    }

    public static int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:arr){
            if (map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i,1);
        }

        int[] freq = new int[map.values().size()];
        int i = 0;
        for (int val:map.values())
            freq[i++] = val;
        Arrays.sort(freq);
        int removed = 0, arrSize = arr.length, halfSize = arrSize/2;
        i = freq.length-1;
        while(true){
            if (arrSize<=halfSize)
                break;
            removed += 1;
            arrSize -= freq[i--];    
        }
        return removed;
    }
}
