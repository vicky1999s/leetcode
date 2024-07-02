from collections import defaultdict
class Solution:
    def intersect(self, nums1, nums2):
        if len(nums1)>len(nums2):
            nums1,nums2 = nums2,nums1
        cache = defaultdict(int)
        result = []
        for i in nums1:
            cache[i] += 1
        for i in nums2:
            if i in cache and cache[i]>0:
                cache[i] -= 1
                result.append(i)
        return result