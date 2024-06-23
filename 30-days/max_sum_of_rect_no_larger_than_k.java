/*
Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
*/
package leetcode;

import java.util.TreeSet;

public class max_sum_of_rect_no_larger_than_k{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1,0,1},{0,-2,3}}; 
        int k = 2;
        int res = sol.maxSumSubmatrix(matrix, k);
        System.out.println(res);

    }
}

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<row;i++){
            int[] column_sum = new int[col];
            for (int j=i;j<row;j++){
                for (int c=0;c<col;c++){
                    column_sum[c] += matrix[j][c];
                }
                max = Math.max(max, findMaxSumSubArray(column_sum, k));
            }
        }
        return max;
    }

    public int findMaxSumSubArray(int[] sum, int k){
        int length = sum.length;
        int result = Integer.MIN_VALUE;
        int prefix_sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for(int i=0;i<length;i++){
            prefix_sum += sum[i];
            Integer target = set.ceiling(prefix_sum-k);

            if (target != null){
                result = Math.max(result, prefix_sum-target);
            }
            set.add(prefix_sum);
        }
        return result;
    }
}