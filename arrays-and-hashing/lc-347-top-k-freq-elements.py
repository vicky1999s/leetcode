from collections import defaultdict
class Solution:
    def topKFrequent(self, nums, k: int):
        d = defaultdict(int)
        for i in nums:
            d[i]+=1
        items = sorted(d.items(), key=lambda x:x[1], reverse=True)
        result = []
        for i in range(k):
            result.append(items[i][0])
        print(result)

        

nums = [1,1,1,2,2,3]; k = 2
s = Solution()
s.topKFrequent(nums,k)