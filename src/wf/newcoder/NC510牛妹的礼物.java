package wf.newcoder;

/*
题目描述
众所周知，牛妹有很多很多粉丝，粉丝送了很多很多礼物给牛妹，牛妹的礼物摆满了地板。
地板是N\times MN×M的格子，每个格子有且只有一个礼物，牛妹已知每个礼物的体积。
地板的坐标是左上角(1,1)  右下角（N, M）。
牛妹只想要从屋子左上角走到右下角，每次走一步，每步只能向下走一步或者向右走一步或者向右下走一步
每次走过一个格子，拿起（并且必须拿上）这个格子上的礼物。
牛妹想知道，她能走到最后拿起的所有礼物体积最小和是多少？
 */
public class NC510牛妹的礼物 {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{2,3,4}};
        System.out.println(selectPresent(arr));
    }

    /**
     * @param arr int整型二维数组 N*M的矩阵，每个元素是这个地板砖上的礼物体积
     * @return int整型
     */
    public static int selectPresent(int[][] arr) {
        // write code here

        int i = arr.length-1;
        int j = arr[0].length-1;
        for (int k = i-1; k >=0; k++) {
            arr[k][j] += arr[k+1][j];
        }
        int ens = arr[i][j];
        while (i > 0 && j > 0) {
            if (arr[i-1][j]<arr[i][j-1]&&arr[i-1][j]<arr[i-1][j-1]){
                ens+=arr[--i][j];
            }else if (arr[i][j-1]<arr[i-1][j-1]){
                ens+=arr[i][--j];
            }else {
                ens+=arr[--i][--j];
            }
        }

        return ens;
    }
}
