class Solution:
    def findLength(self, nums1, nums2):
        l1 = len(nums1)
        l2 = len(nums2)
        arr = [[0 for i in range(l1+1)]for j in range(l2+1)]
        maxi = -1
        for i in range(1,l1+1):
            for j in range(1,l2+1):
                if nums1[i-1]==nums2[j-1]:
                    arr[i][j] = arr[i-1][j-1]+1
                    maxi = max(arr[i][j], maxi)
                else:
                    arr[i][j] = 0
        return maxi


sol = Solution()
x = sol.findLength([1,2,3,2,1],[3,2,1,4,7])
print(x)