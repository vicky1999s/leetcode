/**
 * There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 */

package leetcode;

public class PushDominoes {
    public static void main(String[] args) {
        String dominoes = "...RL....R.L.L........RR......L....R.L.....R.L..RL....R....R......R.......................LR.R..L.R.";
        System.out.println(pushDominoes(dominoes));

    }
    public static String pushDominoes(String dominoes) {
        String res = "";
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int nearestLeftIndex=-1, nearestRightIndex=-1;
        for (int i=n-1,j=0;i>=0&&j<n;i--,j++){
            if (dominoes.charAt(i)=='L')
                nearestLeftIndex = i;
            else if(dominoes.charAt(i)=='R')
                nearestLeftIndex = -1;
            left[i] = nearestLeftIndex;
            if (dominoes.charAt(j)=='R')
                nearestRightIndex = i;
            else if(dominoes.charAt(j)=='L')
                nearestRightIndex = -1;
            right[j] = nearestRightIndex;
        }

        for (int i=0;i<n;i++){
            if (dominoes.charAt(i)=='.'){
                int leftDiff = left[i]==-1?Integer.MAX_VALUE:Math.abs(left[i]-i);
                int rightDiff = right[i]==-1?Integer.MAX_VALUE:Math.abs(right[i]-i);
                if (leftDiff == rightDiff)
                    res += '.';
                else if(leftDiff<rightDiff)
                    res += 'L';
                else if (rightDiff<leftDiff)
                    res += 'R';

            }
            else{
                res += dominoes.charAt(i);
            }
        } 

        return res;
    }
    
}
