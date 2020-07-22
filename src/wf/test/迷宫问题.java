package wf.test;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/22 14:43
 */
public class 迷宫问题 {

    public static void main(String[] args) {
        int[][] mg = {
                {1,1,1,1,1,1,1,1}
               ,{1,1,0,1,1,1,0,1}
               ,{1,1,1,1,0,1,1,1}
               ,{0,1,0,1,1,0,1,1}
               ,{1,1,0,1,1,1,1,1}
               ,{1,1,1,0,0,1,0,1}
               ,{1,0,1,1,1,0,1,1}
               ,{1,1,1,1,1,1,1,1}
        };

        int n = deep(mg);
        System.out.println(n);
    }

    private static int deep(int[][] mg) {
        int[][] quest = new int[mg.length][mg[0].length];
        for (int i = 0; i < mg.length; i++) {
            for (int j = 0; j < mg[0].length; j++) {
                if (i == (mg.length - 1) || j == (mg[0].length - 1)){
                    quest[i][j] = 1;
                }
            }
        }
        for (int i = mg.length - 2; i >= 0; i--) {
            for (int j = mg[0].length - 2; j >= 0; j--) {
                if (mg[i][j] == 1){
                    quest[i][j] = quest[i + 1][j] + quest[i][j + 1];
                }else if (mg[i][j] == 0){
                    quest[i][j] = 0;
                }
            }
            System.out.println("第" + i + "次--------------------");
            print(quest);
        }

        return quest[0][0];

    }

    private static void print(int[][] mg) {
        for (int i = 0; i < mg.length; i++) {
            for (int j = 0; j < mg[0].length; j++) {
                System.out.print(mg[i][j] + " ");
            }
            System.out.println();
        }
    }
}
