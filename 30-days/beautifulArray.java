package leetcode;

import java.util.*;

public class beautifulArray {
    public static void main(String[] args) {
        int n=5;
        System.out.println(beautifulArray1(n));
    }
    public static int[] beautifulArray1(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        while(ans.size()<n){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : ans){
                if (2*i - 1 <= n)
                    temp.add(2*i - 1);
            }
            for (int i : ans){
                if (2*i <= n)
                    temp.add(2*i);
            }
            ans = temp;
        }
        int[] res = new int[n];
        for (int i=0;i<n;i++)
            res[i] = ans.get(i);
        return res;
    }
}
