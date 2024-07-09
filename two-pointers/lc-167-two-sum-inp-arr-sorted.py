class Solution:
    def twoSum(self, numbers, target):
        left, right = 0, len(numbers)-1
        while left<right:
            curr = numbers[left] + numbers[right]
            if curr<target:
                left += 1
            elif curr>target:
                right -= 1
            else:
                return [left+1, right+1]
            
                