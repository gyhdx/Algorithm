package wf.leetcode.面试题;

/*
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

 */
public class _47_礼物的最大价值 {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue(grid));
    }

    public static int maxValue(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] ens = new int[x][y];
        ens[0][0] = grid[0][0];
        for (int i = 1; i < x; i++) {
            ens[i][0] = ens[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < y; i++) {
            ens[0][i] =ens[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                ens[i][j] = Math.max(ens[i][j-1], ens[i-1][j]) + grid[i][j];
            }
        }

        return ens[x-1][y-1];
    }
}
