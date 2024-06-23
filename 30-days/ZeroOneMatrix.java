package leetcode;


public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] res = updateMatrix(mat);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
          
    }
    public static int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] temp = new int[r][c];
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                temp[i][j] = mat[i][j];
                if (mat[i][j] == 1){
                    if (j>0)
                        temp[i][j] = temp[i][j] + temp[i][j-1];
                }
                else
                    temp[i][j] = 0;
            }
        }
        for (int i=0;i<c;i++){
            for (int j=0;j<r;j++){
                if (mat[i][j] == 1){
                    if (j>0)
                        mat[j][i] = Math.min(mat[j][i] + mat[j-1][i], temp[j][i]);
                        
                }
            }
        }
        return mat;
    }
}
