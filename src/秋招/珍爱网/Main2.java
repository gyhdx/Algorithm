package 秋招.珍爱网;

public class Main2 {

    public static void main(String[] args) {
        int[] a = {20,30,20};
        System.out.println(saveZhenaiCoin(a));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param grid int整型一维数组
     * @return int整型
     */
    public static int saveZhenaiCoin (int[] grid) {
        // write code here
        long ens = 0;
        for (int i = 2; i < grid.length; i++) {
            grid[i] = grid[i] + Math.min(grid[i - 1],grid[i-2]);
        }
        return Math.min(grid[grid.length - 1], grid[grid.length -2]);
    }
}
