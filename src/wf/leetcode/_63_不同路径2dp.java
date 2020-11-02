package wf.leetcode;

/*

一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class _63_不同路径2dp {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;

        int[][] ens = new int[x][y];
        if (obstacleGrid[0][0] == 1)return 0;
        ens[0][0] = 1;
        for (int i = 1; i < x; i++) {
            if (obstacleGrid[i][0] == 1){
                ens[i][0] = 0;
            }else {
                ens[i][0] = ens[i-1][0];
            }
        }

        for (int i = 1; i < y; i++) {
            if (obstacleGrid[0][i] == 1){
                ens[0][i] = 0;
            }else {
                ens[0][i] = ens[0][i-1];
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (obstacleGrid[i][j] == 0){
                    ens[i][j] = ens[i-1][j] + ens[i][j-1];
                }else if (obstacleGrid[i][j] == 1){
                    ens[i][j] = 0;
                }
            }
        }
        return ens[x-1][y-1];
    }
}
