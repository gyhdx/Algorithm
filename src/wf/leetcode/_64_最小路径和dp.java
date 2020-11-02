package wf.leetcode;

/*
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
 */
public class _64_最小路径和dp {

    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        if (x == 0 && y == 0) return 0;
        int[][] ens = new int[x][y];

        ens[0][0] = grid[0][0];
        for (int i = 1; i < x; i++) {
            ens[i][0] = grid[i][0] + ens[i - 1][0];
        }

        for (int i = 1; i < y; i++) {
            ens[0][i] = grid[0][i] + ens[0][i - 1];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                ens[i][j] = Math.min(ens[i - 1][j], ens[i][j - 1]) + grid[i][j];
            }
        }
        return ens[x - 1][y - 1];
    }
}
