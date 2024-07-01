class Solution:
    def twoSum(self, nums, target: int):
        d = {}
        for i, num in enumerate(nums):
            if target-num in d:
                return [d[target-num], i]
            d[num] = i
        