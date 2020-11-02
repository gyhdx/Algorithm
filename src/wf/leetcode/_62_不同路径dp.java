package wf.leetcode;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

 */
public class _62_不同路径dp {


    /*
    逆推法：
     */
    public int uniquePaths(int m, int n) {
        int[][] mid = new int[m][n];

        for (int i = 0; i < m; i++) {
            mid[i][n-1] = 1;
        }
        for (int i = 0; i < n; i++) {
            mid[m-1][i] = 1;
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                mid[i][j] = mid[i+1][j] + mid[i][j+1];
            }
        }

        return mid[0][0];
    }
}
