/*
You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
*/

package leetcode;

import java.util.Arrays;

public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(mat, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] array = new int[r*c];
        int idx = 0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                array[idx] = matrix[i][j];
                idx++;
            }
        }

        Arrays.sort(array);
        
        return array[k-1];
    }
}
