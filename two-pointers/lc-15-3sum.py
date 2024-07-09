class Solution:
    def threeSum(self, nums):
        ans = []
        nums.sort()
        length = len(nums)
        for i, a in enumerate(nums):
            if a>0:
                break
            if i>0 and a==nums[i-1]:
                continue
            left, right = i+1, length-1
            while left<right:
                s = a + nums[left] + nums[right]
                #print(s)
                if s>0:
                    right -= 1
                elif s<0:
                    left += 1
                else:
                    ans.append([a,nums[left],nums[right]])
                    left += 1
                    right -= 1
                    while left<length and nums[left]==nums[left-1]:
                        left+=1
        return ans