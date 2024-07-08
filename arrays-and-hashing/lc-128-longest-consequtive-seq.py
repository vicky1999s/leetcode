class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        nums = set(nums)
        count = 1
        result = 1
        for i in nums:
            left_neighbour = i-1
            if left_neighbour in nums:
                continue
            else:
                right_neighbour = i
                while True:
                    right_neighbour += 1
                    if right_neighbour in nums:
                        count += 1
                        result = max(result, count)
                    else:
                        count = 1
                        break
        return result

