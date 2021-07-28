package leetcode;

import java.util.Arrays;

public class threeSumClosest{
    public static void main(String[] args) {
        System.out.println(threeSumClosest1(new int[]{-1,2,1,4}, 2));
    }
    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[nums.length-1];
        for (int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int currSum = nums[i]+nums[start]+nums[end];
                if (currSum<target) start++;
                else if (currSum>target) end--;

                if (Math.abs(currSum-target)<Math.abs(closestSum-target))
                    closestSum=currSum;
            }
        }
        return closestSum;
    }
}