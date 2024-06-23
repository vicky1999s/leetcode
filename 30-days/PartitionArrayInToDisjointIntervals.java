/**
Given an array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
*/

package leetcode;

public class PartitionArrayInToDisjointIntervals {
    public static void main(String[] args) {
        int[] nums = {29,33,6,4,42,0,10,22,62,16,46,75,100,67,70,74,87,69,73,88};
        System.out.println(partitionDisjoint(nums));
    }
    public static int partitionDisjoint(int[] nums) {
        int mini=Integer.MAX_VALUE, maxi=-1;
        int ptr = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]<mini){
                mini=nums[i];
                ptr = i;
            }
        }
        for (int i=0;i<=ptr;i++){
            if (nums[i]>maxi)
                maxi = nums[i];
        }
        int temp=-1;
        for (int i=ptr+1;i<nums.length;i++){
            if (nums[i]<maxi){
                maxi=Math.max(temp, maxi);
                ptr=i;
            }
            else if(nums[i]>maxi){
                temp = nums[i];
            }
            
        }
        return ptr+1;
    }
}
