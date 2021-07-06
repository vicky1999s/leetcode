/*
    In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
*/

package leetcode;


public class ReshapeTheMatrix {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int[][] mat = {{1,2},{3,4}}; 
        int r = 1; 
        int c = 4;
        int[][] res = sol.matrixReshape(mat, r, c);
        if (res != null){
            for (int i=0;i<r;i++){
                for (int j=0;j<c;j++){
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }

        
    }

}

class Solution3 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if (row*col != r*c)
            return mat;
        else{
            
            int[][] res = new int[r][c];
            int x = 0, y = 0;
            for (int i=0;i<r;i++){
                for (int j=0;j<c;j++){
                    res[i][j] = mat[x][y];
                    y++;
                    if (y==col){
                        x++;
                        y=0;
                    }
                }
            }
            return res;
        }
    }
}