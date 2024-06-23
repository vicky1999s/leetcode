/*
You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the same binary value.

If it is possible, return any [i, j] with i + 1 < j, such that:

arr[0], arr[1], ..., arr[i] is the first part,
arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
All three parts have equal binary values.
If it is not possible, return [-1, -1].

Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.

Input: arr = [1,0,1,0,1]
Output: [0,3]
*/

package leetcode;

public class ThreeEqualParts {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        var res = threeEqualParts(arr);
        for (int i:res)System.out.println(i);
    }
    public static int[] threeEqualParts(int[] arr) {
        int sum = 0;
        for (int i:arr)
            sum+=i;
        if (sum%3 != 0){
            return new int[]{-1, -1};
        }  else if (sum==0)
            return new int[]{0,2};
        else {
            int target = sum/3;
            int first=-1,second=-1,third=-1;
            int numOfOnes=0;
            for (int i=0;third==-1;i++){
                if (arr[i]==1)
                    numOfOnes++;
                if (numOfOnes == target + 1 && second==-1)
                    second = i;
                else if(numOfOnes == 2*target + 1 && third==-1)
                    third = i;
                else if(numOfOnes == 1 && first==-1) 
                    first = i;
            }
            while(third<arr.length){
                if(arr[first]==arr[second] && arr[second] == arr[third]){
                    third++;
                    first++;
                    second++;
                }
                else{
                    return new int[]{-1, -1};
                }
                
            }
            return new int[]{first-1, second};
        }
    }
}
