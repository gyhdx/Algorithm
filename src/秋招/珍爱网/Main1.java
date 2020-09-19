package 秋招.珍爱网;


public class Main1 {

    public static void main(String[] args) {
        int[] a = {0,0,0};
        System.out.println(parking(a,2));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param park int整型一维数组 停有车辆的一排车位
     * @param n int整型 想停入的n辆车
     * @return bool布尔型
     */
    public static boolean parking (int[] park, int n) {
        // write code here
        boolean flag = true;
        if (park == null || park.length <= 2)return false;
        int count = 0;

//        if ();


        if (flag)count = (park.length + 1)/2;
        if (count >= n)return true;
        return false;
    }
}
