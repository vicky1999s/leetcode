/*
*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

https://leetcode.com/problems/4sum/solution/ 
*/
package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class FourSum {
    public static void main(String[] args) {
       int[] nums = {2,2,2,2,2}; int target = 8;
       System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-3;i++){
            for (int j=i+1;j<nums.length-2;j++){
                for (int k=j+1;k<nums.length-1;k++){
                    for (int l=k+1;l<nums.length;l++){
                        List<Integer> list1 = new ArrayList<>();
                        if (nums[i]+nums[j]+nums[k]+nums[l] == target){
                            list1.add(nums[i]);
                            list1.add(nums[j]);
                            list1.add(nums[k]);
                            list1.add(nums[l]);    
                            if (!list.contains(list1))
                                list.add(list1);    
                        }
                        else if (nums[i]+nums[j]+nums[k]+nums[l] > target)
                            break;
                    }
                }
            }
        }
        return list;
    }
}
