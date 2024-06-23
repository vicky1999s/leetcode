package leetcode;

public class NonNegativeIntegers {
    public static void main(String[] args) {
        System.out.println(findIntegers(30));
    }

    public static int findIntegers(int n) {
        int[] arr = new int[31];
        arr[0] = 1;
        arr[1] = 2;
        for (int i=2;i<31;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        int ans=0, k=30, pre_bit=0;
        while(k>0){
            if (((1<<k) & n) >= 0){
                ans += arr[k];
                if (pre_bit==1)
                    return ans;
                pre_bit=1;
            }
            else
                pre_bit=0;
            --k;
        }
        return ans + 1;
    }
}
