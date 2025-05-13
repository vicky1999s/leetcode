"""
If arr[mid] > arr[high], it means arr[low … mid] is sorted and we need to search in the right half. So we change low = mid + 1.
If arr[mid] <= arr[high], it means arr[mid … high] is sorted and we need to search in the left half. So we change high = mid. (Note: Current mid might be the minimum element).
"""
class Solution:
    def findMin(self, nums) -> int:
        l, r = 0, len(nums)-1
        while l<=r:
            mid = (l+r)//2
            if nums[mid] <= nums[r]:
                r = mid
            else:
                l = mid+1
        return nums[l]
