package leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int maxi = -1;
        for (int i=0;i<len;i++){
            if (height[i]>maxi)
                maxi = height[i];
            left[i] = maxi;
        }
        maxi = -1;
        for (int i=len-1;i>=0;i--){
            if (height[i]>maxi)
                maxi = height[i];
            right[i] = maxi;
        }
        int res = 0;
        for (int i=0;i<len;i++){
            res += Math.min(left[i], right[i])-height[i];
        }
        return res;
    }
}
