def lengthOfLIS(self, nums: List[int]) -> int:
        n=[1]*len(nums)
        l=len(nums)
        for i in range(l):
            for j in range(i):
                if nums[i]>nums[j]:
                    n[i]=max(n[i],n[j]+1)

        return max(n)

print(lengthOfLIS())