/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.


Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

 */

package leetcode;

import java.util.Random;

public class ShuffleAnArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution sol = new Solution(nums);
        int[] p1 = sol.reset();
        int[] p2 = sol.shuffle();
        int[] p3 = sol.shuffle();
        int[] p4 = sol.reset();
        for(int i:p1)System.out.println(i);
        for(int i:p2)System.out.println(i);
        for(int i:p3)System.out.println(i);
        for(int i:p4)System.out.println(i);
    }

    static class Solution {
        private int[] nums;
        private Random random;
        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();

        }
        
        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }
        
        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] numsCopy = nums.clone();
            for(int i=nums.length-1;i>0;i--){
                int j = random.nextInt(i+1);
                int temp = numsCopy[i];
                numsCopy[i] = numsCopy[j];
                numsCopy[j] = temp;
            }
            return numsCopy;
        }
    }
    
}
