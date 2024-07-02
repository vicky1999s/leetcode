class Solution:
    def threeConsecutiveOdds(self, arr) -> bool:
        for i in range(len(arr)-2):
            if arr[i]%2 + arr[i+1]%2 + arr[i+2]%2 == 3:
                return True
        return False


arr = [1,2,34,3,4,5,7,23,12]
s = Solution()
print(s.threeConsecutiveOdds(arr))
        