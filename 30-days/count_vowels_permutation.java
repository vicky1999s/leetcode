/* 
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
*/

package leetcode;

public class count_vowels_permutation {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int res = sol.countVowelPermutation(144);
        System.out.println(res);
    }
}

class Solution2 {
    public int countVowelPermutation(int n) {
        
        long mod = 1000000007;

        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long new_a = 0, new_e = 0, new_i = 0, new_o = 0, new_u = 0;
            
        for (int k=1;k<n;k++){
            new_a = (e+i+u)%mod;
            new_e = (a+i)%mod;
            new_i = (e+o)%mod;
            new_o = i%mod;
            new_u = (o+i)%mod;
            a = new_a;
            e = new_e;
            i = new_i;
            o = new_o;
            u = new_u;
        }

        long res = (a+e+i+o+u)%mod;
        return (int)res;
    }
}