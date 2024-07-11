class Solution:
    def trap(self, height):
        left, right = 0, len(height)-1
        max_left, max_right, ans = 0, 0, 0
        while left<right:
            if height[left] < height[right]:
                if height[left] > max_left:
                    max_left=height[left]
                else:
                    ans += max_left-height[left]
                left+=1
            else:
                if height[right] > max_right:
                    max_right = height[right]
                else:
                    ans += max_right-height[right]
                right-=1
        print(ans)
        

s = Solution()
height = [4,2,0,3,2,5]
s.trap(height)

