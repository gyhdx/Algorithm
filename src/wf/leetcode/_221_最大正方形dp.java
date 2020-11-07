package wf.leetcode;

/*
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class _221_最大正方形dp {


    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0);

        int x = matrix.length;
        int y = matrix[0].length;

        int[][] mid = new int[x][y];
        int ens = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        mid[i][j] = 1;
                    } else {
                        mid[i][j] = Math.min(Math.min(mid[i - 1][j],mid[i-1][j-1]), mid[i][j - 1]) + 1;
                    }
                }
                ens = Math.max(ens, mid[i][j]);
            }
        }
        return ens * ens;
    }
}
